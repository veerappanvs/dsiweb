function PersonSearchCtrl($rootScope, $scope, $http, $location) {
	 

	
	$scope.isSuccess=false;
	$scope.isAdmin=$rootScope.isAdmin;
	$scope.master = {};
	console.log(' PersonSearchCtrl- $scope.isAdmin = '+$scope.isAdmin);
	 
	 
	 $scope.markReadonlyDetail = function(toggle){
		  $scope.isReadonly=toggle;
	 }
	 
	 $scope.editAppFn = function(toggle){
		 console.log("Editapp");
		 $scope.markReadonlyDetail(false);
		 $scope.isEditEnabled=true;
	 }
	
	 $scope.savePersonDetail = function(){
		  
	  		var inventory = $scope.detail;
	  		console.log('Inventory Data put'+$scope.detail); 
	  		$scope.markReadonlyDetail(true);
	  		console.log('Marking readonly '+$scope.isReadonly); 
	        $http.put('inv/inventory', inventory)
	        .then(
	        		
	        		function(response) {
	        			$scope.detail = response.data;
	        			console.log('Inventory Data put after response '+response.data); 
		    			$scope.isSuccess=true;
	        			console.log("isSuccess "+$scope.isSuccess);
	        			
	        		}, 
	        		function(response) {
	        			console.log("Error While posting the data"+response); 
	        			$location.path('/detail/'+$scope.data.id);
	        		}
	        		
	        );  
	
	 }
	 
	
	 $scope.reset = function(){
		// $scope.data = angular.copy($scope.master);
		// $scope.detail = angular.copy($scope.master);
	 }
	 
	 
	 $scope.removePersonDetail = function($location){
		 console.log('Inventory Data delete '+$scope.detail.id); 
			$scope.markReadonlyDetail(false);
		  $http.delete('inv/inventory/'+$scope.detail.id)
	        .then(
	        		
	        		function(response) {
	        			$scope.reset()
	        			$scope.detail = response.data;
	        			//$scope.data = response.data;
	        			 console.log('Inventory Data deleted successfully '); 
	        			 //window.location.href = '#!detail';
	        			 //$location.url = '#!detail';
	        		}, 
	        		function(response) {
	        			console.log("Error While posting the data --"+response); 
	        		}
	        		
	        );  
	 }
	
	  $scope.getDetail = function (id) {
		  console.log("openDetail "+id);
		 // $scope.showDetail(id);
		  app.value("detailId", id);
		   // window.open('detail.html/'+id);
		  
		  $http.get('inv/inventory/'+id)
		    .then(
		    		function(response) {
		    			$scope.detail = response.data;
		    			$scope.markReadonlyDetail(true);
		    			console.log("getting the data"+$scope.detail); 
		    		}, 
		    		function(response) {
		    			console.log("Error While getting the data"); 
		    		}
		    );
		  };
	
	  $scope.gridOptions = {
			  
	    columnDefs: [
	    	//{ name: 'id',  ,, enableCellEdit: false },
	        //{name: 'id', displayName: 'Id', enableCellEdit: false, cellTemplate: '<div class="ui-grid-cell-contents"> <button class="btn" type="button"  data-toggle="modal" data-target="#myModal"  ng-click="grid.appScope.getDetail(row.entity.id)">{{COL_FIELD}}	</button></div>'},
	    	{name: 'id', displayName: 'Id', enableCellEdit: false, cellTemplate: '<div class="ui-grid-cell-contents"> <button class="btn-link" type="button"  data-toggle="modal" data-target="#myModal"  ng-click="grid.appScope.getDetail(row.entity.id)">{{COL_FIELD}}</button></div>'},
	        //{name: 'id', displayName: 'ID', width: '5%', enableCellEdit: false, cellTemplate: '<div class="ui-grid-cell-contents"> <a ng-href="#!detail/{{COL_FIELD}}">{{COL_FIELD}}</a></div>'},

	    	{ name: 'appName', displayName: 'App Name ' ,width: '33%', enableCellEdit: false },
	        { name: 'appAcronym', displayName: 'App Acronym', width: '10%', enableCellEdit: false }, 
	        { name: 'bureau', displayName: 'Bureau/Office', width: '12%', enableCellEdit: false},
	        { name: 'businessApplicationOwner', displayName: 'Business AppOwner',  width: '20%',enableCellEdit: false}, 
	        { name: 'iTProgramManager', displayName: 'IT Program Manager',  width: '20%',enableCellEdit: false}, 
	       // {name: 'button', displayName: 'View', enableCellEdit: false, cellTemplate: '<button ng-click="getExternalScopes().onClick(row.entity.id)">view1</button>'}
	        //{name: 'button', displayName: 'View', enableCellEdit: false, cellTemplate: '<div class="ui-grid-cell-contents"> <button class="btn" type="button" ng-click="grid.appScope.Main.openDetail(row.entity.id)">View Detail</button></div>'}, 

	        //{name: 'id', displayName: 'ID', width: '5%', enableCellEdit: false, cellTemplate: '<div class="ui-grid-cell-contents"> <a ng-href="#!detail/{{COL_FIELD}}">{{COL_FIELD}}</a></div>'},
	        //{name:'id', displayName: 'Id ',  width: '5%', cellTemplate: '<a href ng-click="detailPerson()" >{{COL_FIELD}}</a>'}
	  	], 
		rowHeight: 38,
		enableColumnResize: true,
	    enableFiltering: true,     
	    enableRowSelection: true,
	    enableRowHeaderSelection: false,
	    selectionRowHeaderWidth: 35,  
	    noUnselect: true,
		exporterMenuPdf: false,
		enableGridMenu: true,
	    enableSelectAll: true,
	    exporterCsvFilename: 'myFile.csv',    
	    exporterCsvLinkElement: angular.element(document.querySelectorAll(".custom-csv-link-location")),
	    onRegisterApi: function(gridApi){
	    $scope.gridApi = gridApi;
	    }
	  };
	  
	 
	  

	  
	  $scope.getDataForURI = function(uri){
		 // console.log("Getting the detail page1 "+$scope.searchText);
		  $http.get(uri)
		  	.then(function (response) {
		      $scope.gridOptions.data = response.data;
		  		//$scope.gridOptions.data =GetDataForURIFactorySvc;
		  		$scope.data = response.data;
		      //console.log("Search Text :  "+$scope.searchText);
		      if(response.data.length >0)
		    	  	$scope.checked=true;
		    });
	  };
	  
	  $scope.showSearchResults = function(searchText){
		  //console.log("Getting the detail page "+searchText);
		  var str = $scope.searchText;
		 // console.log("Getting the detail page - length "+searchText.length);
		  if(searchText.length >2 )
			 // $scope.getDataForURI('http://localhost:8080/eiweb/person/get?name='+$scope.searchText);
			  $scope.getDataForURI('inv/inventory/get?name='+$scope.searchText);
		  else 
			  $scope.checked=false;
	  };
	  
/*	  $scope.detailPerson = function (){
		  console.log(" detailId : "+detailId);
		    $element.modal('show');

	  };*/

	}
