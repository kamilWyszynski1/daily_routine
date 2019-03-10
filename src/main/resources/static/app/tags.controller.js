(function () {
    'use strict';

    angular
        .module('tag_app')
        .controller('TagsController', TagController);

    TagController.$inject = ['$http', '$scope'];
    
    function TagController($http, $scope, $mdDialog) {
        var vm = this;

        vm.tags = [];
        vm.init = init;
        vm.create = create;
        vm.remove = remove;
        vm.update = update;
        init();

        function init() {
            var url = "/tags/all";
            var tagsPromise = $http.get(url);

            tagsPromise.then(function (response) {
                vm.tags = response.data;
            });
        }
        
        function create() {
            if (angular.isUndefined($scope.title) || $scope.title.length == 0
                || $scope.description.length == 0) {

                var alert = $mdDialog.alert()
                    .parent(angular.element(document.querySelector('#popupContainer')))
                    .clickOutsideToClose(true)
                    .title('Error')
                    .textContent('You must enter a task name')
                    .ok('Close');

                $mdDialog.show(alert)
                    .finally(function () {
                        alert = undefined;
                    });
            }
            else {
                if ($scope.id){
                    var url = "/tags/update/" + $scope.id;
                    var parametr = JSON.stringify({
                        title: $scope.title,
                        description: $scope.description,
                        color: $scope.color
                    });

                    $http.put(url, parametr, {headers: {'Content-Type': 'application/json'}})
                        .then(function (response) {
                            vm.tags = response.data;
                        });

                    $scope.title = null;
                    $scope.description = null;
                    $scope.color = null;
                    document.getElementById('form_button').innerText = 'CREATE';
                }
                else {
                    var url = "/tags/create";
                    var parametr = JSON.stringify({
                        title: $scope.title,
                        description: $scope.description,
                        color: $scope.color
                    });

                    console.log(parametr);

                    $http.post(url, parametr, {headers: {'Content-Type': 'application/json'}})
                        .then(function (response) {
                            vm.tags = response.data;
                        });

                    $scope.title = null;
                    $scope.description = null;
                    $scope.color = null;
                }
            }
        }

        function remove(id){
            var url = "/tags/delete/" + id;

            $http.post(url).then(function (response) {
               vm.tags = response.data;
            });
        }
        
        function update(id) {
            vm.tags.forEach(function (tag) {
                if (tag.id == id){
                    $scope.title = tag.title;
                    $scope.description = tag.description;
                    $scope.color = tag.color;
                    $scope.id = tag.id;
                }
            });
            document.getElementById('form_button').innerText = 'UPDATE';
        }

    }

})();