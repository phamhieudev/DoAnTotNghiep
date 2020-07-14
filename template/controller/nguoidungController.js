var app = angular.module('nguoidungApp', []);
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

app.controller('nguoidungCtrl', function ($scope, $http,checkAuth,$rootScope) {

  // $rootScope.session = window.localStorage.getItem("Session");
  $rootScope.nameadmin = window.localStorage.getItem("tenadmin");
  $rootScope.roleadmin = window.localStorage.getItem("roleadmin");
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

  // lấy Dữ Liệu
  $http({
    method: "GET",
    url: "http://localhost:9090/nguoidungs"
  }).then(function mySuccess(response) {
    $scope.nguoidungs = response.data;
  }, function myError(response) {
    $scope.nguoidungs = response.statusText;
  });

  //   /// thêm loại
  $scope.createnguoidung = function ()//Khi bấm vào nút THÊM
  {

    //Khi thêm mới thì các field trong form phải trống
    $scope.tenNguoidung = "";
    $scope.mail = "";
    $scope.phone = "";
    $scope.password = "";
  };
  $scope.addnguoidung = function (tenNguoidung, mail, phone, password)//Lưu lúc thêm
  {
    var passa = CryptoJS.MD5(password);
    var b = String(passa);
      var a =0;
    // $scope.save1 = "modal";//Nhập đủ thì lưu lại và form biến mất
      angular.forEach($scope.nguoidungs, function (item) {
          if ((item.mail == mail || item.phone == phone)) {
            a=a+1;
          }
      });
      if(a!=0){
        alert("Mail hoặc Số Điện Thoại đã tồn tại trong hệ thống")
      }
      else{
        var data =
      {
        password: b,
        mail: mail,
        phone: phone,
        tenNguoidung: tenNguoidung
      };
    $http.post('http://localhost:9090/addnguoidung', JSON.stringify(data)).then(function (response) {
      if (response.data) {
        ///
      }
    }, function (response) {
      var r = alert("Đã thêm mới Người Dùng!");
      window.location.reload();
      $scope.nguoidungs = response.statusText;
    });
      }
      
  };
  $scope.editnguoidung = function (nguoidung)//Khi bấm vào biểu tượng sửa
  {

    $scope.idNguoidung = nguoidung.idNguoidung;
    $scope.tenNguoidung = nguoidung.tenNguoidung;
    $scope.mail = nguoidung.mail;
    $scope.phone = nguoidung.phone;
    $scope.password = nguoidung.password;
  };

  //Sửa dữ liệu JSON ở server bằng phương thức $http.put
  $scope.updatenguoidung = function (idNguoidung, tenNguoidung, mail, phone, password)//Lưu lúc sửa
  {

    $scope.save2 = "modal";//Nhập đủ thì lưu lại và form biến mất
    var passa = CryptoJS.MD5(password);
    var b = String(passa);
    var data =
    {
      idNguoidung: idNguoidung,
      password: b,
      mail: mail,
      phone: phone,
      tenNguoidung: tenNguoidung
    };

    $http.put('http://localhost:9090/updatenguoidung/' + idNguoidung, JSON.stringify(data)).then(function (response) {
      if (response.data) {
        // 
      }
    }, function (response) {
      alert("Cập Nhật Thành Công!");
      window.location.reload();
    });

  };

  $scope.xoanguoidung = function (nguoidung)////Khi bấm vào nút DELETE
  {
    var id = nguoidung.idNguoidung;
    var r = confirm("Bạn Chắc Chắn Xóa ?");
    if (r == true) {
      $http({
        method: 'DELETE',
        url: 'http://localhost:9090/xoanguoidung/' + id
      })
      alert("Xóa Thành Công");
      window.location.reload();
    }
    else {
      alert("Xóa Thất Bại");
      window.location.reload();
    } 
  };

});


function ymd(inputString)//Chuyển định dạng sang năm tháng ngày
{
  var year = inputString.substring(0, 4);//Lấy năm của đầu sách
  var month = inputString.substring(5, 7);//Lấy tháng của đầu sách
  var day = inputString.substring(8, 10);//Lấy ngày của đầu sách
  var myDate = year + "-" + month + "-" + day;//Định dạng yyyy-MM-dd
  return myDate;
}