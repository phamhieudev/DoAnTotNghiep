var app = angular.module('adminApp', []);
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

app.controller('adminCtrl', function ($scope, $http,checkAuth,$rootScope) {

  // $rootScope.session = window.localStorage.getItem("Session");
  $rootScope.nameadmin = window.localStorage.getItem("tenadmin");
  $rootScope.isLoggedInadmin = window.localStorage.getItem("isLoggedInadmin");
  $scope.check = checkAuth.getuserInfo();

  $scope.logout = function () {
     window.localStorage.clear();
     $rootScope.isLoggedIn = false;
     location.href = "http://127.0.0.1:5501/login.html";
    
  };

  // lấy Dữ Liệu
  $http({
    method: "GET",
    url: "http://localhost:9090/Admins"
  }).then(function mySuccess(response) {
    $scope.nguoidungs = response.data;
  }, function myError(response) {
    $scope.nguoidungs = response.statusText;
  });

  $http({
    method: "GET",
    url: "http://localhost:9090/Phanquyenadmins"
  }).then(function mySuccess(response) {
    $scope.Phanquyenadmins = response.data;
  }, function myError(response) {
    $scope.Phanquyenadmins = response.statusText;
  });

  //   /// thêm loại
  $scope.createnguoidung = function ()//Khi bấm vào nút THÊM
  {

    //Khi thêm mới thì các field trong form phải trống
    $scope.tenadmin = "";
    $scope.mail = "";
    $scope.phone = "";
    $scope.password = "";
  };
  $scope.addadmin = function (tenadmin,mail,phone,password,idrole)//Lưu lúc thêm
  {
    // $scope.save1 = "modal";//Nhập đủ thì lưu lại và form biến mất
    var a=0;
      angular.forEach($scope.nguoidungs, function (item) {
          if ((item.mailAdmin == mail || item.dienthoaiAdmin == phone)) {
            a=a+1;
          }
      });
      if(a!=0){
        alert("Mail hoặc Số Điện Thoại đã tồn tại trong hệ thống")
      }
      else{
        var data =
        {
          nameAdmin: tenadmin,
          mailAdmin: mail,
          dienthoaiAdmin: phone,
          matkhauAdmin: password,
          phanquyenadmin: {
              idRoleadmin: idrole,
              nameRole: ""
          }
      };
    $http.post('http://localhost:9090/createAdmin', JSON.stringify(data)).then(function (response) {
      if (response.data) {
        ///
      }
    }, function (response) {
      var r = alert("Đã thêm mới!");
      window.location.reload();
      $scope.nguoidungs = response.statusText;
    });
      }
      
  };
  $scope.editnguoidung = function (admin)//Khi bấm vào biểu tượng sửa
  {

    $scope.idadmin = admin.idAdmin;
    $scope.tenadmin = admin.nameAdmin;
    $scope.mail = admin.mailAdmin;
    $scope.phone = admin.dienthoaiAdmin;
    $scope.password = admin.matkhauAdmin;
    document.getElementById("idrole1").value = admin.phanquyenadmin.idRoleadmin;


  };

  //Sửa dữ liệu JSON ở server bằng phương thức $http.put
  $scope.updateadmin = function (idadmin,tenadmin,mail,phone,password)//Lưu lúc sửa
  {
    var idrole1=document.getElementById("idrole1").value;
    $scope.save2 = "modal";//Nhập đủ thì lưu lại và form biến mất

    var data =
        {
          nameAdmin: tenadmin,
          mailAdmin: mail,
          dienthoaiAdmin: phone,
          matkhauAdmin: password,
          phanquyenadmin: {
              idRoleadmin: idrole1,
              nameRole: ""
          }
      };

    $http.put('http://localhost:9090/updateAdmin/' + idadmin, JSON.stringify(data)).then(function (response) {
      if (response.data) {
        // 
      }
    }, function (response) {
      alert("Cập Nhật Thành Công!");
       window.location.reload();
    });

  };

  $scope.xoanguoidung = function (x)////Khi bấm vào nút DELETE
  {
    var id = x.idAdmin;
    var r = confirm("Bạn Chắc Chắn Xóa ?");
    if (r == true) {
      $http({
        method: 'DELETE',
        url: 'http://localhost:9090/xoaadmin/' + id
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