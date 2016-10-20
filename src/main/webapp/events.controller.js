(function(){
  "use strict";

  angular.module("events")
    .controller('EventController', eventController);

  function eventController($http){
    var vm = this;
    vm.rawData = [];
    $http.get('http://localhost:8080/events').then(function(response){
      console.log("received: ", response);
      vm.rawData  = response.data;
      console.log("ALL DATA: ", vm.rawData._embedded.events);

      vm.data = [];
      var events = vm.rawData._embedded.events
      for (var i in events){
        var new_item = {name: events[i].name, lastName: events[i].lastName};
        console.log("ITEM: ", new_item);
        vm.data.push(new_item);
      }
      console.log("DATA: ", vm.data);



  });
}
})();
