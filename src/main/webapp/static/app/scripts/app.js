'use strict';

/**
 * @ngdoc overview
 * @name testProjectApp
 * @description
 * # testProjectApp
 *
 * Main module of the application.
 */
angular.module('testProjectApp', [
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
                .when('/edit', {
                    templateUrl: '/views/edit.html',
                    controller: 'EditCtrl',
                    controllerAs: 'edit'
                })
                .otherwise({
                    redirectTo: '/'
                });
        }]);
