var app = angular.module('trangcanhanApp', []);
app.controller('trangcanhanCtrl', function ($scope, $http,$rootScope) {

  document.getElementById("dadangnhap").style.display="none";
  $rootScope.session = window.localStorage.getItem("SessionId");
  $rootScope.namekh = window.localStorage.getItem("ten");
  $rootScope.isLoggedIn = window.localStorage.getItem("isLoggedIn");

  var idnd = window.localStorage.getItem("idnd");

  // $scope.check = checkAuth.getuserInfo();

  if( $rootScope.isLoggedIn==null ||  $rootScope.isLoggedIn==undefined)
  {
    document.getElementById("dadangnhap").style.display="none";
  }
  else{
    document.getElementById("dadangnhap").style.display="block";
    document.getElementById("chuadangnhap").style.display="none";
  }

  $scope.dangxuat = function () {
    window.localStorage.clear();
    $rootScope.isLoggedIn = false;
    location.href = "http://127.0.0.1:5501/realand/trangchu.html";
 };

 var idchutrang = location.search.split('id=')[1];
 $http({
  method: "GET",
  url: "http://localhost:9090/nguoidung/" + idchutrang
}).then(function mySuccess(response) {
  $scope.details = response.data;
  var track = $scope.details;
  $scope.ten = track.tenNguoidung;
  $scope.phone = track.phone;
  $scope.mail = track.mail;
});

// get chưa bán
$http({
  method: "GET",
  url: 'http://localhost:9090/sanphamnguoidungtheoidnguoidung/' + 1 + '/' + 1 + '/' + idchutrang
}).then(function mySuccess(response) {
  $scope.chuabans = response.data;
});

/// get đã bán
$http({
  method: "GET",
  url: 'http://localhost:9090/sanphamnguoidungtheoidnguoidung/' + 2 + '/' + 1 + '/' + idchutrang
}).then(function mySuccess(response) {
  $scope.dabans = response.data;
});



 
});


