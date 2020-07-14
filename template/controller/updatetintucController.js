var app = angular.module('updatetintucApp', ['ckeditor']);
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
app.controller('updatetintucCtrl', function ($scope, $http, checkAuth, $rootScope) {

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

  var id = location.search.split('id=')[1];
  var idhinhcu;
  $http({
    method: "GET",
    url: "http://localhost:9090/tintuc/" + id
  }).then(function mySuccess(response) {
    $scope.details = response.data;
    var track = $scope.details;
    $scope.tentintuc = track.tenTintuc;
    $scope.text = track.noidungTintuc;
    $scope.hinhAnh = track.hinhanhtintuc.url;
    idhinhcu=track.hinhanhtintuc.idHinh;
  });
  function formatDate(date) {
    var d = new Date(date),
      month = '' + (d.getMonth() + 1),
      day = '' + d.getDate(),
      year = d.getFullYear();

    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;

    return [year, month, day].join('-');
  }

  $scope.edit = function (tentintuc, text) {
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

    if (file == undefined) // lấy id hinh cũ
    {
      var data={
        tenTintuc: tentintuc,
        noidungTintuc: text,
        ngaydangTintuc: ngaychuan,
        hinhanhtintuc: {
            idHinh: idhinhcu,
            url: ""
        }
      }
      $http.put('http://localhost:9090/updatetintuc/' + id, JSON.stringify(data)).then(function (response) {
        if (response.data) {
          // 
        }
      }, function (response) {
        alert("Cập Nhật Thành Công!");
        // window.location.reload();
      });
    }
    else{
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
          // $http.put('http://localhost:9090/updatehinhanhtintuc/' + idhinhcu, JSON.stringify(data)).then(function (response) {
          //   if (response.data) {
          //     // 
          //   }
          // }, function (response) {
          //   // alert("Cập Nhật Thành Công!");
          //   // window.location.reload();
          //   var data={
          //     tenTintuc: tentintuc,
          //     noidungTintuc: text,
          //     ngaydangTintuc: ngaychuan,
          //     hinhanhtintuc: {
          //         idHinh: idhinhcu,
          //         url: ""
          //     }
          //   }
          //   $http.put('http://localhost:9090/updatetintuc/' + id, JSON.stringify(data)).then(function (response) {
          //     if (response.data) {
          //       // 
          //     }
          //   }, function (response) {
          //     alert("Cập Nhật Thành Công!");
          //     // window.location.reload();
          //   });
          // });

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
              $http.put('http://localhost:9090/updatetintuc/'+id, JSON.stringify(data)).then(function (response) {
                // alert("Đã thêm mới!");
                
              });
              alert("Cập Nhật Thành Công!");
            });
        })
        .catch(console.error);
    }
          
  }

});