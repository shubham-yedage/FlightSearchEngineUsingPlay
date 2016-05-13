angular.module('myApp').controller('searchFlights', function($scope,$http) {
$scope.flights=[];
$scope.flight={};
//$scope.mydate="flight.date | date : 'dd/MM/yyyy'";
    $scope.getflights = function(flight){
    $http({
        method: 'POST',
        url: 'http://localhost:9000/homepage',
        headers: {'Content-Type': 'application/x-www-form-urlencoded'},
         transformRequest: function(obj) {
                var str = [];
                for(var p in obj)
                str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                return str.join("&");
            },
        data: {
        deploc: flight.dep,
        arrloc: flight.arr,
        date: flight.mydate,
        choice: flight.choice
        },
    }).success(
                function(result){
                    alert("done")
                });
    };
});