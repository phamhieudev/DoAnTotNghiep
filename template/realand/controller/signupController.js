var app = angular.module('signupApp', []);
app.controller('signupCtrl', function ($scope, $http, $rootScope, $sce) {

    document.getElementById("dadangnhap").style.display="none";
    $rootScope.session = window.localStorage.getItem("SessionId");
    $rootScope.namekh = window.localStorage.getItem("ten");
    $rootScope.isLoggedIn = window.localStorage.getItem("isLoggedIn");
    // $scope.check = checkAuth.getuserInfo();
    var idnd = window.localStorage.getItem("idnd");
  
  
    if( $rootScope.isLoggedIn==null ||  $rootScope.isLoggedIn==undefined)
    {
      document.getElementById("dadangnhap").style.display="none";
    }
    else{
      document.getElementById("dadangnhap").style.display="block";
      document.getElementById("chuadangnhap").style.display="none";
      location.href = "http://127.0.0.1:5501/realand/trangchu.html";

    }
    
    $scope.dangxuat = function () {
      window.localStorage.clear();
      $rootScope.isLoggedIn = false;
      location.href = "http://127.0.0.1:5501/realand/trangchu.html";
   };


    document.getElementById("quenmatkhau").style.display = "none";   
     $http({
        method: "GET",
        url: "http://localhost:9090/nguoidungs"
    }).then(function mySuccess(response) {
        $scope.nguoidungs = response.data;
    }, function myError(response) {
        $scope.nguoidungs = response.statusText;
    });

    $rootScope.isLoggedIn = false;

    $scope.dangnhap = function (email, pass) {
        var descrypt = CryptoJS.MD5(pass);
        var count = $scope.nguoidungs.length;
        for (var i = 0; i < count; i++) {
            var track = $scope.nguoidungs[i];
            if ((track.mail == email) && (track.password == descrypt)) {
                $rootScope.isLoggedIn = true;
                $scope.namekh = track.tenNguoidung;
                $scope.idnd=track.idNguoidung;
                window.localStorage.setItem("SessionId", $scope.session);
                window.localStorage.setItem("isLoggedIn", $scope.isLoggedIn);
                window.localStorage.setItem("ten", $scope.namekh);
                window.localStorage.setItem("idnd", $scope.idnd);
                window.location = "http://127.0.0.1:5501/realand/trangchu.html";
            }
        }
        if ($rootScope.isLoggedIn == false) {
            alert("Sai tên đăng nhập hoặc mật khẩu");
        }
    }

    $scope.quenmk = function () {
        document.getElementById("dangnhadangky").style.display = "none"; 
        document.getElementById("headerdangnhapdangky").style.display = "none";
        document.getElementById("quenmatkhau").style.display = "block"; 

        function makeid(length) {
            var result           = '';
            var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
            var charactersLength = characters.length;
            for ( var i = 0; i < length; i++ ) {
               result += characters.charAt(Math.floor(Math.random() * charactersLength));
            }
            return result;
         }
         
        $scope.guimail=function(email){
            var a=0;
            var mailtam;
            var idnd;
            var mk=makeid(5);
            angular.forEach($scope.nguoidungs, function (item) {
                if ((item.mail == email)) {
                    a = a + 1;
                    mailtam=item.mail;
                    idnd=item.idNguoidung;
                }
            });
            if (a != 0) {
                var mailmd5 = CryptoJS.MD5(mailtam);
                window.localStorage.setItem("mailmd5",mailmd5);
                
                $http({
                   
                    url: 'http://localhost:9090/sendEmail/' + email + '/' + mailmd5 + '/' + idnd
                  })   
                 $scope.loginMessage = $sce.trustAsHtml('<div class="alert alert-success" role="alert"><p style="font-size:15px;">Chúng tôi đã gửi email thiết lập lại mật khẩu đến tài khoản yêu cầu.!</p> </div>');
                 $scope.loginMessage1 = $sce.trustAsHtml('<div class="alert alert-success" role="alert"><p style="font-size:15px;">Nếu bạn không thể truy cập email đó, vui lòng liên hệ trung tâm hỗ trợ khách hàng theo số 18001207!</p> </div>');  

            }
            else {
                $scope.loginMessage = $sce.trustAsHtml('<div class="alert alert-danger" role="alert"><h5>Mail không tồn tại trong hệ thống!</h5> </div>'); 
            }
        }
    }

    $scope.dangkytaikhoan = function (tenNguoidung, mail, phone, password) {

        var passa = CryptoJS.MD5(password);
        var b = String(passa);
        var a = 0;
        // $scope.save1 = "modal";//Nhập đủ thì lưu lại và form biến mất
        angular.forEach($scope.nguoidungs, function (item) {
            if ((item.mail == mail || item.phone == phone)) {
                a = a + 1;
            }
        });
        if (a != 0) {
            // alert("Mail hoặc Số Điện Thoại đã tồn tại trong hệ thống")
            $scope.loginMessage = $sce.trustAsHtml('<div class="alert alert-danger" role="alert"><h5>Mail hoặc Số Điện Thoại đã tồn tại trong hệ thống!</h5> </div>');   
        }
        else {
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
                $http({
                    method: 'GET',
                    url: 'http://localhost:9090/sendHtmlEmail/' + mail + '/' + tenNguoidung
                  })   

             $scope.loginMessage = $sce.trustAsHtml('<div class="alert alert-success" role="alert"><h5>Đăng Ký Thành Công! </h5></div>');  
          
            });
        }
    }
});
