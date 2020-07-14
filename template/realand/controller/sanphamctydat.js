var app = angular.module('sanphamctydatApp', []);

app.controller('sanphamctydatCtrl', function ($scope, $http,$rootScope) {
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
  
  $scope.dangxuat = function () {
    window.localStorage.clear();
    $rootScope.isLoggedIn = false;
    location.href = "http://127.0.0.1:5501/realand/trangchu.html";
 };

  document.getElementById("dadangnhap").style.display="none";
  $rootScope.session = window.localStorage.getItem("SessionId");
  $rootScope.namekh = window.localStorage.getItem("ten");
  $rootScope.isLoggedIn = window.localStorage.getItem("isLoggedIn");

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
    url: "http://localhost:9090/sanphamctytheoloaitrangthaigd/2/1"
  }).then(function mySuccess(response) {
    $scope.sanphamctys = response.data;
  }, function myError(response) {
    $scope.sanphamctys = response.statusText;
  });

  // $scope.chuyentragchitiet=function(x){
  //   window.open('http://127.0.0.1:5501/aler/chitietsanphamnhacty.html', '_blank');
  //   window.localStorage.setItem("idspnhacty",x.idSanphamcty);
  // }


 
});
