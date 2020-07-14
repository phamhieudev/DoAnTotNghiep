var app = angular.module('chitiettintucApp',['ckeditor']);
app.controller('chitiettintucCtrl', function ($scope, $http, $rootScope) {

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

$scope.data = {
    options: {
      language: 'en',
      allowedContent: true,
      entities: false
    }
  };
  var id = location.search.split('id=')[1];
  var idhinhcu;
  $http({
    method: "GET",
    url: "http://localhost:9090/tintuc/" + id
  }).then(function mySuccess(response) {
    $scope.details = response.data;
    var track = $scope.details;
    $scope.tentintuc = track.tenTintuc;
    $scope.text = track.noidungTintuc;
    $scope.hinhAnh = track.hinhanhtintuc.url;
    $scope.ngaydang = track.ngaydangTintuc;
    document.getElementById("noidn").innerHTML=track.noidungTintuc;
  });


});