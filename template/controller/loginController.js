var app = angular.module('loginApp', []);
app.controller('loginCtrl', function ($scope, $http, $rootScope) {

    $http({
        method: "GET",
        url: "http://localhost:9090/Admins"
    }).then(function mySuccess(response) {
        $scope.admins = response.data;
    }, function myError(response) {
        $scope.admins = response.statusText;
    });

    $rootScope.isLoggedInadmin = false;

    $scope.dangnhap = function (email, matkhau) {

        var count = $scope.admins.length;
        for (var i = 0; i < count; i++) {
            var track = $scope.admins[i];
            if ((track.mailAdmin == email) && (track.matkhauAdmin == matkhau)) {
                $rootScope.isLoggedInadmin = true;
                $scope.nameadmin = track.nameAdmin;
                $scope.roleadmin = track.phanquyenadmin.idRoleadmin;
                // window.localStorage.setItem("Session", $scope.session);
                window.localStorage.setItem("isLoggedInadmin", $scope.isLoggedInadmin);
                window.localStorage.setItem("tenadmin", $scope.nameadmin);
                window.localStorage.setItem("roleadmin", $scope.roleadmin);
                window.location = "http://127.0.0.1:5501/customer.html";
            }
        }
        if($rootScope.isLoggedInadmin == false){
            alert("Sai tên đăng nhập hoặc mật khẩu");
        }
    }

    $scope.quenmk = function () {
        alert("Vui lòng liên hệ Phòng CNTT để reset mật khẩu");
    }
});

