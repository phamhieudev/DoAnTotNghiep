var app = angular.module('datlaimkApp', []);
app.controller('datlaimkCtrl', function ($scope, $http,$sce,$rootScope) {

  
  document.getElementById("dadangnhap").style.display="none";
  $rootScope.session = window.localStorage.getItem("SessionId");
  $rootScope.namekh = window.localStorage.getItem("ten");
  $rootScope.isLoggedIn = window.localStorage.getItem("isLoggedIn");
  // $scope.check = checkAuth.getuserInfo();
  // var idnd = window.localStorage.getItem("idnd");


  if( $rootScope.isLoggedIn==null ||  $rootScope.isLoggedIn==undefined)
  {
    document.getElementById("dadangnhap").style.display="none";
  }
  else{
    document.getElementById("dadangnhap").style.display="block";
    document.getElementById("chuadangnhap").style.display="none";
  }
  
  $scope.dangxuat = function () {
    window.localStorage.clear();
    $rootScope.isLoggedIn = false;
    location.href = "http://127.0.0.1:5501/realand/trangchu.html";
 };

    var myParam = location.search.split('md5=')[1];
    // alert(myParam);
    var mailmd5 = window.localStorage.getItem("mailmd5");
    // console.log(mailmd5);
    var descrypt = CryptoJS.MD5(myParam);
    console.log(descrypt);
    var abc = location.search.split('abz=')[1];

    if(myParam==undefined &&abc==undefined){
        document.getElementById("pass").disabled = true;
        document.getElementById("thaydoi").disabled = true;
    }
    else{
        $scope.doipass=function(password){
            var descryptpass = CryptoJS.MD5(password);
            var b = String(descryptpass);
            $http({
                method: "GET",
                url: "http://localhost:9090/nguoidung/" + abc
              }).then(function mySuccess(response) {
                $scope.details = response.data;
                var track = $scope.details;
                // alert(track.mail);
                var data =
                {
                    password: b,
                    mail: track.mail,
                    phone: track.phone,
                    tenNguoidung: track.tenNguoidung
                };
          
                $http.put('http://localhost:9090/updatenguoidung/' + abc, JSON.stringify(data)).then(function (response) {
                  if (response.data) {
                    // 
                  }
                }, function (response) {
                    $scope.loginMessage = $sce.trustAsHtml('<div class="alert alert-success" role="alert"><p style="font-size:15px;">Đặt Lại Mật Khẩu Thành Công!</p> </div>');  

                 
                });
            
              });
        }
    }
    

});
