var app = angular.module('trangchuApp', []);
app.factory("checkAuth", function ($location, $rootScope) {
  return {
    getuserInfo: function () {
      if ($rootScope.isLoggedIn === undefined || $rootScope.isLoggedIn === null) {
        //$location.path('/login');
        location.href = "http://127.0.0.1:5501/realand/sign_up.html";
      }

    }
  };
});
app.controller('trangchuCtrl', function ($scope, $http,$rootScope) {
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

  $scope.nhonhat=" ";
  $scope.lonnhat=" ";

  $scope.timkiem = function (nhonhat, lonnhat) {
    var ai = document.getElementById("ai").value;
    var idLoaisp = document.getElementById("idLoaisp").value;
    var idVungxa = document.getElementById("idVungxa").value;
    var idDonvigia = document.getElementById("idDonvigia").value;
   if (nhonhat == null) {
      alert("Bạn vui lòng nhập giá trị nhỏ nhất");
    }
    else if (lonnhat == null) {
      alert("Bạn vui lòng nhập giá trị lớn nhất");
    }
    else {
      if (ai == 1)/// công ty
      {
        window.open('http://127.0.0.1:5501/realand/ketquatimkiemcongty.html', '_parent');
        window.localStorage.setItem("idLoaispcty", idLoaisp);
        window.localStorage.setItem("idVungxacty", idVungxa);
        window.localStorage.setItem("idDonvigiacty", idDonvigia);
        window.localStorage.setItem("nhonhatcty", nhonhat);
        window.localStorage.setItem("lonnhatcty", lonnhat);
      }
      else {
        window.open('http://127.0.0.1:5501/realand/ketquatimkiemnguoidung.html', '_parent');
        window.localStorage.setItem("idLoaispnd", idLoaisp);
        window.localStorage.setItem("idVungxand", idVungxa);
        window.localStorage.setItem("idDonvigiand", idDonvigia);
        window.localStorage.setItem("nhonhatnd", nhonhat);
        window.localStorage.setItem("lonnhatnd", lonnhat);
      }
    }
  }

  $scope.dangxuat = function () {
    window.localStorage.clear();
    $rootScope.isLoggedIn = false;
    location.href = "http://127.0.0.1:5501/realand/trangchu.html";
   
 };
});


