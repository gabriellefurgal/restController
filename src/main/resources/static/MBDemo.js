/**
 * Created by Siekacz on 20.03.2017.
 */
// angular.module('mb', []).controller('LegoSetTypes', function ($scope, $http) {
//     $http.get('http://localhost:8080/legoSetTypes').then(function (response) {
//         $scope.legoSetTypes = response.data;
//     })
// });
angular.module('mb', []).controller('LegoSetsForType', function ($scope, $http) {
    $http.get('http://localhost:8080/MB/products/legoTechnic/sets').then(function (response) {
        $scope.legoSetsForType = response.data;
        $scope.changeLink = function() {
            $scope.link = undefined;
        }
    })
});