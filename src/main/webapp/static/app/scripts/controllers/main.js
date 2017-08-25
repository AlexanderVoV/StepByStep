'use strict';

/**
 * @ngdoc function
 * @name testProjectApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the testProjectApp
 */
angular.module('testProjectApp')
    .controller('MainCtrl', ['$scope', '$http', function ($scope, $http) {
        $scope.tasks = [];

        $http.get('http://localhost:8080/task/all')
            .then(successCallback, errorCallback);
        function successCallback(response) {
            $scope.tasks = response.data;
        }
        function errorCallback() {
            throw new Error('Error!!!');
        }
    }]);
