var app = angular.module('chinhsuahinhanhApp', []);
app.controller('chinhsuahinhanhCtrl', function ($scope, $http, $rootScope) {

  document.getElementById("dadangnhap").style.display = "none";
  $rootScope.session = window.localStorage.getItem("SessionId");
  $rootScope.namekh = window.localStorage.getItem("ten");
  $rootScope.isLoggedIn = window.localStorage.getItem("isLoggedIn");
  // $scope.check = checkAuth.getuserInfo();
  var idnd = window.localStorage.getItem("idnd");


  if ($rootScope.isLoggedIn == null || $rootScope.isLoggedIn == undefined) {
    document.getElementById("dadangnhap").style.display = "none";

    location.href = "http://127.0.0.1:5501/realand/sign_up.html";
  }
  else {
    document.getElementById("dadangnhap").style.display = "block";
    document.getElementById("chuadangnhap").style.display = "none";
  }


  var idsp = location.search.split('id=')[1];


  $http({
    method: "GET",
    url: "http://localhost:9090/sanphamnguoidung/" + idsp
  }).then(function mySuccess(response) {
    $scope.details = response.data;
    var track = $scope.details;
    $scope.tensanpham = track.nameSanphamnguoidung;
  }, function myError(response) {
    $scope.details = response.statusText;
  });

  $http({
    method: "GET",
    url: "http://localhost:9090/findbyidspnd/" + idsp
  }).then(function mySuccess(response) {
    $scope.hinhanhs = response.data;
  }, function myError(response) {
    $scope.hinhanhs = response.statusText;
  });

  $scope.xoahinh = function (x) {
    var id = x.idHinh;
    var r = confirm("Bạn Chắc Chắn Xóa ?");
    if (r == true) {
      $http({
        method: 'DELETE',
        url: 'http://localhost:9090/xoaHinhanhchitietspnd/' + id
      })
      alert("Xóa Thành Công");
      window.location.reload();
    }
    else {
      alert("Xóa Thất Bại");
    }
  }

  $scope.capnhatsanphamnd = function () {
    var firebaseConfig = {
      apiKey: "AIzaSyDKUhawsqRvb-ofMLIiHmjMF4ov8Q2SJIY",
      authDomain: "doantotnghiep-276412.firebaseapp.com",
      databaseURL: "https://doantotnghiep-276412.firebaseio.com",
      projectId: "doantotnghiep-276412",
      storageBucket: "doantotnghiep-276412.appspot.com",
      messagingSenderId: "220785274488",
      appId: "1:220785274488:web:5129c3540f454cae2dc78d"
    };
    var i = 0;
    firebase.initializeApp(firebaseConfig);
    const ref = firebase.storage().ref();
    var dai = document.getElementById('file-input').files.length;
    if (dai == 0 || dai == undefined) {
      alert("Không có hình ảnh mới");
    }
    else{
      for (; i < dai; i++) {
        const file = document.querySelector("#file-input").files[i];
        const name = +new Date() + "-" + file.name;
        const metadata = {
          contentType: file.type
        };
        const task = ref.child(name).put(file, metadata);
        task
          .then(snapshot => snapshot.ref.getDownloadURL())
          .then(url => {
            console.log(url);
            var link = url;
            var data = {
              urlhinh: link,
              sanphamnguoidung: {
                idSanphamnguoidung: idsp
              }
            }
            $http.post('http://localhost:9090/addHinhanhchitietspnd', JSON.stringify(data))
            {
  
            };
          })
          .catch(console.error);
      }
      // alert(i);
      // alert(dai);
      if(i==dai){
        alert("Cập Nhật Thành Công");
        //  window.location.reload();
      }
    }
   

  }


});


