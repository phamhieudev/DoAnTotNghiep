var app = angular.module('loaisanphamApp', []);
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
app.controller('loaisanphamCtrl', function ($scope, $http,checkAuth,$rootScope) {
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

  // lấy Dữ Liệu
  $http({
    method: "GET",
    url: "http://localhost:9090/loaisanphams"
  }).then(function mySuccess(response) {
    $scope.loaisanphams = response.data;
  }, function myError(response) {
    $scope.loaisanphams = response.statusText;
  });

  /// thêm loại
  $scope.createLoaisanpham = function ()//Khi bấm vào nút THÊM
  {
    $scope.modalTitle = "THÊM LOẠI SẢN PHẨM";//Thay đổi tiêu đề của modal
    $scope.adding = true;//Đang thêm = true
    $scope.modifying = false;//Đang sửa = false
    $scope.disabled = true;//enable id_ISBN

    //Khi thêm mới thì các field trong form phải trống
    $scope.tenloaisanpham = "";
  };
  $scope.addLoaisanpham = function (idLoaisp, tenloaisanpham)//Lưu lúc thêm
  {
    if (tenloaisanpham == "") {
      alert("Vui lòng nhập những thông tin cần thiết!");
      $scope.save1 = "";//Nhập thiếu thì form không biến mất
      return;
    }
    else {
      $scope.save1 = "modal";//Nhập đủ thì lưu lại và form biến mất

      var data =
      {
        tenLoaisp: tenloaisanpham
      };

      $http.post('http://localhost:9090/addloaisanpham', JSON.stringify(data)).then(function (response) {
        if (response.data) {
          ///
        }
      }, function (response) {
        var r = alert("Đã thêm mới Loại Sản Phẩm!");
        window.location.reload();
        $scope.loaisanphams = response.statusText;
      });
    }
  };
  $scope.editLoaisanpham = function (loaisanpham)//Khi bấm vào biểu tượng sửa
  {
    $scope.modalTitle = "CẬP NHẬT LOẠI SẢN PHẨM";//Thay đổi tiêu đề của modal
    $scope.adding = false;//Đang thêm = false
    $scope.modifying = true;//Đang sửa = true
    $scope.disabled = true;//disable id_ISBN không cho sửa

    $scope.idLoaisp = loaisanpham.idLoaisp;
    $scope.tenloaisanpham = loaisanpham.tenLoaisp;
  };

  //Sửa dữ liệu JSON ở server bằng phương thức $http.put
  $scope.updateLoaisanpham = function (idLoaisp, tenloaisanpham)//Lưu lúc sửa
  {
    if (idLoaisp == "" || tenloaisanpham == "") {
      alert("Vui lòng nhập những thông tin cần thiết!");
      $scope.save2 = "";//Nhập thiếu thì form không biến mất
      return;
    }
    else {
      $scope.save2 = "modal";//Nhập đủ thì lưu lại và form biến mất

      var data =
      {
        idLoaisp: idLoaisp,
        tenLoaisp: tenloaisanpham
      };

      $http.put('http://localhost:9090/updateloaisanpham/' + idLoaisp, JSON.stringify(data)).then(function (response) {
        if (response.data) {
          // 
        }
      }, function (response) {
        alert("Cập Nhật Thành Công!");
        window.location.reload();
      });
    }

  };

  $scope.deleteLoaisanpham = function(loaisanpham)////Khi bấm vào nút DELETE
  {

    var data =
    {
      id: loaisanpham.idLoaisp
    };
 

    $http.delete('http://localhost:9090/xoaloaisanpham/' + loaisanpham.idLoaisp, JSON.stringify(data)).then(function(response)
    {

      
      if(response.data){//Xóa thì không còn dữ liệu :D
      
    }
    }, function(response)
        {
          var r = alert("Đã xóa!");
        window.location.reload();
        });
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