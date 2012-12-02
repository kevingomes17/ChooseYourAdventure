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
    },
    
    //Initializes the attraction view details page.
    initView: function() {
        $('#discussion-topics-wrapper .discussion-thread-title').click(function() {
            var commentsDiv = $(this).next().html('Loading comments...');
            var urlStr = $(this).attr('href');
            
            $.ajax({
                method: 'GET',
                url: urlStr,
                success: function(response) { commentsDiv.html(response); },
                failure: function() { commentsDiv.html('Unable to load comments. Try again!'); }
            });
            
            return false;
        });
    }
};