var app = angular.module('sanphamnguoidungApp', []);
app.factory("checkAuth", function ($location, $rootScope) {
  return {
    getuserInfo: function () {
      if ($rootScope.isLoggedInadmin === undefined || $rootScope.isLoggedIn === null) {
        //$location.path('/login');
        location.href = "http://127.0.0.1:5501/login.html";
      }

    }
  };
});
app.controller('sanphamnguoidungCtrl', function ($scope, $http,checkAuth,$rootScope) {

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
  // lấy Dữ Liệu
  // $http({
  //   method: "GET",
  //   url: "http://localhost:9090/sanphamnguoidungs"
  // }).then(function mySuccess(response) {
  //   $scope.sanphamnguoidungs = response.data;
  // }, function myError(response) {
  //   $scope.sanphamnguoidungs = response.statusText;
  // });
  document.getElementById("show").style.display="none";
  document.getElementById("show1").style.display="none";
  $http({
    method: "GET",
    url: "http://localhost:9090/Trangthaigds"
  }).then(function mySuccess(response) {
    $scope.Trangthaigds = response.data;
  }, function myError(response) {
    $scope.Trangthaigds = response.statusText;
  });
  $scope.myFuncLoai=function(idTrangthaigd){

    if(idTrangthaigd==1){
      document.getElementById("show").style.display="block";
      document.getElementById("show1").style.display="none";
        $http({
      method: "GET",
      url: "http://localhost:9090/findbyidtrangthaigdnd/1"
    }).then(function mySuccess(response) {
      $scope.sanphamnguoidungs = response.data;
    }, function myError(response) {
      $scope.sanphamnguoidungs = response.statusText;
    });
    }
    else{
      document.getElementById("show").style.display="none";
      document.getElementById("show1").style.display="block";
        $http({
      method: "GET",
      url: "http://localhost:9090/findbyidtrangthaigdnd/2"
    }).then(function mySuccess(response) {
      $scope.sanphamnguoidungs = response.data;
    }, function myError(response) {
      $scope.sanphamnguoidungs = response.statusText;
    });
    }
  
  }

  $scope.xembaidang=function(x)
  {
    window.open('http://127.0.0.1:5501/realand/chitietsanphamcnguoidung.html?id=' + x.idSanphamnguoidung + '', '_blank');
  }

  $scope.xoasanpham = function (sanpham)////Khi bấm vào nút DELETE
  {
    var id = sanpham.idSanphamnguoidung;
    var manghinh = [];
    var r = confirm("Bạn Chắc Chắn Xóa ?");
    if (r == true) {
  
      $http({
        method: "GET",
        url: "http://localhost:9090/findbyidspnd/" + id
      }).then(function mySuccess(response) {
        $scope.idhinhs = response.data;
        var track = $scope.idhinhs;
        var lennght = track.length;
        for (var i = 0; i < lennght; i++) {
          manghinh.push(track[i].idHinh);
        }
         console.log(manghinh);
        var lennghtmanghinh = manghinh.length;
        if(lennghtmanghinh<0)
        {
          for (var y = 0; y < lennghtmanghinh; y++) {
            $http({
              method: 'DELETE',
              url: 'http://localhost:9090/xoaHinhanhchitietspnd/' + manghinh[y]
            })
    
              $http({
                method: 'DELETE',
                url: 'http://localhost:9090/xoasanphamnguoidung/' + id
              })
              alert("Xóa Thành Công");
              window.location.reload();
          
          }
        }
        else
        {
          $http({
            method: 'DELETE',
            url: 'http://localhost:9090/xoasanphamnguoidung/' + id
          })
          alert("Xóa Thành Công");
          window.location.reload();
        }
       
       
      }, function myError(response) {
        $scope.idhinhs = response.statusText;
      });
    
    }
    else {
      alert("Xóa Thất Bại");
      // window.location.reload();
    }
  };
});