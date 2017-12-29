var appPenulis = angular.module('AppPenulis', []);

appPenulis.controller('CobaController', 
	function($scope) {
		$scope.daftarNama = [];

		$scope.tambah = function() {
			$scope.daftarNama.push($scope.nama);
		}
	});

appPenulis.controller('ApiController', 
	    function($scope, $http, $window) {
	    	$scope.daftarPenulis = [];

	    	$scope.updateData = function() {
	    		$http.get('/daftar-penulis')
	    			.then(sukses, gagal);

	    		function sukses(response) {
	    			console.log(response);
	    			$scope.daftarPenulis = response.data;
	    		};	

	    		function gagal(response) {
	    			console.log(response);
	    		};
	    	};

	    	$scope.ubah = function(pns) {
	    		//console.log(mhs);
	    		$window.location.href = "/edit?id=" + pns.id;
	    	};

	    	$scope.hapus = function(pns) {

	    		swal({
      title: 'Apakah Anda Yakin?',
      text: "Anda akan menghapus data yang dipilih!",
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, cancel!',
      confirmButtonClass: 'btn btn-success',
      cancelButtonClass: 'btn btn-danger',
      buttonsStyling: false
    }).then(function () {
        swal("Terhapus!", "Data berhasil dihapus!", "success");
        $http.delete('/hapus/' + pns.id).then(sukses, gagal);

         }, function (dismiss) {
      // dismiss can be 'cancel', 'overlay',
      // 'close', and 'timer'
      if (dismiss === 'cancel') {
        swal("Cancelled", "Data gagal dihapus!", "error")
      }
       });

	    		// $http.delete('/hapus/' + mhs.id).then(sukses, gagal);

	    		function sukses(response) {
	    			$scope.updateData();
	    		};

	    		function gagal(response) {};
	    	};

	    	$scope.keluar = function(){
	    		$http.get('/logout').then(sukses, gagal);

	    		function sukses(response){
	    			$window.location.href = "/login";
	    		}
	    		function gagal(response){}
	    	};

	    	$scope.updateData();
		}
	);
