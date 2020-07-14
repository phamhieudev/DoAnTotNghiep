var app = angular.module('thongkeApp', []);
app.factory('Excel',function($window){
  var uri='data:application/vnd.ms-excel;base64,',
      template='<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>',
      base64=function(s){return $window.btoa(unescape(encodeURIComponent(s)));},
      format=function(s,c){return s.replace(/{(\w+)}/g,function(m,p){return c[p];})};
  return {
      tableToExcel:function(tableId,worksheetName){
          var table=$(tableId),
              ctx={worksheet:worksheetName,table:table.html()},
              href=uri+base64(format(template,ctx));
          return href;
      }
  };
})
app.factory("checkAuth", function ($location,$rootScope) {
  return {
    getuserInfo: function () {
      if ($rootScope.isLoggedInadmin === undefined || $rootScope.isLoggedInadmin === null) {
        //$location.path('/login');
        location.href = "http://127.0.0.1:5501/login.html";
      }

    }
  };
});
app.controller('thongkeCtrl', function ($scope, $http,$timeout,Excel,checkAuth,$rootScope) {
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

    document.getElementById("loaisanpham").style.display = "none";
    document.getElementById("vungxa").style.display = "none";
    document.getElementById("chonloai").style.display = "none";
     document.getElementById("chonvungxa").style.display = "none";
     document.getElementById("nutxuat").style.display = "none";
     document.getElementById("nutxuatvung").style.display = "none";

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
    
    $scope.Functhongke = function () {
       var chon =   document.getElementById("thongke").value;
         if (chon == 1) {
         document.getElementById("chonloai").style.display = "block";
         document.getElementById("chonvungxa").style.display = "none";
         }
           else if (chon == 2){
            document.getElementById("chonvungxa").style.display = "block";
           document.getElementById("chonloai").style.display = "none";

         }
        //   else {
        // }
      };

      $scope.myFuncLoai = function (idLoaisp) {
        var tongsploai=0;
        $http({
          method: "GET",
          url: "http://localhost:9090/findbyidloai/" + idLoaisp
        }).then(function mySuccess(response) {
          $scope.sanphamtheoloais = response.data;
          var count = $scope.sanphamtheoloais.length;
          for (var i = 0; i < count; i++) {
            var track = response.data[i];
            tongsploai = tongsploai + 1;
          }
          $scope.tong=tongsploai;
          
        }, function myError(response) {
          $scope.sanphamtheoloais = response.statusText;
        });
        document.getElementById("loaisanpham").style.display = "block";
        document.getElementById("nutxuat").style.display = "block";
        document.getElementById("vungxa").style.display = "none";
        document.getElementById("nutxuatvung").style.display = "none";
      };

      $scope.myFuncVung = function (idvung) {
        var tongspvung=0;
        $http({
          method: "GET",
          url: "http://localhost:9090/findbyivung/" + idvung
        }).then(function mySuccess(response) {
          $scope.sanphamtheovungs = response.data;
          var count = $scope.sanphamtheovungs.length;
          for (var i = 0; i < count; i++) {
            var track = response.data[i];
            tongspvung = tongspvung + 1;
          }
          $scope.tong=tongspvung;
        }, function myError(response) {
          $scope.sanphamtheovungs = response.statusText;
        });
        document.getElementById("vungxa").style.display = "block";
        document.getElementById("nutxuatvung").style.display = "block";
        document.getElementById("loaisanpham").style.display = "none";
        document.getElementById("nutxuat").style.display = "none";
      };

    $scope.thongketheoloai=function(tenfile,tableId){ 
      if(tenfile == undefined){
        alert("Vui lòng nhập tên file");
      }// ex: '#my-table'
      else{
        var exportHref=Excel.tableToExcel(tableId,'WireWorkbenchDataExport');
    $timeout(function(){
      var a = document.createElement('a')
      a.href = exportHref
      a.download = tenfile+'.xls'
      a.click()
    },100); 
      }
  }

  $scope.thongketheovung=function(tenfile1,tableId){ 
    if(tenfile1 == undefined){
      alert("Vui lòng nhập tên file");
    }// ex: '#my-table'
    else{
      var exportHref=Excel.tableToExcel(tableId,'WireWorkbenchDataExport');
  $timeout(function(){
    var a = document.createElement('a')
    a.href = exportHref
    a.download = tenfile1+'.xls'
    a.click()
  },100); 
  console.log(tableId);
    }
}
});