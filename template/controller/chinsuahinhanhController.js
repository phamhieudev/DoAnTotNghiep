var app = angular.module('chinhsuahinhanhApp', []);
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
app.controller('chinhsuahinhanhCtrl', function ($scope, $http, $rootScope, checkAuth) {

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

  var idsp = location.search.split('id=')[1];


  $http({
    method: "GET",
    url: "http://localhost:9090/sanphamcty/" + idsp
  }).then(function mySuccess(response) {
    $scope.sanphamcty = response.data;
    var track = $scope.sanphamcty;
    $scope.tensanpham = track.nameSanpham_cty;
  }, function myError(response) {
    $scope.sanphamcty = response.statusText;
  });

  $http({
    method: "GET",
    url: "http://localhost:9090/findhinhbyidspcty/" + idsp
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
        url: 'http://localhost:9090/xoaHinhanhchitietspcty/' + id
      })
      alert("Xóa Thành Công");
      window.location.reload();
    }
    else {
      alert("Xóa Thất Bại");
    }
  }

  $scope.capnhatsanphamcty = function () {
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
    else {
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
              sanphamcty: {
                idSanphamcty: idsp
              }
            }
            $http.post('http://localhost:9090/addHinhanhchitietspcty', JSON.stringify(data))
            {

            };
          })
          .catch(console.error);
      }
      // alert(i);
      // alert(dai);
      if (i == dai) {
        setTimeout(function () { alert("Tải Lên Thành Công Thành Công"); }, 5000);
        //  window.location.reload();
      }
    }


  }


});


