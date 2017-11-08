angular.module('EiWebApp')
.factory('AuthInterceptor', [function() {  
    return {
		// Sent the token (if present) with each request
        'request': function(config) {
			config.headers = config.headers || {};
			var encodedString = btoa("bill:123456");
			config.headers.Authorization = 'Basic '+encodedString;
			console.log('Returing config'+config);
           return config;
        }
    };
}]);

