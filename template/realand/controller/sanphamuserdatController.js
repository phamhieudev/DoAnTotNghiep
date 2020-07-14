var app = angular.module('sanphamuserdatApp', []);

app.controller('sanphamuserdatCtrl', function ($scope, $http,$rootScope) {

  document.getElementById("dadangnhap").style.display="none";
  $rootScope.session = window.localStorage.getItem("SessionId");
  $rootScope.namekh = window.localStorage.getItem("ten");
  $rootScope.isLoggedIn = window.localStorage.getItem("isLoggedIn");
  // $scope.check = checkAuth.getuserInfo();

  if( $rootScope.isLoggedIn==null ||  $rootScope.isLoggedIn==undefined)
  {
    document.getElementById("dadangnhap").style.display="none";
  }
  else{
    document.getElementById("dadangnhap").style.display="block";
    document.getElementById("chuadangnhap").style.display="none";
  }


  // lấy Dữ Liệu
  $http({
    method: "GET",
    url: "http://localhost:9090/sanphamnguoidungtheonha/2/1/1"
  }).then(function mySuccess(response) {
    $scope.sanphamnguoidungs = response.data;
  }, function myError(response) {
    $scope.sanphamnguoidungs = response.statusText;
  });

  $scope.dangxuat = function () {
    window.localStorage.clear();
    $rootScope.isLoggedIn = false;
    location.href = "http://127.0.0.1:5501/realand/trangchu.html";
 };
  // $scope.chuyentragchitiet=function(x){
  //   window.open('http://127.0.0.1:5501/aler/chitietsanphamnguoidung.html', '_parent');
  //   window.localStorage.setItem("idspnguoidung",x.idSanphamnguoidung);

  //  // alert(x.idSanphamnguoidung);
  // }


 
});
