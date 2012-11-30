/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var AppConfig = {
    baseUrl: '/ChooseYourAdventure' //no trailing slash
};
var App = {
    initHome: function() {
        
    }
};

var User = {
    validateLogin: function() {
        $('#login-form').validate();
    }
};

var Attraction = {
    initHome: function() {        
        $('#city').change(function() {
            var cityId = this.value;
            
            if(cityId != '') {
                $.ajax({
                    dataType: 'html',
                    method: 'GET',
                    url: AppConfig.baseUrl+'/attraction/attraction-selectbox.htm',
                    data: {
                        'city': cityId
                    },                    
                    success: function(response) {
                        $('#attraction-wrapper').html(response);
                    }
                });

                $.ajax({
                    dataType: 'html',
                    method: 'GET',
                    url: AppConfig.baseUrl+'/attraction/package-selectbox.htm',
                    data: {
                        'city': cityId
                    },                    
                    success: function(response) {
                        $('#package-wrapper').html(response);
                    }
                });
            }
        });
        
        $('#fitler-attraction-form').submit(function() {
            var flag = true;
            
            var attractionId = $('#attraction').val();
            var packageId = $('#package').val();
            
            if(attractionId != '' && packageId != '') {
                alert('Please selet either an attraction or a package (not both).');
                flag = false;
            } else if(attractionId == '' && packageId == '') {
                alert('Select an attractino or a package.');
                flag = false;
            }
            
            return flag;
        });
    }
};