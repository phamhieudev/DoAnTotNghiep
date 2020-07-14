var app = angular.module('sanphamctyApp', []);
app.factory("checkAuth", function ($location, $rootScope) {
  return {
    getuserInfo: function () {
      if ($rootScope.isLoggedInadmin === undefined || $rootScope.isLoggedInadmin === null) {
        //$location.path('/login');
        location.href = "http://127.0.0.1:5501/login.html";
      }

    }
  };
});
app.controller('sanphamctyCtrl', function ($scope, $http, checkAuth, $rootScope) {

  $rootScope.nameadmin = window.localStorage.getItem("tenadmin");
  $rootScope.isLoggedInadmin = window.localStorage.getItem("isLoggedInadmin");
  $rootScope.isLoggedInadmin = window.localStorage.getItem("isLoggedInadmin");
  $scope.check = checkAuth.getuserInfo();

  if ($rootScope.roleadmin == 2) {
    document.getElementById("admin").style.display = 'none';
  }

  $scope.logout = function () {
    window.localStorage.clear();
    $rootScope.isLoggedIn = false;
    location.href = "http://127.0.0.1:5501/login.html";

  }; 
  document.getElementById("show").style.display="none";
  document.getElementById("show1").style.display="none";
  // lấy Dữ Liệu
  // $http({
  //   method: "GET",
  //   url: "http://localhost:9090/findbyidtrangthaigd/1"
  // }).then(function mySuccess(response) {
  //   $scope.sanphamctys = response.data;
  // }, function myError(response) {
  //   $scope.sanphamctys = response.statusText;
  // });
    $http({
    method: "GET",
    url: "http://localhost:9090/Trangthaigds"
  }).then(function mySuccess(response) {
    $scope.Trangthaigds = response.data;
  }, function myError(response) {
    $scope.Trangthaigds = response.statusText;
  });
$scope.myFuncLoai=function(idTrangthaigd){

  if(idTrangthaigd==1){
    document.getElementById("show").style.display="block";
    document.getElementById("show1").style.display="none";
      $http({
    method: "GET",
    url: "http://localhost:9090/findbyidtrangthaigd/1"
  }).then(function mySuccess(response) {
    $scope.sanphamctys = response.data;
  }, function myError(response) {
    $scope.sanphamctys = response.statusText;
  });
  }
  else{
    document.getElementById("show").style.display="none";
    document.getElementById("show1").style.display="block";
      $http({
    method: "GET",
    url: "http://localhost:9090/findbyidtrangthaigd/2"
  }).then(function mySuccess(response) {
    $scope.sanphamctys = response.data;
  }, function myError(response) {
    $scope.sanphamctys = response.statusText;
  });
  }

}
  $scope.editsanphamcty = function (x) {
    // alert(x.idSanphamcty);
    window.open('http://127.0.0.1:5501/updatesanphamcty.html?id=' + x.idSanphamcty + '', '_blank');
  }
  $scope.edithinhanhsanphamcty = function (x) {
    // alert(x.idSanphamcty);
    window.open('http://127.0.0.1:5501/updatehinhanhsanphamcty.html?id=' + x.idSanphamcty + '', '_blank');
  }
  $scope.dagiaodich = function (sanpham)////Khi bấm vào nút DELETE
  {
    var tdxcucty=sanpham.lonSanpham_cty;
    var tdycucty=sanpham.latSanpham_cty;
    var idLoaisp=sanpham.loaisanpham.idLoaisp;
    var idVungxa=sanpham.vungxa.idVungxa;
    var idHuong=sanpham.huong.idHuong;
    var idDonvigia=sanpham.donvigia.idDonvigia;
    var ngaychuan=sanpham.ngaynhapSanpham_cty;
    var gia=sanpham.giaSanpham_cty;
    var dientich=sanpham.dientichSanpham_cty;
    var tensanpham=sanpham.nameSanpham_cty;
    var idDuong=sanpham.duong.idDuong;
    var idmotacucty=sanpham.motatindang.idMota;
    var tdxcucty=sanpham.lonSanpham_cty;
    var tdycucty=sanpham.latSanpham_cty;
    var chieurong=sanpham.chieurongSanpham_cty;
    var chieudai=sanpham.chieudaiSanpham_cty;
    var idhinhh=sanpham.hinhanh.idHinh;
    var trangthaigd="2";
    var idsp=sanpham.idSanphamcty;
    var sotang=sanpham.sotangSanpham_cty;
    var hem=sanpham.chieuronghem.idhem;
    var phaply=sanpham.phaply.idphaply;
    var thocu=sanpham.thocuSanpham_cty;
    var phongngu=sanpham.sophongnguSanpham_cty;
    var sotoilet=sanpham.sotoiletSanpham_cty;
    $http({
      method: 'PUT',
      url: 'http://localhost:9090/updatesanphamcty/' + tdxcucty + '/' + tdycucty + '/' + idLoaisp + '/' + idVungxa +
        '/' + idHuong + '/' + idDonvigia + '/' + ngaychuan + '/' + dientich +
        '/' + gia + '/' + idmotacucty + '/' + sotang + '/' + hem + '/' + phaply + '/' + thocu + '/' + phongngu + '/' + sotoilet
        + '/' + tensanpham + '/' + idDuong + '/' + tdxcucty + '/' + tdycucty + '/' + chieurong
        + '/' + chieudai + '/' + idhinhh
        + '/' + trangthaigd + '/' + idsp
    })
    alert("Đã cập nhật");
  };
});



function ymd(inputString)//Chuyển định dạng sang năm tháng ngày
{
  var year = inputString.substring(0, 4);//Lấy năm của đầu sách
  var month = inputString.substring(5, 7);//Lấy tháng của đầu sách
  var day = inputString.substring(8, 10);//Lấy ngày của đầu sách
  var myDate = year + "-" + month + "-" + day;//Định dạng yyyy-MM-dd
  return myDate;
}