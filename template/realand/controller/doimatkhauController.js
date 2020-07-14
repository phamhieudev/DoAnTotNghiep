var app = angular.module('doimatkhauApp', []);
app.controller('doimatkhauCtrl', function ($scope, $http, $rootScope) {

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
  var ten;
  var mail;
  var sdt;
  $http({
    method: "GET",
    url: "http://localhost:9090/nguoidung/" + idnd
  }).then(function mySuccess(response) {
    $scope.nguoidungs = response.data;
    var track = $scope.nguoidungs;
    // console.log(track);
    ten = track.tenNguoidung;
    mail = track.mail;
    sdt = track.phone;
    xyz = track.password;
  });

  $scope.doimatkhau = function (passhientai,passnew) {
    var passhientaimd5 = CryptoJS.MD5(passhientai);
    var passnewmd5 = CryptoJS.MD5(passnew);
    var b = String(passnewmd5);
    if(passhientaimd5 != xyz){
      alert("Mật Khẩu Hiện Tại Không Đúng");
    }
    else{
         var data = {
    password: b,
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

  }

});


