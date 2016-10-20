(function(){
  "use strict";

  angular.module("portal")
    .controller('PortalController', portalController);
    
  function portalController($http){
    var vm = this;
    vm.rawData = [];
    $http.get('http://localhost:8080/students').then(function(response){
      console.log("received: ", response);
      vm.rawData  = response.data;
      console.log("ALL DATA: ", vm.rawData._embedded.students);

      vm.data = [];
      var students = vm.rawData._embedded.students

      var today = new Date();
      var day = today.getDate();
      var month = today.getMonth();


      for (var i in students){

        if(students[i].gebDatum != null) {
          var verjaardagMaand = parseInt(students[i].gebDatum.substr(5, 2));
          var verjaardagDag = parseInt(students[i].gebDatum.substr(8, 2));
          if (verjaardagMaand < parseInt(month)) verjaardagMaand += 12;
          if (verjaardagDag < parseInt(day)) verjaardagDag += 31;
        }else{
          verjaardagMaand = 100;
          verjaardagDag = 100;
        }

        if(students[i].afstudeerDatum != null) {
          var afstudeerMaand = parseInt(students[i].afstudeerDatum.substr(5, 2));
          var afstudeerDag = parseInt(students[i].afstudeerDatum.substr(8, 2));
          if (afstudeerMaand < parseInt(month) + 3) afstudeerMaand += 12;
          if (afstudeerDag < parseInt(day)) afstudeerDag += 31;
        }else{
          afstudeerMaand = 100;
          afstudeerDag = 100;
        }
        console.log(students[i].firstName, afstudeerMaand);


        var new_item = {firstName: students[i].firstName, lastName: students[i].lastName, emailAddress: students[i].emailAddress, verjaardag: students[i].gebDatum, verjaardagMaand: verjaardagMaand, verjaardagDag: verjaardagDag, afstudeerDatum: students[i].afstudeerDatum, afstudeerDag: afstudeerDag, afstudeerMaand: afstudeerMaand, thema: "Traineeship", events: "Evenement X", status: students[i].isInactief};
        console.log("ITEM: ", new_item);
        vm.data.push(new_item);
      }
      console.log("DATA: ", vm.data)




    });

    $http.get('http://localhost:8080/dataChanges').then(function(response){
      console.log("received: ", response);
      vm.rawData  = response.data;
      console.log("ALL DATA: ", vm.rawData._embedded.dataChanges);

      vm.dataChanges = [];
      vm.dataChanges = vm.rawData._embedded.dataChanges;
    });


    vm.master=true;

    vm.newMailMessage = function() {
      location.href="/recruiter/nieuw-bericht"
    };

    vm.updateSelection = function(){
      console.log("updating selection!");
      sessionStorage.selectedEmails = vm.data.filter(function(i){
        return i.selected;
      }).map(function(i){return i.emailAddress});
    };
  }
})();
