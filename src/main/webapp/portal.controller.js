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
    // vm.data = [
    //   { firstName: "Pieter", lastName: "Leijenaar", emailAddress: "pieter.leijenaar@getthere.nl", thema: "Traineeship", events: "Evenement X", status: "Actief"},
    //   { firstName: "Pieter", lastName: "Leijenaar", emailAddress: "pieter.leijenaar@getthere.nl", thema: "Traineeship", events: "Evenement X", status: "Verwijderd"},
    //   { firstName: "Hein", lastName: "de Haan", emailAddress: "hein.dehaan@getthere.nl", thema: "Traineeship", events: "Evenement X", status: "Actief"},
    //   { firstName: "Jasper", lastName: "de Jong", emailAddress: "jasper.dejong@getthere.nl", thema: "Traineeship", events: "Evenement Y", status: "Actief"},
    //   { firstName: "Ruud", lastName: "Zonneberg", emailAddress: "ruud.zonneberg@getthere.nl", thema: "Traineeship", events: "Evenement Y", status: "Actief"}
    // ];



    vm.master=true;

    vm.newMailMessage = function() {
      location.href="/recruiter/nieuw-bericht"
    };
  }
})();
