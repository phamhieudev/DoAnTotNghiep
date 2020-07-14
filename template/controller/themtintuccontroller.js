var app = angular.module('themtintucApp', ['ckeditor']);
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
app.controller('themtintucCtrl', function ($scope, $http, checkAuth, $rootScope) {
  $rootScope.nameadmin = window.localStorage.getItem("tenadmin");
  $rootScope.isLoggedInadmin = window.localStorage.getItem("isLoggedInadmin");
  $rootScope.isLoggedInadmin = window.localStorage.getItem("isLoggedInadmin");
  $scope.check = checkAuth.getuserInfo();

if($rootScope.roleadmin==2){
  document.getElementById("admin").style.display='none';
}

  $scope.logout = function () {
    window.localStorage.clear();
    $rootScope.isLoggedIn = false;
    location.href = "http://127.0.0.1:5501/login.html";

  };

  $scope.data = {
    options: {
      language: 'en',
      allowedContent: true,
      entities: false
    }
  };

  $scope.tentintuc = "";
  $scope.text = "";
  function formatDate(date) {
    var d = new Date(date),
      month = '' + (d.getMonth() + 1),
      day = '' + d.getDate(),
      year = d.getFullYear();

    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;

    return [year, month, day].join('-');
  }

  $scope.addd = function (tentintuc, text) {

    var firebaseConfig = {
      apiKey: "AIzaSyDKUhawsqRvb-ofMLIiHmjMF4ov8Q2SJIY",
      authDomain: "doantotnghiep-276412.firebaseapp.com",
      databaseURL: "https://doantotnghiep-276412.firebaseio.com",
      projectId: "doantotnghiep-276412",
      storageBucket: "doantotnghiep-276412.appspot.com",
      messagingSenderId: "220785274488",
      appId: "1:220785274488:web:5129c3540f454cae2dc78d"
    };

    var d = new Date();
    var date = d.getUTCDate();
    var month = d.getUTCMonth() + 1;
    var year = d.getUTCFullYear();
    var dateStr = year + "-" + month + "-" + date;
    var ngaychuan = formatDate(dateStr);

    const file = document.querySelector("#photo").files[0];

    if (tentintuc == "" || text == "") {
      alert("Vui lòng nhập những thông tin cần thiết!");
      return;
    }
    else if (file == undefined) {
      alert("Bạn chưa chọn hình ảnh");
    }
    else {
      firebase.initializeApp(firebaseConfig);
      console.log(firebase);
      const ref = firebase.storage().ref();

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
            url: link
          }
          $http.post('http://localhost:9090/createHinhanhtintuc', JSON.stringify(data))
          {
            // alert("success !");
          };
          var idhinh;
          $http.get("http://localhost:9090/hinhanhtintucs")
            .then(function (response) {
              $scope.details = response.data;
              var count = $scope.details.length;
              for (var i = 0; i < count; i++) {
                var track = response.data[i];
                console.log(track);
                idhinh = track.idHinh + 1;
                console.log(idhinh);
              }
              var data =
              {
                tenTintuc: tentintuc,
                noidungTintuc: text,
                ngaydangTintuc: ngaychuan,
                hinhanhtintuc: {
                  idHinh: idhinh,
                  url: ""
              }
              };

              $http.post('http://localhost:9090/addtintuc', JSON.stringify(data)).then(function (response) {
                 alert("Đã thêm mới!");
              });
            });
        })
        .catch(console.error);
    }
  };
});