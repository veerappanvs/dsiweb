var app = angular.module("EiWebApp", ['ngRoute',   'ui.grid',  'ui.grid.selection', 'ui.grid.exporter', 'ui.grid.resizeColumns']);
app.config(function($routeProvider) {
    $routeProvider
     .when("/", {
        templateUrl : "DbContent.html"
    }) 
    .when("/DbContent", {
        templateUrl : "DbContent.html"
    })
    .when("/search", {
        templateUrl : "PersonSearch.html",
        controller  : "PersonSearchCtrl"
    })
    .when("/detail", {
        templateUrl : "PersonDetail.html", 
        controller  : "PersonDetailCtrl"
    })
    .when("/detail/:personDetailId", {
        templateUrl : "PersonDetail.html", 
        controller  : "PersonDetailCtrl"
    })
    .otherwise( {
        templateUrl : "/"
    });
});
app.controller("PersonDetailCtrl", PersonDetailCtrl);
app.controller("PersonSearchCtrl", PersonSearchCtrl);



