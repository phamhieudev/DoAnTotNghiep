var app = angular.module('tintucApp', ['ckeditor']);
app.factory("checkAuth", function ($location, $rootScope) {
  return {
    getuserInfo: function () {
      if ($rootScope.isLoggedInadmin === undefined || $rootScope.isLoggedInadmin === null) {
        //$location.path('/login');
        location.href = "http://127.0.0.1:5501/login.html";
      }

    }
  };
});
app.controller('tintucCtrl', function ($scope, $http,checkAuth,$rootScope) {
  $rootScope.nameadmin = window.localStorage.getItem("tenadmin");
  $rootScope.isLoggedInadmin = window.localStorage.getItem("isLoggedInadmin");
  $rootScope.isLoggedInadmin = window.localStorage.getItem("isLoggedInadmin");
  $scope.check = checkAuth.getuserInfo();

if($rootScope.roleadmin==2){
  document.getElementById("admin").style.display='none';
}

  $scope.logout = function () {
     window.localStorage.clear();
     $rootScope.isLoggedIn = false;
     location.href = "http://127.0.0.1:5501/login.html";
    
  };

  $http({
    method: "GET",
    url: "http://localhost:9090/tintucs"
  }).then(function mySuccess(response) {
    $scope.tintucs = response.data;
  }, function myError(response) {
    $scope.tintucs = response.statusText;
  });

  $scope.edittintuc=function(x){
    // alert(x.idSanphamcty);
    window.open('http://127.0.0.1:5501/updatetintuc.html?id='+x.idTintuc, '_blank');
  }
  $scope.xembaiviet=function(x)
  {
    window.open('http://127.0.0.1:5501/realand/chitiettintuc.html?id=' + x.idTintuc + '', '_blank');
  }
  $scope.xoatintuc =function(x){
    {
      var id = x.idTintuc;
      var r = confirm("Bạn Chắc Chắn Xóa ?");
      if (r == true) {
        // $http({
        //   method: 'DELETE',
        //   url: 'http://localhost:9090/xoanguoidung/' + id
        // })
        alert("Xóa Thành Công");
        window.location.reload();
      }
      else {
        alert("Xóa Thất Bại");
        window.location.reload();
      } 
    };
  }

});