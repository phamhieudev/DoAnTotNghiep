var app = angular.module('searchresultctyApp', []);
app.controller('searchresultctyCtrl', function ($scope, $http,$rootScope) {

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

  var tukhoa = window.localStorage.getItem("tukhoacty");
  var idLoaisp = window.localStorage.getItem("idLoaispcty");
  var idVungxa = window.localStorage.getItem("idVungxacty");
  var idDonvigia = window.localStorage.getItem("idDonvigiacty");
  var nhonhat = window.localStorage.getItem("nhonhatcty");
  var lonnhat = window.localStorage.getItem("lonnhatcty");

  $http({
    method: "GET",
    url: 'http://localhost:9090/searchspcty/'+idLoaisp+'/'+idVungxa+'/'+idDonvigia+'/'+nhonhat+'/'+lonnhat+'/'+tukhoa
  }).then(function mySuccess(response) {
    $scope.result = response.data;
    var result1=$scope.result;
    var tong = 0;
      angular.forEach($scope.result, function (item) {
        $scope.loai=item.loaisanpham.tenLoaisp;
        $scope.vungxa=item.vungxa.tenVungxa;
        $scope.nhonhat=nhonhat;
        $scope.donvigia=item.donvigia.tenDonvigia;
        $scope.lonnhat=lonnhat;
        tong = tong +1;
      })
      $scope.tongketquand=tong;

  });
});
