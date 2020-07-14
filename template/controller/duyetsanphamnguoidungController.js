var app = angular.module('duyetsanphamnguoidungApp', []);
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

app.controller('duyetsanphamnguoidungCtrl', function ($scope, $http, checkAuth, $rootScope) {

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
  // lấy Dữ Liệu

  $http({
    method: "GET",
    url: "http://localhost:9090/findbyidtrangthai/2"
  }).then(function mySuccess(response) {
    $scope.sanphamnguoidungs = response.data;
  }, function myError(response) {
    $scope.sanphamnguoidungs = response.statusText;
  });

  $scope.duyetsanphamnguoidung = function (x) {
    var tdx = x.lonSanpham_nguoidung;
    var tdy = x.latSanpham_nguoidung;
    var idLoaisp = x.loaisanpham.idLoaisp;
    var idVungxa = x.vungxa.idVungxa;
    var idHuong = x.huong.idHuong;
    var idDonvigia = x.donvigia.idDonvigia;
    var date = x.ngaynhapSanphamnguoidung;
    var dientich = x.dientichSanphamnguoidung;
    var gia = x.giaSanphamnguoidung;
    var mota = x.motatindang.idMota;
    var sotang = x.sotangSanphamnguoidung;
    var hem = x.chieuronghem.idhem;
    var phaply = x.phaply.idphaply;
    var thocu = x.thocuSanphamnguoidung;
    var phongngu = x.sophongnguSanphamnguoidung;
    var sotoilet = x.sotoiletSanphamnguoidung;
    var tensanpham = x.nameSanphamnguoidung;
    var idDuong = x.duong.idDuong;
    var chieurong = x.chieurongSanpham_nguoidung;
    var chieudai = x.chieudaiSanpham_nguoidung;
    var idhinh = x.hinhanh.idHinh;
    var idnguoidung = x.nguoidung.idNguoidung;
    var idtrangthai = "1";
    var idtangthaigd = x.trangthaigd.idTrangthaigd;
    var id = x.idSanphamnguoidung;
    //  alert(id);

    var r = confirm("Bạn Chắc Chắn Duyệt ?");
    if (r == true) {
      $http({
        method: 'POST',
        url: 'http://localhost:9090/upsanphamnd/' + tdx + '/' + tdy + '/' + idLoaisp + '/' + idVungxa +
          '/' + idHuong + '/' + idDonvigia + '/' + date + '/' + dientich +
          '/' + gia + '/' + mota + '/' + sotang + '/' + hem + '/' + phaply + '/' + thocu + '/' + phongngu + '/' + sotoilet
          + '/' + tensanpham + '/' + idDuong + '/' + tdx + '/' + tdy + '/' + chieurong
          + '/' + chieudai + '/' + idnguoidung + '/' + idtrangthai + '/' + idhinh
          + '/' + idtangthaigd + '/' + id
      })
      alert("Duyệt Thành Công");
      window.location.reload();
    }
    else {
      alert("Duyệt Thất Bại");
      // window.location.reload();
    }



  }
  $scope.xemhinhanhduyet = function (x) {
    window.open('http://127.0.0.1:5501/xemhinhanhtindang.html?id=' + x.idSanphamnguoidung + '', '_blank');
  }
  $scope.xoasanpham = function (sanpham)////Khi bấm vào nút DELETE
  {
    var id = sanpham.idSanphamnguoidung;
    var manghinh = [];
    var r = confirm("Bạn Chắc Chắn Xóa ?");
    if (r == true) {

      $http({
        method: 'DELETE',
        url: 'http://localhost:9090/xoasanphamnguoidung/' + id
      })
      alert("Xóa thành công");
    }
    else {
      alert("Xóa Thất Bại");
      // window.location.reload();
    }
  };
});