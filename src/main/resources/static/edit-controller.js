appPenulis.controller('EditController', 
	    function($scope, $http, $window) {

	$scope.pns = {};

	$scope.simpan = function() {
		//console.log($scope.mhs);
		$http.post('/simpan', $scope.pns).then(sukses, gagal);

		function sukses(response) {
			$window.location.href = "/";
		};

		function gagal(response) {
			console.log(response);
		};
	};

	$scope.batal = function() {
		$window.location.href = "/";
	};

	$scope.muat = function() {
		var id = $window.location.search.split("=")[1];
		$scope.pns.id = id;

		$http.get('/ambil-data-pns/' + id).then(sukses, gagal);

		function sukses(response) {
			//console.log(response.data);
			$scope.pns = response.data;
		};

		function gagal(response) {};

	};

	$scope.muat();

});