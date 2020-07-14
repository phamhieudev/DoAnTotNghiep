var app = angular.module('chinhsuatindangApp', []);
app.controller('chinhsuatindangCtrl', function ($scope, $http, $rootScope) {

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
    url: "http://localhost:9090/duongs"
  }).then(function mySuccess(response) {
    $scope.duongs = response.data;
  }, function myError(response) {
    $scope.duongs = response.statusText;
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

  var idsp = location.search.split('id=')[1];
  var tdxcu;
  var tdycu;
  var idhinhcu;
  var trangthaicu;
  var idvungcu;
  var idmotacu;

  $http({
    method: "GET",
    url: "http://localhost:9090/sanphamnguoidung/" + idsp
  }).then(function mySuccess(response) {
    $scope.details = response.data;
    var track = $scope.details;
    $scope.tensanpham = track.nameSanphamnguoidung;

    if (track.loaisanpham.idLoaisp == 2) { // đất
      document.getElementById("grTang").style.display = "none";
      document.getElementById("grToilet").style.display = "none";
      document.getElementById("grPhongngu").style.display = "none";
    }
    document.getElementById("idLoaisp").value = track.loaisanpham.idLoaisp;
    // $scope.userForm.idLoaisp.$error.required = false;
    // $scope.userForm.idLoaisp.$valid = true;
    document.getElementById("idVungxa").value = track.vungxa.idVungxa;
    idvungcu = track.vungxa.idVungxa;
    // $scope.userForm.idVungxa.$error.required = false;
    // $scope.userForm.idVungxa.$valid = true;
    document.getElementById("idDuong").value = track.duong.idDuong;
    // $scope.userForm.idDuong.$error.required = false;
    // $scope.userForm.idDuong.$valid = true;
    document.getElementById("idHuong").value = track.huong.idHuong;
    // $scope.userForm.idHuong.$error.required = false;
    // $scope.userForm.idHuong.$valid = true;
    document.getElementById("idDonvigia").value = track.donvigia.idDonvigia;
    // $scope.userForm.idDonvigia.$error.required = false;
    // $scope.userForm.idDonvigia.$valid = true;
    document.getElementById("phaply").value = track.phaply.idphaply;
    // $scope.userForm.phaply.$error.required = false;
    // $scope.userForm.phaply.$valid = true;
    document.getElementById("phaply").value = track.phaply.idphaply;
    // $scope.userForm.phaply.$error.required = false;
    // $scope.userForm.phaply.$valid = true;
    document.getElementById("hem").value = track.chieuronghem.idhem;
    // $scope.userForm.hem.$error.required = false;
    // $scope.userForm.hem.$valid = true;
    $scope.gia = track.giaSanphamnguoidung;
    $scope.dientich = track.dientichSanphamnguoidung;
    $scope.thocu = track.thocuSanphamnguoidung;
    $scope.chieurong = track.chieurongSanpham_nguoidung;
    $scope.chieudai = track.chieudaiSanpham_nguoidung;
    $scope.mota = track.motatindang.noidung;
    idmotacu=track.motatindang.idMota;
    $scope.sotang = track.sotangSanphamnguoidung;
    $scope.phongngu = track.sophongnguSanphamnguoidung;
    $scope.sotoilet = track.sotoiletSanphamnguoidung;

    $scope.toadox = track.lonSanpham_nguoidung;
    tdxcu = track.lonSanpham_nguoidung;
    $scope.toadoy = track.latSanpham_nguoidung;
    tdycu = track.latSanpham_nguoidung;

    sessionStorage.setItem("tdxchinhsua", track.lonSanpham_nguoidung);
    sessionStorage.setItem("tdychinhsua", track.latSanpham_nguoidung);

    idhinhcu = track.hinhanh.idHinh;
    $scope.hinhcu = track.hinhanh.url;
    trangthaicu = track.trangthai.idTrangthai;
    // console.log(trangthaicu);
  }, function myError(response) {
    $scope.details = response.statusText;
  });

  $scope.capnhatsanphamnd = function (tensanpham, gia, chieurong, chieudai, dientich, thocu, sotang, phongngu, sotoilet, mota) {
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
    var trangthaigd = 1;
    var toadox = document.getElementById("toadox").value;
    var toadoy = document.getElementById("toadoy").value;


    var idLoaisp = document.getElementById("idLoaisp").value;
    var idVungxa = document.getElementById("idVungxa").value;
    var idDuong = document.getElementById("idDuong").value;
    var idHuong = document.getElementById("idHuong").value;
    var idDonvigia = document.getElementById("idDonvigia").value;
    var phaply = document.getElementById("phaply").value;
    var hem = document.getElementById("hem").value;

    const file = document.querySelector("#file-input").files[0];

    var datamota = {
      noidung: mota
    };

    $http.put('http://localhost:9090/updateMotatindang/' + idmotacu, JSON.stringify(datamota)).then(function (response) {
      if (response.data) {
        // 
      }
    }, function (response) {
      // alert("Cập Nhật Thành Công!");
      // window.location.reload();
    });


    if (idLoaisp == 2) { // sp đất
      sotang = "0";
      phongngu = "0";
      sotoilet = "0";
      if (tensanpham == undefined || gia == undefined || chieurong == undefined || chieudai == undefined || dientich == undefined || thocu == undefined
        || mota == undefined || toadox == undefined || toadoy == undefined || idLoaisp == undefined || idVungxa == undefined || idDuong == undefined || idHuong == undefined
        || idDonvigia == undefined || phaply == undefined || hem == undefined) {

        alert("Vui lòng nhập những thông tim cần thiết");
      }
      else { // nếu dữ liệu hợp lệ thì check tọa độ
        if (toadox != tdxcu || idvungcu != idVungxa) //nếu khác thì phải check
        {
          var vung = document.getElementById("idVungxa").value;
          var sel = document.getElementById("idVungxa");
          var text = sel.options[sel.selectedIndex].text;
          $http({
            method: "GET",
            url: 'http://localhost:9090/searchxy/' + toadox + '/' + toadoy
          }).then(function mySuccess(response) {
            $scope.kiemtra = response.data;
            var a = $scope.kiemtra;
            if (a.idVungxa != vung) {
              alert("Tọa Độ Ngoài Vùng" + " " + text + " Vui lòng chọn lại tọa độ");
              document.getElementById("toadox").value = "";
              document.getElementById("toadoy").value = "";
            }
            else { // tọa độ mới mà trong vùng
              if (file == undefined) { // check hình ảnh // hình cũ , tọa độ mới // này ổn
                $http({
                  method: 'POST',
                  url: 'http://localhost:9090/upsanphamnd/' + toadox + '/' + toadoy + '/' + idLoaisp + '/' + idVungxa +
                    '/' + idHuong + '/' + idDonvigia + '/' + ngaychuan + '/' + dientich +
                    '/' + gia + '/' + idmotacu + '/' + sotang + '/' + hem + '/' + phaply + '/' + thocu + '/' + phongngu + '/' + sotoilet
                    + '/' + tensanpham + '/' + idDuong + '/' + toadox + '/' + toadoy + '/' + chieurong
                    + '/' + chieudai + '/' + idnd + '/' + trangthaicu + '/' + idhinhcu
                    + '/' + trangthaigd + '/' + idsp
                })
                alert("Cập Nhật Thành Công");

              }
              else { // hình mới   tọa độ mới hình mới
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
                      var idhinhh;
                      $http.get("http://localhost:9090/hinhanhs")
                        .then(function (response) {
                          $scope.data1 = [];
                          $scope.details = response.data;
                          var count = $scope.details.length;
                          for (var i = 0; i < count; i++) {
                            var track = response.data[i];
                            console.log(track);
                            idhinhh = track.idHinh + 1;
                            // console.log(idhinhh);
                          }
                          $http({
                            method: 'POST',
                            url: 'http://localhost:9090/upsanphamnd/' + toadox + '/' + toadoy + '/' + idLoaisp + '/' + idVungxa +
                              '/' + idHuong + '/' + idDonvigia + '/' + ngaychuan + '/' + dientich +
                              '/' + gia + '/' + idmotacu + '/' + sotang + '/' + hem + '/' + phaply + '/' + thocu + '/' + phongngu + '/' + sotoilet
                              + '/' + tensanpham + '/' + idDuong + '/' + toadox + '/' + toadoy + '/' + chieurong
                              + '/' + chieudai + '/' + idnd + '/' + trangthaicu + '/' + idhinhh
                              + '/' + trangthaigd + '/' + idsp
                          })
                          alert("Cập Nhật Thành Công");
                        });
                    };

                  })
                  .catch(console.error);
              }
            }
          })
        }
        else { //toa do cũ
          if (file == undefined) { // check hình ảnh // hình cũ , tọa độ cũ // này ổn
            $http({
              method: 'POST',
              url: 'http://localhost:9090/upsanphamnd/' + tdxcu + '/' + tdycu + '/' + idLoaisp + '/' + idVungxa +
                '/' + idHuong + '/' + idDonvigia + '/' + ngaychuan + '/' + dientich +
                '/' + gia + '/' + idmotacu + '/' + sotang + '/' + hem + '/' + phaply + '/' + thocu + '/' + phongngu + '/' + sotoilet
                + '/' + tensanpham + '/' + idDuong + '/' + tdxcu + '/' + tdycu + '/' + chieurong
                + '/' + chieudai + '/' + idnd + '/' + trangthaicu + '/' + idhinhcu
                + '/' + trangthaigd + '/' + idsp
            })
            alert("Cập Nhật Thành Công");

          }
          else { // hình mới   tọa độ cũ hình mới
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
                  var idhinhh;
                  $http.get("http://localhost:9090/hinhanhs")
                    .then(function (response) {
                      $scope.data1 = [];
                      $scope.details = response.data;
                      var count = $scope.details.length;
                      for (var i = 0; i < count; i++) {
                        var track = response.data[i];
                        console.log(track);
                        idhinhh = track.idHinh + 1;
                      }
                      $http({
                        method: 'POST',
                        url: 'http://localhost:9090/upsanphamnd/' + tdxcu + '/' + tdycu + '/' + idLoaisp + '/' + idVungxa +
                          '/' + idHuong + '/' + idDonvigia + '/' + ngaychuan + '/' + dientich +
                          '/' + gia + '/' + idmotacu + '/' + sotang + '/' + hem + '/' + phaply + '/' + thocu + '/' + phongngu + '/' + sotoilet
                          + '/' + tensanpham + '/' + idDuong + '/' + tdxcu + '/' + tdycu + '/' + chieurong
                          + '/' + chieudai + '/' + idnd + '/' + trangthaicu + '/' + idhinhh
                          + '/' + trangthaigd + '/' + idsp
                      })
                      alert("Cập Nhật Thành Công");
                    });
                };

              })
              .catch(console.error);
          }
        }
      }
    }
    else { /// sp nhà
      if (tensanpham == undefined || gia == undefined || chieurong == undefined || chieudai == undefined || dientich == undefined || thocu == undefined
        || mota == undefined || toadox == undefined || toadoy == undefined || idLoaisp == undefined || idVungxa == undefined || idDuong == undefined || idHuong == undefined
        || idDonvigia == undefined || phaply == undefined || hem == undefined) {

        alert("Vui lòng nhập những thông tim cần thiết");
      }
      else { // nếu dữ liệu hợp lệ thì check tọa độ
        if (toadox != tdxcu || idvungcu != idVungxa) //nếu khác thì phải check
        {
          var vung = document.getElementById("idVungxa").value;
          var sel = document.getElementById("idVungxa");
          var text = sel.options[sel.selectedIndex].text;
          $http({
            method: "GET",
            url: 'http://localhost:9090/searchxy/' + toadox + '/' + toadoy
          }).then(function mySuccess(response) {
            $scope.kiemtra = response.data;
            var a = $scope.kiemtra;
            if (a.idVungxa != vung) {
              alert("Tọa Độ Ngoài Vùng" + " " + text + " Vui lòng chọn lại tọa độ");
              document.getElementById("toadox").value = "";
              document.getElementById("toadoy").value = "";
            }
            else { // tọa độ mới mà trong vùng
              if (file == undefined) { // check hình ảnh // hình cũ , tọa độ mới // này ổn
                $http({
                  method: 'POST',
                  url: 'http://localhost:9090/upsanphamnd/' + toadox + '/' + toadoy + '/' + idLoaisp + '/' + idVungxa +
                    '/' + idHuong + '/' + idDonvigia + '/' + ngaychuan + '/' + dientich +
                    '/' + gia + '/' + idmotacu + '/' + sotang + '/' + hem + '/' + phaply + '/' + thocu + '/' + phongngu + '/' + sotoilet
                    + '/' + tensanpham + '/' + idDuong + '/' + toadox + '/' + toadoy + '/' + chieurong
                    + '/' + chieudai + '/' + idnd + '/' + trangthaicu + '/' + idhinhcu
                    + '/' + trangthaigd + '/' + idsp
                })
                alert("Cập Nhật Thành Công");

              }
              else { // hình mới   tọa độ mới hình mới
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
                      var idhinhh;
                      $http.get("http://localhost:9090/hinhanhs")
                        .then(function (response) {
                          $scope.data1 = [];
                          $scope.details = response.data;
                          var count = $scope.details.length;
                          for (var i = 0; i < count; i++) {
                            var track = response.data[i];
                            console.log(track);
                            idhinhh = track.idHinh + 1;
                            // console.log(idhinhh);
                          }
                          $http({
                            method: 'POST',
                            url: 'http://localhost:9090/upsanphamnd/' + toadox + '/' + toadoy + '/' + idLoaisp + '/' + idVungxa +
                              '/' + idHuong + '/' + idDonvigia + '/' + ngaychuan + '/' + dientich +
                              '/' + gia + '/' + idmotacu + '/' + sotang + '/' + hem + '/' + phaply + '/' + thocu + '/' + phongngu + '/' + sotoilet
                              + '/' + tensanpham + '/' + idDuong + '/' + toadox + '/' + toadoy + '/' + chieurong
                              + '/' + chieudai + '/' + idnd + '/' + trangthaicu + '/' + idhinhh
                              + '/' + trangthaigd + '/' + idsp
                          })
                           alert("Cập Nhật Thành Công");
                        });
                    };

                  })
                  .catch(console.error);
              }
            }
          })
        }
        else { //toa do cũ
          if (file == undefined) { // check hình ảnh // hình cũ , tọa độ cũ // này ổn
            $http({
              method: 'POST',
              url: 'http://localhost:9090/upsanphamnd/' + tdxcu + '/' + tdycu + '/' + idLoaisp + '/' + idVungxa +
                '/' + idHuong + '/' + idDonvigia + '/' + ngaychuan + '/' + dientich +
                '/' + gia + '/' + idmotacu + '/' + sotang + '/' + hem + '/' + phaply + '/' + thocu + '/' + phongngu + '/' + sotoilet
                + '/' + tensanpham + '/' + idDuong + '/' + tdxcu + '/' + tdycu + '/' + chieurong
                + '/' + chieudai + '/' + idnd + '/' + trangthaicu + '/' + idhinhcu
                + '/' + trangthaigd + '/' + idsp
            })
            alert("Cập Nhật Thành Công");

          }
          else { // hình mới   tọa độ cũ hình mới
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
                  var idhinhh;
                  $http.get("http://localhost:9090/hinhanhs")
                    .then(function (response) {
                      $scope.data1 = [];
                      $scope.details = response.data;
                      var count = $scope.details.length;
                      for (var i = 0; i < count; i++) {
                        var track = response.data[i];
                        console.log(track);
                        idhinhh = track.idHinh + 1;
                      }
                      $http({
                        method: 'POST',
                        url: 'http://localhost:9090/upsanphamnd/' + tdxcu + '/' + tdycu + '/' + idLoaisp + '/' + idVungxa +
                          '/' + idHuong + '/' + idDonvigia + '/' + ngaychuan + '/' + dientich +
                          '/' + gia + '/' + idmotacu + '/' + sotang + '/' + hem + '/' + phaply + '/' + thocu + '/' + phongngu + '/' + sotoilet
                          + '/' + tensanpham + '/' + idDuong + '/' + tdxcu + '/' + tdycu + '/' + chieurong
                          + '/' + chieudai + '/' + idnd + '/' + trangthaicu + '/' + idhinhh
                          + '/' + trangthaigd + '/' + idsp
                      })
                       alert("Cập Nhật Thành Công");
                    });
                };

              })
              .catch(console.error);
          }
        }
      }

    }


  }


});


