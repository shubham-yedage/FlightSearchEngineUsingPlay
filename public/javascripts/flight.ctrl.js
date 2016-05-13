
angular.module('myApp').controller('searchFlights', function($scope,$http) {
$scope.flights=[];
$scope.flight={};
    $scope.getflights = function(person){
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
        data: {name: flight}
    }).success(
                function(result){
                    $scope.flights.push(flight);
                    $scope.flight={};
                });
    };


});