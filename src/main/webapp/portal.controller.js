(function(){
  "use strict";

  angular.module("portal")
    .controller('PortalController', portalController);

  function portalController(){
    var vm = this;
    vm.data = [
      { firstName: "Pieter", lastName: "Leijenaar", emailAddress: "pieter.leijenaar@getthere.nl", thema: "Traineeship", events: "Evenement X", status: "Actief"},
      { firstName: "Pieter", lastName: "Leijenaar", emailAddress: "pieter.leijenaar@getthere.nl", thema: "Traineeship", events: "Evenement X", status: "Verwijderd"},
      { firstName: "Hein", lastName: "de Haan", emailAddress: "hein.dehaan@getthere.nl", thema: "Traineeship", events: "Evenement X", status: "Actief"},
      { firstName: "Jasper", lastName: "de Jong", emailAddress: "jasper.dejong@getthere.nl", thema: "Traineeship", events: "Evenement Y", status: "Actief"},
      { firstName: "Ruud", lastName: "Zonneberg", emailAddress: "ruud.zonneberg@getthere.nl", thema: "Traineeship", events: "Evenement Y", status: "Actief"}
    ];
    vm.master=true;

    vm.newMailMessage = function() {
      alert("Functionaliteit nog niet geïmplementeerd");
      
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
    };

    vm.delete = function(title) {
      var theIndex = vm.data.indexOf(title);
      vm.data.splice(theIndex, 1);
    };

    vm.updateItemsDone(); */

  }
})();
