// Angular module
angular.module('jobsApp', ['jobsApp.controllers']);

// Controllers
angular.module("jobsApp.controllers", [])
.controller('JobsCtrl', ['$scope', '$http', function($scope, $http) {
		// Jobs Gist URL = https://api.github.com/gists/4380455
		$http.jsonp("https://api.github.com/gists/4380455?callback=JSON_CALLBACK", {
		}).success(function(data, status, headers, config) {
			//$scope.jobs = [{"id":1,"title":"Job 1","description":"This is Job number one","creationDate":1356537739208}];
			$scope.jobs = JSON.parse(data.data.files['jobs.json'].content);
		}).error(function(data, status, headers, config) {
			$scope.error = 'Jobs not available for the moment ...';
		});
	}
]);
