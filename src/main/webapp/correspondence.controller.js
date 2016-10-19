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
                var new_item = {dateString: correspondences[i].dateString, receivers: correspondences[i].receivers, subject: correspondences[i].subject, message: correspondences[i].message, type: correspondences[i].type};
                console.log("ITEM: ", new_item);
                vm.data.push(new_item);
            }
            console.log("DATA: ", vm.data);
        });

        $http.get('http://localhost:8080/students').then(function(response){
            vm.rawData = response.data;
            console.log("ALL DATA: ", vm.rawData._embedded.students);

            vm.studentData = [];
            var students = vm.rawData._embedded.students
            for (var i in students){
                var new_item = {firstName: students[i].firstName, lastName: students[i].lastName, emailAddress: students[i].emailAddress, thema: "Traineeship", events: "Evenement X", status: students[i].isInactief};
                console.log("ITEM: ", new_item);
                vm.studentData.push(new_item);
            }
            console.log("Student DATA: ", vm.studentData);
        });
    }
})();

