var app = angular.module('chitietsanphamctyApp', ['ui.bootstrap']);
app.controller('chitietsanphamctyCtrl', function ($scope, $http,$rootScope) {

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

  var idsp = location.search.split('id=')[1];

  var idnd;
  var tdx;
  var tdy;
  $http({
    method: "GET",
    url: "http://localhost:9090/sanphamcty/" + idsp
  }).then(function mySuccess(response) {
    $scope.details = response.data;
    var track = $scope.details;
    $scope.ten=track.nameSanpham_cty;
    $scope.loaisanpham=track.loaisanpham.tenLoaisp;
    $scope.duong=track.duong.tenDuong;
    $scope.phuong=track.vungxa.tenVungxa;
    $scope.Huong=track.huong.nameHuong;
    $scope.gia=track.giaSanpham_cty;
    $scope.donvigia=track.donvigia.tenDonvigia;
    $scope.dientich=track.dientichSanpham_cty;
    $scope.sotang=track.sotangSanpham_cty;
    $scope.hem=track.hemSanpham_cty;
    $scope.phaply=track.phaplySanpham_cty;
    $scope.thocu=track.thocuSanpham_cty;
    $scope.sophongngu=track.sophongnguSanpham_cty;
    $scope.toilet=track.sotoiletSanpham_cty;
    $scope.chieudai=track.chieudaiSanpham_cty;
    $scope.chieurong=track.chieurongSanpham_cty;
    $scope.thocu=track.thocuSanpham_cty;
    $scope.mota=track.motatindang.noidung;
    tdx=track.lonSanpham_cty;
    tdy=track.latSanpham_cty;
    sessionStorage.setItem("tdx",track.lonSanpham_cty);
    sessionStorage.setItem("tdy",track.latSanpham_cty);
});

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
      url: 'http://localhost:9090/addspyeuthichcty/' + idnd + '/' + idsp 
    })
    alert("Đã thêm vào yêu thích");
  }
}

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

$http({
  method: "GET",
  url: "http://localhost:9090/findhinhbyidspcty/" + idsp
}).then(function mySuccess(response) {
  $scope.hinhanhs = response.data;
});

$scope.quantamspcty=function(tenNguoidung,mail,phone){
  if(tenNguoidung==undefined || mail==undefined ||phone==undefined)
  {
    alert("Bạn vui lòng nhập đủ thông tin");
  }
  else{
    var data =
    {
      mail: mail,
      phone: phone,
      tenNguoidung: tenNguoidung,
      sanphamcty: {
        idSanphamcty:idsp
      }
  };
  $http.post('http://localhost:9090/addquantamsanphamcty', JSON.stringify(data)).then(function (response) {
    if (response.data) {
      ///
    }
  }, function (response) {
    var r = alert("Cảm ơn bạn đã quan tâm!");
    // window.location.reload();
    // $scope.nguoidungs = response.statusText;
  });
  }
}
    
});

