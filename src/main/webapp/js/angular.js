var app = angular.module('portal', ['ngRoute']);

app.config(function($routeProvider) {
  $routeProvider
    .when('/', {
      templateUrl : 'html/inloggen.html',
      controller : 'mainController'
    })
    ;
  });

app.controller('mainController', function($scope) {
  $scope.pageTitle = 'Inloggen';
  $scope.message= 'test';
});
