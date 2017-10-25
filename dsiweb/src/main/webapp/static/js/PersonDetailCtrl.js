function PersonDetailCtrl($scope, $http, $routeParams, $location) {
	
	
	
	
	if($routeParams.personDetailId != undefined){
		$scope.isReadonly=true;
		console.log("$routeParams.personDetailId  -- "+$routeParams.personDetailId);
		$http.get('inv/inventory/'+$routeParams.personDetailId)
	    .then(
	    		function(response) {
	    			$scope.data = response.data;
	    			$scope.markReadonly(true);
	    			//Cloning to avoid the mutability fo the source date -- moments is function provided by moment.js
	    			// $scope.data.thirdDOB = moment(response.data.dateOfBirth).clone().add(3, 'month').format('YYYY-MM-DD');; 
	    			// console.log("scope.data.thirdDOB= : "+ $scope.data.thirdDOB);
	    		}, 
	    		function(response) {
	    			console.log("Error While getting the data"); 
	    		}
	    );
	}
	 $scope.addPerson = function(){
		  	
		 	$scope.master = {};
	  		var inventory = $scope.data;
	  		console.log('Inventory Data '+$scope.data); 
	        $http.post('http://localhost:8080/dsiweb/inv/inventory', inventory)
	        .then(
	        		function(response) {
	        			
	        			$scope.data = response.data;
	        			$scope.markReadonly(true);
	        			console.log('Added application : '+response.location);
	        			//$location.path('dsiweb/dashboard#!/detail/'+$scope.data.id);
	        		}/*, 
	        		function(response) {
	        			console.log("Error While posting the data"); 
	        		}*/
	        		
	        );  
	
	 }
	 
	 $scope.savePerson = function(){
		  
	  		var inventory = $scope.data;
	  		console.log('Inventory Data put'+$scope.data); 
	  		$scope.markReadonly(true);
	  		console.log('Marking readonly '); 
	        $http.put('http://localhost:8080/dsiweb/inv/inventory', inventory)
	        .then(
	        		
	        		function(response) {
	        			$scope.data = response.data;
	        			console.log('Inventory Data put after response '+response.data); 
	        			//$location.path('dsiweb/dashboard#!/detail/'+$scope.data.id);
	        		}/*, 
	        		function(response) {
	        			console.log("Error While posting the data"); 
	        		}*/
	        		
	        );  
	
	 }
	 
	 $scope.markReadonly = function(toggle){
		  $scope.isReadonly=toggle;
	 }
	
	 $scope.reset = function(){
		 $scope.data = angular.copy($scope.master);
	 }
	 
	 
	 $scope.removePerson = function(){
		 console.log('Inventory Data delete '+$scope.data.id); 
		 var inventory = $scope.data;
		  $http.delete('http://localhost:8080/dsiweb/inv/inventory/'+$scope.data.id)
	        .then(
	        		function(response) {
	        			$scope.data = response.data;
	        		}/*, 
	        		function(response) {
	        			console.log("Error While posting the data"); 
	        		}*/
	        		
	        );  
	 }
	 
}