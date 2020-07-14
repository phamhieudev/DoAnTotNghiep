var app = angular.module('chitietsanphamnguoidungApp', ['ui.bootstrap']);
app.controller('chitietsanphamnguoidungCtrl', function ($scope, $http,$rootScope) {


  
  document.getElementById("dadangnhap").style.display="none";
  $rootScope.session = window.localStorage.getItem("SessionId");
  $rootScope.namekh = window.localStorage.getItem("ten");
  $rootScope.isLoggedIn = window.localStorage.getItem("isLoggedIn");
  // $scope.check = checkAuth.getuserInfo();
  var idnd = window.localStorage.getItem("idnd");


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

  var idsp = location.search.split('id=')[1];
var tdx;
var tdy;
  //  document.getElementById("tdx").style.display="none";
  // document.getElementById("tdy").style.display="none";
  $http({
    method: "GET",
    url: "http://localhost:9090/sanphamnguoidung/" + idsp
  }).then(function mySuccess(response) {
    $scope.details = response.data;
    var track = $scope.details;
    $scope.ten = track.nameSanphamnguoidung;
    $scope.loaisanpham = track.loaisanpham.tenLoaisp;
    $scope.duong = track.duong.tenDuong;
    $scope.phuong = track.vungxa.tenVungxa;
    $scope.Huong = track.huong.nameHuong;
    $scope.gia = track.giaSanphamnguoidung;
    $scope.donvigia = track.donvigia.tenDonvigia;
    $scope.dientich = track.dientichSanphamnguoidung;
    $scope.sotang = track.sotangSanphamnguoidung;
    $scope.hem = track.chieuronghem.tenHem;
    $scope.phaply = track.phaply.tenphaply;
    $scope.thocu = track.thocuSanphamnguoidung;
    $scope.sophongngu = track.sophongnguSanphamnguoidung;
    $scope.toilet = track.sotoiletSanphamnguoidung;
    $scope.chieudai = track.chieudaiSanpham_nguoidung;
    $scope.chieurong = track.chieurongSanpham_nguoidung;
    $scope.thocu = track.thocuSanphamnguoidung;
    $scope.mota = track.motatindang.noidung;

    $scope.tennguoidung = track.nguoidung.tenNguoidung;
    $scope.email = track.nguoidung.mail;
    $scope.idnguoidang=track.nguoidung.idNguoidung;
    $scope.sdt = track.nguoidung.phone;
    tdx=track.lonSanpham_nguoidung;
    tdy=track.latSanpham_nguoidung
  
    sessionStorage.setItem("tdx",track.lonSanpham_nguoidung);
    sessionStorage.setItem("tdy",track.latSanpham_nguoidung);

  }, function myError(response) {
    $scope.details = response.statusText;
  });
  $scope.myInterval = 9000;
    $http({
      method: "GET",
      url: "http://localhost:9090/findbyidspnd/" + idsp
    }).then(function mySuccess(response) {
      $scope.hinhanhs = response.data;
    });
 
    $scope.timduongdi=function(){
        if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(showPosition);
        } else { 
          x.innerHTML = "Trình Duyệt Không Hỗ Trợ.";
        }
    }
    function showPosition(position) {
    //   var x = sessionStorage.getItem("tdx");
    //   console.log(x);


    // var y = sessionStorage.getItem("tdy");

    // console.log(y);
      // alert("Latitude: " + position.coords.latitude);  
      // alert("Longitude: " + position.coords.longitude);  
      var xhientai = position.coords.latitude;
      var yhientai = position.coords.longitude;

      window.open('https://www.google.com/maps/dir/'+xhientai+','+yhientai+'/'+tdy+','+tdx+'/@10.989659,106.6377197,14z?hl=vn', '_blank');
    }

 $scope.addyeuthich=function(){

  if( $rootScope.isLoggedIn==null ||  $rootScope.isLoggedIn==undefined)
  {
    if (confirm('Bạn Cần Đăng Nhập Để Đăng Thêm')) {
      location.href = "http://127.0.0.1:5501/realand/sign_up.html";
    } else {
      location.href = "http://127.0.0.1:5501/realand/trangchu.html";
    }
  }
  else{
    $http({
      method: 'POST',
      url: 'http://localhost:9090/addspyeuthichnguoidung/' + idnd + '/' + idsp 
    })
    alert("Đã thêm vào yêu thích");
  }
}
    
});
