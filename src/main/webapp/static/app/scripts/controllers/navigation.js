'use strict';

angular.module('testProjectApp')
    .controller('NavController', ['$scope', function ($scope) {
        $scope.tab = 'home';
        $scope.navBarItemList = [
            {view:'home', label: 'Home'},
            {view:'task', label: 'Task'}
        ];

        $scope.selectTab = function (setTab) {
            $scope.tab = setTab;
        };

        $scope.isSelected = function (checkTab) {
            return $scope.tab == checkTab;
        };
    }])
    .directive('navbarItems', ['$scope', function () {
        return {
            restrict: 'E',
            templateUrl: '../../views/navbar-items.html'
        };
}]);