var app = angular.module('thongtincanhnaApp', []);
app.controller('thongtincanhanCtrl', function ($scope, $http, $rootScope) {

  document.getElementById("dadangnhap").style.display = "none";
  $rootScope.session = window.localStorage.getItem("SessionId");
  $rootScope.namekh = window.localStorage.getItem("ten");
  $rootScope.isLoggedIn = window.localStorage.getItem("isLoggedIn");
  var idnd = window.localStorage.getItem("idnd");

  if ($rootScope.isLoggedIn == null || $rootScope.isLoggedIn == undefined) {
    document.getElementById("dadangnhap").style.display = "none";
    location.href = "http://127.0.0.1:5501/realand/sign_up.html";

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

  var xyz;
  $http({
    method: "GET",
    url: "http://localhost:9090/nguoidung/" + idnd
  }).then(function mySuccess(response) {
    $scope.nguoidungs = response.data;
    var track = $scope.nguoidungs;
    // console.log(track);
    $scope.ten = track.tenNguoidung;
    $scope.mail = track.mail;
    $scope.sdt = track.phone;
    xyz = track.password;
  });

  $scope.capnhatthongtin = function (ten, sdt, mail) {
    var data = {
      password: xyz,
      mail: mail,
      phone: sdt,
      tenNguoidung: ten
    }
    $http.put('http://localhost:9090/updatenguoidung/' + idnd, JSON.stringify(data)).then(function (response) {
      if (response.data) {
        // 
      }
    }, function (response) {
      alert("Cập Nhật Thành Công");
    });
  }

});


