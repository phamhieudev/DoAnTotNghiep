var app = angular.module('dangtinApp', []);
app.controller('dangtinCtrl', function ($scope, $http, $rootScope) {

  document.getElementById("dadangnhap").style.display = "none";
  $rootScope.session = window.localStorage.getItem("SessionId");
  $rootScope.namekh = window.localStorage.getItem("ten");
  $rootScope.isLoggedIn = window.localStorage.getItem("isLoggedIn");
  // $scope.check = checkAuth.getuserInfo();
  var idnd = window.localStorage.getItem("idnd");


  if ($rootScope.isLoggedIn == null || $rootScope.isLoggedIn == undefined) {
    document.getElementById("dadangnhap").style.display = "none";
    if (confirm('Bạn Cần Đăng Nhập Để Đăng Tin?')) {
      location.href = "http://127.0.0.1:5501/realand/sign_up.html";
    } else {
      location.href = "http://127.0.0.1:5501/realand/trangchu.html";
    }
  }
  else {
    document.getElementById("dadangnhap").style.display = "block";
    document.getElementById("chuadangnhap").style.display = "none";
  }

  $scope.dangxuat = function () {
    window.localStorage.clear();
    $rootScope.isLoggedIn = false;
    location.href = "http://127.0.0.1:5501/realand/trangchu.html";

  };

  $http({
    method: "GET",
    url: "http://localhost:9090/loaisanphams"
  }).then(function mySuccess(response) {
    $scope.loaisanphams = response.data;
  }, function myError(response) {
    $scope.loaisanphams = response.statusText;
  });

  $http({
    method: "GET",
    url: "http://localhost:9090/vungxas"
  }).then(function mySuccess(response) {
    $scope.vungxas = response.data;
  }, function myError(response) {
    $scope.vungxas = response.statusText;
  });

  $http({
    method: "GET",
    url: "http://localhost:9090/huongs"
  }).then(function mySuccess(response) {
    $scope.huongs = response.data;
  }, function myError(response) {
    $scope.huongs = response.statusText;
  });

  $http({
    method: "GET",
    url: "http://localhost:9090/donvigias"
  }).then(function mySuccess(response) {
    $scope.donvigias = response.data;
  }, function myError(response) {
    $scope.donvigias = response.statusText;
  });

  $http({
    method: "GET",
    url: "http://localhost:9090/Phaplys"
  }).then(function mySuccess(response) {
    $scope.phaplys = response.data;
  }, function myError(response) {
    $scope.phaplys = response.statusText;
  });

  $http({
    method: "GET",
    url: "http://localhost:9090/chieuronghems"
  }).then(function mySuccess(response) {
    $scope.chieuronghems = response.data;
  }, function myError(response) {
    $scope.chieuronghems = response.statusText;
  });

  $scope.myFunc = function (idLoaisp) {
    if (idLoaisp == 2) {
      document.getElementById("grTang").style.display = "none";
      document.getElementById("grToilet").style.display = "none";
      document.getElementById("grPhongngu").style.display = "none";

    }
    else {
      document.getElementById("grTang").style.display = "block";
      document.getElementById("grToilet").style.display = "block";
      document.getElementById("grPhongngu").style.display = "block";

    }
  };

  $scope.FuncVung = function (idVungxa) {
    $http({
      method: "GET",
      url: "http://localhost:9090/findbyidvung/" + idVungxa
    }).then(function mySuccess(response) {
      $scope.duongs = response.data;
    }, function myError(response) {
      $scope.duongs = response.statusText;
    });
  };
  $scope.funcDonvigia = function (idDonvigia) {
    var a = $scope.gia;
    if (idDonvigia == 1 && a > 999) {
      alert("Đơn vị Giá là Triệu , giá trị Giá không thể lớn hơn 999");
      $scope.gia = "";
      $scope.idDonvigia = "";
    }
  }


  $scope.changechieurong = function (chieurong) {
    var chieudai1 = $scope.chieudai;
    if (chieudai1 == undefined) {
      // alert("null bạn ơi");
      $scope.dientich = chieurong;
    }
    else {
      var dientich1 = chieudai1 * chieurong;
      $scope.dientich = dientich1;
      //  $scope.maxdientich=dientich1;
    }
  }

  $scope.changechieudai = function (chieudai) {
    var chieurong1 = $scope.chieurong;
    if (chieurong1 == undefined) {
      // alert("null bạn ơi");
      $scope.dientich = chieudai;
    }
    else {
      var dientich1 = chieudai * chieurong1;
      $scope.dientich = dientich1;
      //  $scope.maxdientich=dientich1;
    }
  }
  $scope.changethocu = function (thocu) {
    var dientich1 = $scope.dientich;
    if (thocu > dientich1) {
      alert("Thổ cư không được lớn hơn Diện Tích.");
      $scope.thocu = "";
    }
  }

  $scope.kiemtratoado = function () {
    var x = document.getElementById("toadox").value;
    var y = document.getElementById("toadoy").value;
    var vung = document.getElementById("idVungxa").value;
    var sel = document.getElementById("idVungxa");
    var text = sel.options[sel.selectedIndex].text;
    $http({
      method: "GET",
      url: 'http://localhost:9090/searchxy/' + x + '/' + y
    }).then(function mySuccess(response) {
      $scope.kiemtra = response.data;

      var a = $scope.kiemtra;
      // console.log(a.idVungxa);
      if (a.idVungxa != vung) {
        alert("Tọa Độ Ngoài Vùng" + " " + text);
        document.getElementById("toadox").value = "";
        document.getElementById("toadoy").value = "";
      }
      else {
        $scope.toadox = x;
        $scope.toadoy = y;
      }
    });
  }

  function formatDate(date) {
    var d = new Date(date),
      month = '' + (d.getMonth() + 1),
      day = '' + d.getDate(),
      year = d.getFullYear();

    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;

    return [year, month, day].join('-');
  }

  $scope.addsanphamnd = function (tensanpham, idLoaisp, idVungxa, idDuong, idHuong, gia, idDonvigia, chieurong, chieudai, dientich, thocu, phaply, hem, sotang, phongngu, sotoilet, mota, toadox, toadoy) {
    var datamota = {
      noidung: mota
    }
    $http.post('http://localhost:9090/createMota', JSON.stringify(datamota))
    {
    };
    var idmota;


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
    var trangthai = 2;

    /// tạm thời id nguoi dung
    var trangthaigd = 1;

    console.log(mota);

    if (idLoaisp == 2) {
      const file = document.querySelector("#file-input").files[0];
      // Initialize Firebase
      if (file == undefined) {
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
            $http.post('http://localhost:9090/createHinh', JSON.stringify(data))
            {
              // alert("success !");
            };
            var idmota;
            $http.get("http://localhost:9090/Motatindangs")
              .then(function (response) {
                $scope.motas = response.data;
                var countmota = $scope.motas.length;
                for (var i = 0; i < countmota; i++) {
                  var track = response.data[i];
                  idmota = track.idMota;
                }
                console.log("mota"+idmota);
                var idhinh;
                $http.get("http://localhost:9090/hinhanhs")
                  .then(function (response) {
                    $scope.data1 = [];
                    $scope.details = response.data;
                    var count = $scope.details.length;
                    for (var y = 0; y < count; y++) {
                      var track = response.data[y];
                      idhinh = track.idHinh;
                    }
                    if(y=count){
                      sotang = "0";
                      phongngu = "0";
                      sotoilet = "0";
                      $http({
                        method: 'POST',
                        url: 'http://localhost:9090/addsanpham/' + toadox + '/' + toadoy + '/' + idLoaisp + '/' + idVungxa +
                          '/' + idHuong + '/' + idDonvigia + '/' + ngaychuan + '/' + dientich +
                          '/' + gia + '/' + idmota + '/' + sotang + '/' + hem + '/' + phaply + '/' + thocu + '/' + phongngu + '/' + sotoilet + '/' + tensanpham + '/' + idDuong + '/' + toadox + '/' + toadoy + '/' + chieurong + '/' + chieudai + '/' + idnd + '/' + trangthai + '/' + idhinh
                          + '/' + trangthaigd
  
                      })
                    }
                  });
              })
          })
          .catch(console.error);
          setTimeout(function(){ alert("Thêm Thành Công"); }, 5000);

        /// lấy id để thêm vào hình

      }
    }
    else { /// k phải sản phầm đất
      const file = document.querySelector("#file-input").files[0];
      // Initialize Firebase
      if (file == undefined) {
        alert("Bạn chưa chọn hình ảnh");
      }
      else {
        if (sotang == "" || phongngu == "" || sotoilet == "") {
          alert("Vui lòng kiểm tra lại thông tin nhập vào !");
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
              $http.post('http://localhost:9090/createHinh', JSON.stringify(data))
              {
                // alert("success !");
              };
              var idmota;
              $http.get("http://localhost:9090/Motatindangs")
                .then(function (response) {
                  $scope.motas = response.data;
                  var countmota = $scope.motas.length;
                  for (var i = 0; i < countmota; i++) {
                    var track = response.data[i];
                    idmota = track.idMota;
                  }
                  console.log("mota"+idmota);
                  var idhinh;
                  $http.get("http://localhost:9090/hinhanhs")
                    .then(function (response) {
                      $scope.data1 = [];
                      $scope.details = response.data;
                      var count = $scope.details.length;
                      for (var y = 0; y < count; y++) {
                        var track = response.data[y];
                        idhinh = track.idHinh;
                      }
                      if(y=count){
                        $http({
                          method: 'POST',
                          url: 'http://localhost:9090/addsanpham/' + toadox + '/' + toadoy + '/' + idLoaisp + '/' + idVungxa +
                            '/' + idHuong + '/' + idDonvigia + '/' + ngaychuan + '/' + dientich +
                            '/' + gia + '/' + idmota + '/' + sotang + '/' + hem + '/' + phaply + '/' + thocu + '/' + phongngu + '/' + sotoilet + '/' + tensanpham + '/' + idDuong + '/' + toadox + '/' + toadoy + '/' + chieurong + '/' + chieudai + '/' + idnd + '/' + trangthai + '/' + idhinh
                            + '/' + trangthaigd
    
                        })
                      }
                     
               
                    });
                })
  
  
            })
            .catch(console.error);
            setTimeout(function(){ alert("Thêm Thành Công"); }, 5000);
            /// lấy id để thêm vào hình
  
        }

      }
    }

  }


});


