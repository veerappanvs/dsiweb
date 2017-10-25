

function PersonSearchCtrl($scope, $http) {
	 
	  $scope.gridOptions = {
			  
	    columnDefs: [
	    	{ name: 'id', displayName: 'Id ' , width: '5%', enableCellEdit: false },
	    	{ name: 'appName', displayName: 'App Name ' ,width: '33%', enableCellEdit: false },
	        { name: 'appAcronym', displayName: 'App Acronym', width: '10%', enableCellEdit: false }, 
	        { name: 'bureau', displayName: 'Bureau/Office', width: '12%', enableCellEdit: false},
	        { name: 'businessApplicationOwner', displayName: 'Business AppOwner',  width: '20%',enableCellEdit: false}, 
	        { name: 'iTProgramManager', displayName: 'IT Program Manager',  width: '20%',enableCellEdit: false}, 
	       // {name: 'button', displayName: 'View', enableCellEdit: false, cellTemplate: '<button ng-click="getExternalScopes().onClick(row.entity.id)">view1</button>'}
	       // {name: 'button', displayName: 'View', enableCellEdit: false, cellTemplate: '<div class="ui-grid-cell-contents"> <button class="btn" type="button" ng-click="grid.appScope.Main.openDetail(row.entity.id)">View Detail</button></div>'}
	        {name: 'id', displayName: 'ID', width: '5%', enableCellEdit: false, cellTemplate: '<div class="ui-grid-cell-contents"> <a ng-href="#!detail/{{COL_FIELD}}">{{COL_FIELD}}</a></div>'}
	        
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
	  
	  
/*	  this.openDetail = function (id) {
		  console.log("openDetail "+id);
		 // $scope.showDetail(id);
		  app.value("detailId", id);
		    //var param = address.street + ",+" + address.city + ",+" + address.state;
		    window.open('detail.html/'+id);
		  };
	  
*/
	  
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

	}
