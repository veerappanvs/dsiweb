var app = angular.module("EiWebApp", ['ngRoute', 'ui.bootstrap',    'ui.grid',  'ui.grid.selection', 'ui.grid.exporter', 'ui.grid.resizeColumns']);

/*app.config(['$httpProvider', function($httpProvider) {
	  $httpProvider.interceptors.push('AuthInterceptor');
	}]);*/

app.config(
		
		function($routeProvider) {
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
		        templateUrl : "PersonAddEdit.html", 
		        controller  : "PersonDetailCtrl"
		    })
		    .when("/detail/:personDetailId", {
		        templateUrl : "PersonAddEdit.html", 
		        controller  : "PersonDetailCtrl"
		    })
		    .otherwise( {
		        templateUrl : "/"
		    });
		    
		   // $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

		}
);

app.controller("PersonDetailCtrl", PersonDetailCtrl);
app.controller("PersonSearchCtrl", PersonSearchCtrl);
//app.controller("EIWebUtilCtrl", EIWebUtilCtrl);

app.controller('userCtrl', function($rootScope, $scope, $http){

	console.log("Getting User detail ");
	$http.get("user").then(
			
			function(response) {
				$rootScope.userName = response.data.name;
				$scope.user = response.data.name;
				console.log('$rootScope.userName =='+$scope.userName);
				$rootScope.userRole = response.data.authorities[0].authority;
				$scope.role = response.data.authorities[0].authority;
				console.log('$rootScope.userRole == '+$scope.userRole);
				$rootScope.isAdmin=angular.equals($rootScope.userRole, 'ROLE_ADMIN');
				console.log($rootScope.userName+" rootScope.isAdmin is "+$rootScope.isAdmin);
	});
	
	$scope.logout = function(){
		console.log('$Logout  =='+$scope.userName);
		//delete $cookies["JSESSIONID"];
		$scope.user=undefined;
		$scope.role=undefined;
		
		$http.get('logout')
        .then(
        		function(response) {
        			
        			console.log('Logout Success : ');
        			//$location.path('dsiweb/dashboard#!/detail/'+$scope.data.id);
        		}, 
        		function(response) {
        			console.log("Error While logging out the data"); 
        		}
        		
        );  		
				
				
				
	}
	
});


