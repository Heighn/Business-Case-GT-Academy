/**
 * Created by hein.dehaan on 18-10-2016.
 */

(function(){
    "use strict";

    angular.module("profiel")
        .controller('ProfielController', profielController);

    profielController.$inject = ['$http'];

    function profielController($http){
        var vm = this;
        vm.rawData = [];
        $http.get('http://localhost:8080/themes').then(function(response){
            console.log("received: ", response);
            vm.rawData  = response.data;
            console.log("ALL DATA: ", vm.rawData._embedded.themes);

            vm.data = [];
            var themes = vm.rawData._embedded.themes;
            for (var i in themes){
                var new_item = {description: themes[i].description, id: themes[i].id};
                console.log("ITEM: ", new_item);
                vm.data.push(new_item);
            }
            console.log("DATA: ", vm.data);
        });
    }
})();
