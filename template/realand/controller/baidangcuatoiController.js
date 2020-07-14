var app = angular.module('baidangcuatoiApp', []);
app.controller('baidangcuatoiCtrl', function ($scope, $http,$rootScope) {

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


// get chưa bán và đc duyệt
$http({
  method: "GET",
  url: 'http://localhost:9090/sanphamnguoidungtheoidnguoidung/' + 1 + '/' + 1 + '/' + idnd
}).then(function mySuccess(response) {
  $scope.dcduyets = response.data;
});

/// get chưa bán và chưa duyệt
$http({
  method: "GET",
  url: 'http://localhost:9090/sanphamnguoidungtheoidnguoidung/' + 1 + '/' + 2 + '/' + idnd
}).then(function mySuccess(response) {
  $scope.chuaduyets = response.data;
});

  // chỉnh sửa

  $scope.chinhsuadaduyet = function(x){
    window.open('http://127.0.0.1:5501/realand/chinsuatindang.html?id='+x.idSanphamnguoidung+'', '_blank');

  }

  $scope.chinhsuachuaduyet = function(x){
    window.open('http://127.0.0.1:5501/realand/chinsuatindang.html?id='+x.idSanphamnguoidung+'', '_blank');

  }

  $scope.chinhsuahinhchuaduyet = function(x){
    window.open('http://127.0.0.1:5501/realand/chinsuahinhanhsp.html?id='+x.idSanphamnguoidung+'', '_blank');

  }
  $scope.dagiaodich = function (x)////Khi bấm vào nút DELETE
  {
    var idsp=x.idSanphamnguoidung;
    var tdxcu=x.lonSanpham_nguoidung;
    var tdycu=x.latSanpham_nguoidung;
    var idLoaisp=x.loaisanpham.idLoaisp;
    var idVungxa=x.vungxa.idVungxa;
    var idHuong=x.huong.idHuong;
    var idDonvigia=x.donvigia.idDonvigia;
    var ngaychuan=x.ngaynhapSanphamnguoidung;
    var dientich=x.dientichSanphamnguoidung;
    var gia=x.giaSanphamnguoidung;
    var idmotacu=x.motatindang.idMota;
    var sotang=x.sotangSanphamnguoidung;
    var hem=x.chieuronghem.idhem;
    var phaply=x.phaply.idphaply;
    var thocu=x.thocuSanphamnguoidung;
    var phongngu=x.sophongnguSanphamnguoidung;
    var sotoilet=x.sotoiletSanphamnguoidung;
    var tensanpham=x.nameSanphamnguoidung;
    var idDuong=x.duong.idDuong;
    var tdxcu=x.lonSanpham_nguoidung;
    var tdycu=x.latSanpham_nguoidung;
    var chieurong=x.chieurongSanpham_nguoidung;
    var chieudai=x.chieudaiSanpham_nguoidung;
    var idnd=x.nguoidung.idNguoidung;
    var trangthaicu=x.trangthai.idTrangthai;
    var idhinhcu=x.hinhanh.idHinh;
    var trangthaigd="2";

    $http({
      method: 'POST',
      url: 'http://localhost:9090/upsanphamnd/' + tdxcu + '/' + tdycu + '/' + idLoaisp + '/' + idVungxa +
        '/' + idHuong + '/' + idDonvigia + '/' + ngaychuan + '/' + dientich +
        '/' + gia + '/' + idmotacu + '/' + sotang + '/' + hem + '/' + phaply + '/' + thocu + '/' + phongngu + '/' + sotoilet
        + '/' + tensanpham + '/' + idDuong + '/' + tdxcu + '/' + tdycu + '/' + chieurong
        + '/' + chieudai + '/' + idnd + '/' + trangthaicu + '/' + idhinhcu
        + '/' + trangthaigd + '/' + idsp
    })
    alert("Đã cập nhật");
    
  };

  



  // $scope.xoakhachdang=function(id){
  //   var r = confirm("Bạn Chắc Chắn Xóa ?");
  //   if (r == true) {
  //     $http({
  //       method: 'DELETE',
  //       url: 'http://localhost:9090/xoasanphamyeuthichnguoidung/' + id
  //     })
  //     alert("Xóa Thành Công");
  //     window.location.reload();
  //   }
  //   else {
  //     alert("Xóa Thất Bại");
  //     window.location.reload();
  //   } 
  // }

  // $scope.xoactydang=function(id){
  //   var r = confirm("Bạn Chắc Chắn Xóa ?");
  //   if (r == true) {
  //     $http({
  //       method: 'DELETE',
  //       url: 'http://localhost:9090/xoasanphamyeuthichcty/' + id
  //     })
  //     alert("Xóa Thành Công");
  //     window.location.reload();
  //   }
  //   else {
  //     alert("Xóa Thất Bại");
  //     window.location.reload();
  //   } 
  // }
});


