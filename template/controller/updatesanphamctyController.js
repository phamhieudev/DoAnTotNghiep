var app = angular.module('upsanphamctyApp', []);
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
app.controller('upsanphamctyCtrl', function ($scope, $http,checkAuth,$rootScope) {

  // function ymd(inputString)//Chuyển định dạng sang năm tháng ngày
  // {
  //   var year = inputString.substring(0, 4);//Lấy năm của đầu sách
  //   var month = inputString.substring(5, 7);//Lấy tháng của đầu sách
  //   var day = inputString.substring(8, 10);//Lấy ngày của đầu sách
  //   var myDate = month + "-" + day + "-" + year;//Định dạng yyyy-MM-dd
  //   return myDate;
  // }

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
    url: "http://localhost:9090/duongs"
  }).then(function mySuccess(response) {
    $scope.duongs = response.data;
  }, function myError(response) {
    $scope.duongs = response.statusText;
  });

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

  $scope.funcDonvigia = function (idDonvigia) {
    var a = $scope.gia;
    if (idDonvigia == 1 && a > 999) {
      alert("Đơn vị Giá là Triệu , giá trị Giá không thể lớn hơn 999");
      $scope.gia = "";
      $scope.idDonvigia = "";
    }
  }
  $http({
    method: "GET",
    url: "http://localhost:9090/donvigias"
  }).then(function mySuccess(response) {
    $scope.donvigias = response.data;
  }, function myError(response) {
    $scope.donvigias = response.statusText;
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
  $scope.myFunc = function (idLoaisp) {
    if (idLoaisp == 15) {
      document.getElementById("grTang").style.display = "block";
      document.getElementById("grToilet").style.display = "block";
      document.getElementById("grPhongngu").style.display = "block";
    }
    else {
      document.getElementById("grTang").style.display = "none";
      document.getElementById("grToilet").style.display = "none";
      document.getElementById("grPhongngu").style.display = "none";
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


  var idsp = location.search.split('id=')[1];
  var tdxcucty;
  var tdycucty;
  var idhinhcucty;
  var idvungcucty;
  var idmotacucty;
  $scope.data1 = [];
  $http({
    method: "GET",
    url: "http://localhost:9090/sanphamcty/" + idsp
  }).then(function mySuccess(response) {
    $scope.details = response.data;

    var track = $scope.details;
    document.getElementById("grTang").style.display = "none";
    document.getElementById("grToilet").style.display = "none";
    document.getElementById("grPhongngu").style.display = "none";
    // console.log(track);
    document.getElementById("idLoaisp").value = track.loaisanpham.idLoaisp;

    if (track.loaisanpham.idLoaisp == 15) { // nhà
      document.getElementById("grTang").style.display = "block";
      document.getElementById("grToilet").style.display = "block";
      document.getElementById("grPhongngu").style.display = "block";
    }
    document.getElementById("idVungxa").value = track.vungxa.idVungxa;

    document.getElementById("idDuong").value = track.duong.idDuong;

    document.getElementById("idHuong").value = track.huong.idHuong;

    document.getElementById("phaply").value = track.phaply.idphaply;

    document.getElementById("hem").value = track.chieuronghem.idhem;
    $scope.tensanpham = track.nameSanpham_cty;
    $scope.gia = track.giaSanpham_cty;
    $scope.dientich = track.dientichSanpham_cty;
    $scope.chieurong = track.chieurongSanpham_cty;
    $scope.chieudai = track.chieudaiSanpham_cty;
    document.getElementById("idDonvigia").value = track.donvigia.idDonvigia;
    $scope.mota = track.motatindang.noidung;
    idmotacucty=track.motatindang.idMota;
    $scope.thocu = track.thocuSanpham_cty;
    $scope.sotang = track.sotangSanpham_cty;
    $scope.phongngu = track.sophongnguSanpham_cty;
    $scope.sotoilet = track.sotoiletSanpham_cty;
    $scope.toadox = track.lonSanpham_cty;
    tdxcucty = track.lonSanpham_cty;
    $scope.toadoy = track.latSanpham_cty;
    tdycucty = track.latSanpham_cty;
    $scope.hinhcu = track.hinhanh.url;
    idhinhcucty=track.hinhanh.idHinh;

    sessionStorage.setItem("tdxchinhsuacty", track.lonSanpham_cty);
    sessionStorage.setItem("tdychinhsuacty", track.latSanpham_cty);

  });
  

  $scope.updatesanphamcty = function (tensanpham, gia, chieurong, chieudai, dientich, thocu, sotang, phongngu, sotoilet, mota) {
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
    var toadox = document.getElementById("toadox").value;
    var toadoy = document.getElementById("toadoy").value;


    var idLoaisp = document.getElementById("idLoaisp").value;
    var idVungxa = document.getElementById("idVungxa").value;
    var idDuong = document.getElementById("idDuong").value;
    var idHuong = document.getElementById("idHuong").value;
    var idDonvigia = document.getElementById("idDonvigia").value;
    var phaply = document.getElementById("phaply").value;
    var hem = document.getElementById("hem").value;
    var trangthaigd=1;

    const file = document.querySelector("#file-input").files[0];

    var datamota = {
      noidung: mota
    };
    $http.put('http://localhost:9090/updateMotatindang/' + idmotacucty, JSON.stringify(datamota)).then(function (response) {
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
          console.log(chieurong);

        alert("Vui lòng nhập những thông tim cần thiết");
      }
      else { // nếu dữ liệu hợp lệ thì check tọa độ
        if (toadox != tdxcucty || idvungcucty != idVungxa) //nếu khác thì phải check
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
                  method: 'PUT',
                  url: 'http://localhost:9090/updatesanphamcty/' + toadox + '/' + toadoy + '/' + idLoaisp + '/' + idVungxa +
                    '/' + idHuong + '/' + idDonvigia + '/' + ngaychuan + '/' + dientich +
                    '/' + gia + '/' + idmotacucty + '/' + sotang + '/' + hem + '/' + phaply + '/' + thocu + '/' + phongngu + '/' + sotoilet
                    + '/' + tensanpham + '/' + idDuong + '/' + toadox + '/' + toadoy + '/' + chieurong
                    + '/' + chieudai + '/' + idhinhcucty
                    + '/' + trangthaigd + '/' + idsp
                })
                setTimeout(function(){ alert("Cập Nhật Thành Công"); }, 5000);

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
                            method: 'PUT',
                            url: 'http://localhost:9090/updatesanphamcty/' + toadox + '/' + toadoy + '/' + idLoaisp + '/' + idVungxa +
                              '/' + idHuong + '/' + idDonvigia + '/' + ngaychuan + '/' + dientich +
                              '/' + gia + '/' + idmotacucty + '/' + sotang + '/' + hem + '/' + phaply + '/' + thocu + '/' + phongngu + '/' + sotoilet
                              + '/' + tensanpham + '/' + idDuong + '/' + toadox + '/' + toadoy + '/' + chieurong
                              + '/' + chieudai +  '/' + idhinhh
                              + '/' + trangthaigd + '/' + idsp
                          })
                          setTimeout(function(){ alert("Cập Nhật Thành Công"); }, 5000);
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
              method: 'PUT',
              url: 'http://localhost:9090/updatesanphamcty/' + tdxcucty + '/' + tdycucty + '/' + idLoaisp + '/' + idVungxa +
                '/' + idHuong + '/' + idDonvigia + '/' + ngaychuan + '/' + dientich +
                '/' + gia + '/' + idmotacucty + '/' + sotang + '/' + hem + '/' + phaply + '/' + thocu + '/' + phongngu + '/' + sotoilet
                + '/' + tensanpham + '/' + idDuong + '/' + tdxcucty + '/' + tdycucty + '/' + chieurong
                + '/' + chieudai + '/' + idhinhcucty
                + '/' + trangthaigd + '/' + idsp
            })
            setTimeout(function(){ alert("Cập Nhật Thành Công"); }, 5000);

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
                        method: 'PUT',
                        url: 'http://localhost:9090/updatesanphamcty/' + tdxcucty + '/' + tdycucty + '/' + idLoaisp + '/' + idVungxa +
                          '/' + idHuong + '/' + idDonvigia + '/' + ngaychuan + '/' + dientich +
                          '/' + gia + '/' + idmotacucty + '/' + sotang + '/' + hem + '/' + phaply + '/' + thocu + '/' + phongngu + '/' + sotoilet
                          + '/' + tensanpham + '/' + idDuong + '/' + tdxcucty + '/' + tdycucty + '/' + chieurong
                          + '/' + chieudai + '/' + idhinhh
                          + '/' + trangthaigd + '/' + idsp
                      })
                      setTimeout(function(){ alert("Cập Nhật Thành Công"); }, 5000);
                    });
                };

              })
              .catch(console.error);
          }
        }
      }
    }
    else{
      if (tensanpham == undefined || gia == undefined || chieurong == undefined || chieudai == undefined || dientich == undefined || thocu == undefined
        || mota == undefined || toadox == undefined || toadoy == undefined || idLoaisp == undefined || idVungxa == undefined || idDuong == undefined || idHuong == undefined
        || idDonvigia == undefined || phaply == undefined || hem == undefined) {
          console.log(chieurong);

        alert("Vui lòng nhập những thông tim cần thiết");
      }
      else { // nếu dữ liệu hợp lệ thì check tọa độ
        if (toadox != tdxcucty || idvungcucty != idVungxa) //nếu khác thì phải check
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
                  method: 'PUT',
                  url: 'http://localhost:9090/updatesanphamcty/' + toadox + '/' + toadoy + '/' + idLoaisp + '/' + idVungxa +
                    '/' + idHuong + '/' + idDonvigia + '/' + ngaychuan + '/' + dientich +
                    '/' + gia + '/' + idmotacucty + '/' + sotang + '/' + hem + '/' + phaply + '/' + thocu + '/' + phongngu + '/' + sotoilet
                    + '/' + tensanpham + '/' + idDuong + '/' + toadox + '/' + toadoy + '/' + chieurong
                    + '/' + chieudai + '/' + idhinhcucty
                    + '/' + trangthaigd + '/' + idsp
                })
                setTimeout(function(){ alert("Cập Nhật Thành Công"); }, 5000);

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
                            method: 'PUT',
                            url: 'http://localhost:9090/updatesanphamcty/' + toadox + '/' + toadoy + '/' + idLoaisp + '/' + idVungxa +
                              '/' + idHuong + '/' + idDonvigia + '/' + ngaychuan + '/' + dientich +
                              '/' + gia + '/' + idmotacucty + '/' + sotang + '/' + hem + '/' + phaply + '/' + thocu + '/' + phongngu + '/' + sotoilet
                              + '/' + tensanpham + '/' + idDuong + '/' + toadox + '/' + toadoy + '/' + chieurong
                              + '/' + chieudai +  '/' + idhinhh
                              + '/' + trangthaigd + '/' + idsp
                          })
                          setTimeout(function(){ alert("Cập Nhật Thành Công"); }, 5000);;
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
              method: 'PUT',
              url: 'http://localhost:9090/updatesanphamcty/' + tdxcucty + '/' + tdycucty + '/' + idLoaisp + '/' + idVungxa +
                '/' + idHuong + '/' + idDonvigia + '/' + ngaychuan + '/' + dientich +
                '/' + gia + '/' + idmotacucty + '/' + sotang + '/' + hem + '/' + phaply + '/' + thocu + '/' + phongngu + '/' + sotoilet
                + '/' + tensanpham + '/' + idDuong + '/' + tdxcucty + '/' + tdycucty + '/' + chieurong
                + '/' + chieudai + '/' + idhinhcucty
                + '/' + trangthaigd + '/' + idsp
            })
            setTimeout(function(){ alert("Thêm Thành Công"); }, 5000);

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
                        method: 'PUT',
                        url: 'http://localhost:9090/updatesanphamcty/' + tdxcucty + '/' + tdycucty + '/' + idLoaisp + '/' + idVungxa +
                          '/' + idHuong + '/' + idDonvigia + '/' + ngaychuan + '/' + dientich +
                          '/' + gia + '/' + idmotacucty + '/' + sotang + '/' + hem + '/' + phaply + '/' + thocu + '/' + phongngu + '/' + sotoilet
                          + '/' + tensanpham + '/' + idDuong + '/' + tdxcucty + '/' + tdycucty + '/' + chieurong
                          + '/' + chieudai + '/' + idhinhh
                          + '/' + trangthaigd + '/' + idsp
                      })
                      setTimeout(function(){ alert("Cập Nhật Thành Công"); }, 5000);
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
