/**
 * Created by hein.dehaan on 19-10-2016.
 */

(function(){
    "use strict";

    angular.module("admin")
        .controller('AdminController', adminController);

    adminController.$inject = ['$http'];

    function adminController($http){
        console.log("Hallo Hein");
        var vm = this;
        vm.rawData = [];
        $http.get('http://localhost:8080/dataChanges').then(function(response){
            console.log("received: ", response);
            vm.rawData  = response.data;
            console.log("ALL DATA: ", vm.rawData._embedded.dataChanges);

            vm.data = [];
            vm.data = vm.rawData._embedded.dataChanges;
        });
    }
})();
