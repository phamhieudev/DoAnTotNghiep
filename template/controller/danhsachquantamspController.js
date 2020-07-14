var app = angular.module('danhsachquantamspApp', []);
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

app.controller('danhsachquantamspCtrl', function ($scope, $http,checkAuth,$rootScope) {
  // $rootScope.sessionadmin = window.localStorage.getItem("SessionIdadmin");
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
  $http({
    method: "GET",
    url: "http://localhost:9090/quantamsanphamctys"
  }).then(function mySuccess(response) {
    $scope.duongs = response.data;
  }, function myError(response) {
    $scope.duongs = response.statusText;
  });

});

