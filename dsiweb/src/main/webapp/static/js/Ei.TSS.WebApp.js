var app = angular.module("Ei.TSS.WebApp", ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider
     .when("/", {
        templateUrl : "TSSDetail.html"
    }) 
    .when("/search", {
        templateUrl : "PersonSearch.html",
        controller  : "PersonSearchCtrl"
    })
    .when("/detail/:personDetailId", {
        templateUrl : "PersonDetail.html", 
        controller  : "PersonDetailCtrl"
    })
    .when("/tssdetail/:personDetailId", {
        templateUrl : "TSSDetail.html", 
        controller  : "TSSDetailCtrl"
    })
    .otherwise( {
        templateUrl : "/"
    });
});
app.controller("TSSDetailCtrl", PersonDetailCtrl);



