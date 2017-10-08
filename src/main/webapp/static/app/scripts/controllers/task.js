'use strict';

angular.module('StepByStep')
    .controller('TaskCtrl', ['$scope', '$http', '$mdDialog', function ($scope, $http, $mdDialog) {
        var server = 'http://localhost:8080';
        $scope.newTask = {};
        $scope.tasks = [];

        function successCallback(response) {
            $scope.tasks = response.data;
        }

        function errorCallback() {
            throw new Error('Error!!!');
        }

        ($scope.loadTodoList = function () {
            $http.get(server + '/task/all')
                .then(successCallback, errorCallback);
        })();

        $scope.create = function () {
            $http.post(server + '/task/new', $scope.newTask)
                .then(function (response) {
                    $scope.tasks.push(response.data);
                    $scope.newTask = {};
                }, errorCallback)
        };

        $scope.update = function (editTask) {
            $http.put(server + '/task/update/', editTask)
                .then(function () {
                    $scope.loadTodoList();
                }, errorCallback);
        };

        $scope.delete = function () {
            $http.delete(server + '/task/delete/' + this.task.id)
                .then(function () {
                    $scope.loadTodoList();
                }, errorCallback);
        };

        $scope.showPopup = function (ev) {
            var editTask = this.task;
            var confirm = $mdDialog.prompt()
                .title('Task Edit')
                .placeholder('Content')
                .initialValue(this.task.content)
                .targetEvent(ev)
                .ok('Submit')
                .cancel('Cancel');

            $mdDialog.show(confirm).then(function (result) {
                if (editTask.content != result) {
                    editTask.content = result;
                    $scope.update(editTask);
                }
            }, function () {

            });
        };
    }]);