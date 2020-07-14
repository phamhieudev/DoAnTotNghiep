var app = angular.module('bdsyeuthichApp', []);
app.controller('bdsyeuthichCtrl', function ($scope, $http,$rootScope) {

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


 $http({
    method: "GET",
    url: "http://localhost:9090/findyeuthichnguoidung/" + idnd //cty
  }).then(function mySuccess(response) {
    $scope.ctys = response.data;
  });

  $http({
    method: "GET",
    url: "http://localhost:9090/findyeuthichnguoidungnd/" + idnd //nguoidung
  }).then(function mySuccess(response) {
    $scope.nguoidungs = response.data;
  });

  $scope.xoakhachdang=function(id){
    var r = confirm("Bạn Chắc Chắn Xóa ?");
    if (r == true) {
      $http({
        method: 'DELETE',
        url: 'http://localhost:9090/xoasanphamyeuthichnguoidung/' + id
      })
      alert("Xóa Thành Công");
      window.location.reload();
    }
    else {
      alert("Xóa Thất Bại");
      window.location.reload();
    } 
  }

  $scope.xoactydang=function(id){
    var r = confirm("Bạn Chắc Chắn Xóa ?");
    if (r == true) {
      $http({
        method: 'DELETE',
        url: 'http://localhost:9090/xoasanphamyeuthichcty/' + id
      })
      alert("Xóa Thành Công");
      window.location.reload();
    }
    else {
      alert("Xóa Thất Bại");
      window.location.reload();
    } 
  }
});


