(function(){
    'use strict';

    angular
        .module('portal')
        .controller('PortalController', PortalController);

    PortalController.$inject = ['$http', '$location', '$routeParams'];

    function PortalController($http, $location, $routeParams) {
        var vm = this;

        activate();

        function activate() {
            vm.data = [];
            var url = '/inloggen/';
            $http.get(url)
            .then(

            );
        }

    }

})();
