var app = angular.module('tintucApp', []);
app.controller('tintucCtrl', function ($scope, $http,$rootScope) {


  document.getElementById("dadangnhap").style.display = "none";
  $rootScope.session = window.localStorage.getItem("SessionId");
  $rootScope.namekh = window.localStorage.getItem("ten");
  $rootScope.isLoggedIn = window.localStorage.getItem("isLoggedIn");
  // var idnd = window.localStorage.getItem("idnd");

  if ($rootScope.isLoggedIn == null || $rootScope.isLoggedIn == undefined) {
    document.getElementById("dadangnhap").style.display = "none";

  }
  else {
    document.getElementById("dadangnhap").style.display = "block";
    document.getElementById("chuadangnhap").style.display = "none";
  }

  $scope.dangxuat = function () {
    window.localStorage.clear();
    $rootScope.isLoggedIn = false;
    location.href = "http://127.0.0.1:5501/realand/trangchu.html";

  };

  $http({
    method: "GET",
    url: "http://localhost:9090/tintucs"
  }).then(function mySuccess(response) {
    $scope.tintucs = response.data;
  }, function myError(response) {
    $scope.tintucs = response.statusText;
  });



  
  // alert("dfsd");
  // $scope.edittintuc=function(x){
  //   // alert(x.idSanphamcty);
  //   window.open('http://127.0.0.1:5501/updatetintuc.html?id='+x.idTintuc, '_blank');
  // }


});