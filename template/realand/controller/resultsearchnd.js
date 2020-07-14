var app = angular.module('searchresultnguoidungApp', []);
app.controller('searchresultnguoidungCtrl', function ($scope, $http,$rootScope) {

  document.getElementById("dadangnhap").style.display="none";
  $rootScope.session = window.localStorage.getItem("SessionId");
  $rootScope.namekh = window.localStorage.getItem("ten");
  $rootScope.isLoggedIn = window.localStorage.getItem("isLoggedIn");
  // $scope.check = checkAuth.getuserInfo();
  // var idnd = window.localStorage.getItem("idnd");


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

  var trangthai=1
  var idLoaisp = window.localStorage.getItem("idLoaispnd");
  var idVungxa = window.localStorage.getItem("idVungxand");
  var idDonvigia = window.localStorage.getItem("idDonvigiand");
  var nhonhat = window.localStorage.getItem("nhonhatnd");
  var lonnhat = window.localStorage.getItem("lonnhatnd");

  $http({
    method: "GET",
    url: 'http://localhost:9090/sanphamnguoidungtukhoanull/'+trangthai+'/'+idLoaisp+'/'+idVungxa+'/'+idDonvigia+'/'+nhonhat+'/'+lonnhat+'/'+1
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
      window.localStorage.setItem("tongketquand", tong);
      $scope.tongketquand=tong;

  });
});
