(function(){
  "use strict";

  angular.module("portal")
    .controller('PortalController', portalController);

  portalController.$inject = ['$http'];

  function portalController($http){
    var vm = this;
    vm.rawData = [];
    $http.get('http://localhost:8080/students').then(function(response){
      console.log("received: ", response);
      vm.rawData  = response.data;
      console.log("ALL DATA: ", vm.rawData._embedded.students);

      vm.data = [];
      var students = vm.rawData._embedded.students
      for (var i in students){
        var new_item = {firstName: students[i].firstName, lastName: students[i].lastName, emailAddress: students[i].emailAddress, thema: "Traineeship", events: "Evenement X", status: students[i].isInactief};
        console.log("ITEM: ", new_item);
        vm.data.push(new_item);
      }
      console.log("DATA: ", vm.data);
    });

    vm.master=true;

    vm.newMailMessage = function() {
      location.href="/recruiter/nieuw-bericht"
    };

<<<<<<< HEAD
    vm.updateSelection = function(){
      console.log("updating selection!");
      sessionStorage.selectedEmails = vm.data.filter(function(i){
        return i.selected;
      }).map(function(i){return i.emailAddress});
=======
    vm.updateSessionStorage = function() {
      location.href="/recruiter/nieuw-bericht"
    };

/*    vm.add = function(new_title) {
      var new_item = {
        title: new_title,
        done: false
      };
      vm.data.push(new_item);
    };

    vm.updateItemsDone = function() {
      vm.itemsDone = vm.data.filter(function(item){
        return item.done;
      }).length;
>>>>>>> 1189734c38f53a6bf775fbe14b698a0b565d5f14
    };
  }
})();
