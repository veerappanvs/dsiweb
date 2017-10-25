function TSSDetailCtrl($scope, $http, $routeParams) {
	console.log("$routeParams.personDetailId   "+$routeParams.personDetailId)
	$http.get('person/getone?id='+$routeParams.personDetailId)
    .then(function(response) {
      $scope.data = response.data;
      //Cloning to avoid the mutability fo the source date -- moments is function provided by moment.js
      $scope.data.thirdDOB = moment(response.data.dateOfBirth).clone().add(3, 'month').format('YYYY-MM-DD');; 
      console.log("scope.data.thirdDOB= : "+ $scope.data.thirdDOB);
    });
}