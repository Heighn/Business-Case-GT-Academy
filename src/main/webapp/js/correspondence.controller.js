/**
 * Created by hein.dehaan on 17-10-2016.
 */

(function(){
    "use strict";

    angular.module("correspondence")
        .controller('CorrespondenceController', correspondenceController);

    correspondenceController.$inject = ['$http'];

    function correspondenceController($http){
        var vm = this;
        vm.rawData = [];
        $http.get('http://localhost:8080/correspondences').then(function(response){
            console.log("received: ", response);
            vm.rawData  = response.data;
            console.log("ALL DATA: ", vm.rawData._embedded);

            vm.data = [];
            var correspondences = vm.rawData._embedded.correspondences;
            for (var i in correspondences){
                var new_item = {date: correspondences[i].date, receivers: correspondences[i].receivers, subject: correspondences[i].subject, message: correspondences[i].message, type: correspondences[i].type};
                console.log("ITEM: ", new_item);
                vm.data.push(new_item);
            }
            console.log("DATA: ", vm.data);
        });
    }
})();

