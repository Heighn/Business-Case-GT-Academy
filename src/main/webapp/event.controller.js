/**
 * Created by hein.dehaan on 18-10-2016.
 */

(function(){
    "use strict";

    angular.module("event")
        .controller('EventController', eventController);

    eventController.$inject = ['$http'];

    function eventController($http){
        var vm = this;
        vm.rawData = [];
        $http.get('http://localhost:8080/events').then(function(response){
            console.log("received: ", response);
            vm.rawData  = response.data;
            console.log("ALL DATA: ", vm.rawData._embedded.events);

            vm.data = [];
            var events = vm.rawData._embedded.events;


            for (var i in events) {
                var new_item = {name: events[i].name, type: events[i].type, description: events[i].description, date:events[i].date};
            }


                vm.data = events;
            console.log("DATA: ", vm.data);
        });
    }
})();
