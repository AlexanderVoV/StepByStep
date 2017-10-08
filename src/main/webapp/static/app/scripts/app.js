'use strict';

/**
 * @ngdoc overview
 * @name StepByStep
 * @description
 * # StepByStep
 *
 * Main module of the application.
 */
angular.module('StepByStep', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngMaterial'
])

    .config(['$locationProvider', '$routeProvider',
        function ($locationProvider, $routeProvider) {

            $locationProvider.html5Mode({
                enabled: true
            });

            $routeProvider
                .when('/', {
                    templateUrl: '/views/main.html',
                    controller: 'MainCtrl',
                    controllerAs: 'main'
                })
                .when('/task', {
                    templateUrl: '/views/task.html',
                    controller: 'TaskCtrl'
                })
                .otherwise({
                    redirectTo: '/'
                });
        }]);
