(function () {
    'use strict';

    angular.module('portal')
        .config(config);

    config.$inject = ['$routeProvider'];

    function config($routeProvider) {

        $routeProvider
            .when('/inloggen', {
                templateUrl: '/html/inloggen.html',
                controller: 'PortalController',
            })
            .otherwise('/');
    }
})();
