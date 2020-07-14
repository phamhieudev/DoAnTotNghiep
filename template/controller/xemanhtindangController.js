var app = angular.module('xemanhtindangApp', []);
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
app.controller('xemanhtindangCtrl', function ($scope, $http, $rootScope, checkAuth) {

  $rootScope.nameadmin = window.localStorage.getItem("tenadmin");
  $rootScope.isLoggedInadmin = window.localStorage.getItem("isLoggedInadmin");
  $rootScope.isLoggedInadmin = window.localStorage.getItem("isLoggedInadmin");
  $scope.check = checkAuth.getuserInfo();

  if ($rootScope.roleadmin == 2) {
    document.getElementById("admin").style.display = 'none';
  }

  $scope.logout = function () {
    window.localStorage.clear();
    $rootScope.isLoggedIn = false;
    location.href = "http://127.0.0.1:5501/login.html";

  };

  var idtinchodueyt = location.search.split('id=')[1];


  $http({
    method: "GET",
    url: "http://localhost:9090/sanphamnguoidung/" + idtinchodueyt
  }).then(function mySuccess(response) {
    $scope.sanphamnguoidungs = response.data;
    var track = $scope.sanphamnguoidungs;
    $scope.tensanpham = track.nameSanphamnguoidung;
  }, function myError(response) {
    $scope.sanphamnguoidungs = response.statusText;
  });

  $http({
    method: "GET",
    url: "http://localhost:9090/findbyidspnd/" + idtinchodueyt
  }).then(function mySuccess(response) {
    $scope.hinhanhs = response.data;
  }, function myError(response) {
    $scope.hinhanhs = response.statusText;
  });


 


});


