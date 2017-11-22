function PersonDetailCtrl($rootScope, $scope, $http, $routeParams, $location, $window) {
	
	
	$scope.isAdmin=$rootScope.isAdmin;
	$scope.isEditEnabled=false;

	console.log(' PersonDetailCtrl- $scope.isAdmin = '+$scope.isAdmin);
	
	//$scope.isReadonly=true;
	 $scope.markReadonly = function(toggle){
		  $scope.isReadonly=toggle;
	 }
	 
	 $scope.editAppFn = function(toggle){
		 $scope.markReadonly(false);
		 $scope.isEditEnabled=true;
	 }
	
/*	 if($scope.data == null && $scope.isReadonly == null ){
	//	 $scope.markReadonly(false);
		 $scope.enableCancelButton = false;
	 }*/
/*	 console.log('isReadonly && (data.id == null) condition '+$scope.isReadonly && ($scope.data == null));
	 console.log('$scope.isReadonly'+$scope.isReadonly );
	 console.log('$scope.data is null '+($scope.data == null) );
	 console.log('$scope.enableCancelButton '+($scope.enableCancelButton) );*/

	
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
	        $http.post('inv/inventory', inventory)
	        .then(
	        		function(response) {
	        			$scope.data = response.data;
	        			$scope.markReadonly(true);
	        			console.log('Added application : '+response.location);
	        			$scope.data.hasInserted=true;
	        			
	        		}, 
	        		function(response) {
	        			console.log("Error While posting the data ---> "+response.status );
	        			if(response.status==409){
        					$scope.data.isDuplicateApp=true;
        				}
	        			$location.path('detail');
	        		}
	        		
	        );  
	
	 }
	 
	 $scope.savePerson = function(){
		  
	  		var inventory = $scope.data;
	  		console.log('Inventory Data put   '+$scope.data); 
	  		$scope.markReadonly(true);
	  		$scope.data.hasInserted=false;
	  		console.log('Marking readonly '+$scope.isReadonly); 
	        $http.put('inv/inventory', inventory)
	        .then(
	        		
	        		function(response) {
	        			$scope.detail = response.data;
	        			console.log('Inventory Data put after response '+response.data); 
		    			$scope.isSuccess=true;
	        			console.log("isSuccess "+$scope.isSuccess);
	        			//$location.path('dsiweb/dashboard#!/detail/'+$scope.data.id);
		        		}, 
		        		function(response) {
		        			console.log("Error While modifying the data "+response); 
		        		}
	        		
	        );  
	
	 }

	 
	 
	 $scope.reset = function(){
		 $scope.data = angular.copy($scope.master);
	 }
	 	 
	 
	 $scope.removePerson = function($location, $window){
		 console.log('Inventory Data delete '+$scope.data.id); 
		 $scope.markReadonly(false);
		 //var inventory = $scope.data;
		  $http.delete('inv/inventory/'+$scope.data.id)
	        .then(
	        		
	        		function(response) {
	        			 //$scope.reset();
	        			$scope.data = response.data;
	        			 console.log('Inventory Data deleted successfully '); 
		        		//$location.path('#!detail');
		        		//console.log('location.path = '+$location.absUrl());
	        			 window.location.href = '#!detail';
	        			 //$location.url = '#!detail';

	        		}, 
	        		function(response) {
	        			console.log("Error While deleting the data"+response); 
	        		}
	        		
	        );  
	 }
	 
}