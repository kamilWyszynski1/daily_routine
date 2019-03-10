(function () {
    'use strict';

    angular
        .module('day_app')
        .controller('DaysController', DaysController);

    DaysController.$inject = ['$http', '$scope'];

    function DayController($http, $scope) {
        var vm = this;

        vm.days = [];

        init();


    }
})();