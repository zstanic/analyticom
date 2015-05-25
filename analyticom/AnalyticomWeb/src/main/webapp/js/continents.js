/**
var Continents = function () {

	var cont = function()
	{
		var phonecatApp = angular.module('phonecatApp', []);   
		phonecatApp.controller('PhoneListCtrl', function ($scope, $http) {
			 $http.get('/getContinents.json').success(function(data) {
				$scope.phones = data;
			 }); 
			$scope.orderProp = 'continetId';
		});
	};
	
		return {
	
		    init: function() {
		    	cont();              
		    }
		};
	
	}();
	
	**/

var Continents = function () {
	
var tableJson = angular.module('tableJson', []);
tableJson.controller('tableJsonCtrl', function($scope){
	$scope.phones = [
	{ "name": "Nexus S",
	"snippet": "Fast just got faster with Nexus S.",
	"age": 0
	},
	{ "name": "Apple iPhone 4S (White) (8 GB)",
	"snippet": "3.5 Inch Widescreen Diagonal",
	"age": 1
	},
	{ "name": "Samsung Galaxy Core 2 (White)",
	"snippet": "powerful 1.2 GHz Quad Core processor and Android 4.4 Kitkat Operating System",
	"age": 2
	},
	{
	"name": "Micromax Canvas HD Plus A190, white gold",
	"snippet": "4.76 GB for mass storage",
	"age": 2
	}
	];
 
});

}();