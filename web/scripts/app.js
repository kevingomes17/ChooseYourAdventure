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
                success: function(response) {commentsDiv.html(response);},
                failure: function() {commentsDiv.html('Unable to load comments. Try again!');}
            });
            
            return false;
        });
        
        $('#discussion-topics-wrapper .add-thread').click(function() {
            AppDialog.showDialog(this.href, 'medium', 'Add Thread');            
            return false;
        });
    }
};

var AppDialog = {
    dialogId: 'dialog-form',
    dimensions: {
        'default': {width: 300, height: 200},
        'small': {width: 300, height: 200},
        'medium': {width: 600, height: 400},
        'large': {width: 900, height: 600}
    },
    
    showDialog: function(urlStr, dimension, title) {
        var AD = AppDialog;
        
        $.ajax({
            method: 'GET',
            url: urlStr,
            success: function(response) {
                //console.log(AppDialog.dialogId);
                $('#'+AD.dialogId).css('display', 'block').html(response);
                AD._openDialog(dimension, title);
                
                //Initialize form validation.
                $('#'+AD.dialogId+' form').validate();
            },
            failure: function() {
                $('#'+AD.dialogId).html('Unable to load form. Please try again!');
            }
        });
    },
    
    _openDialog: function(dim, title) {        
        var AD = AppDialog;        
        
        var width = AD.dimensions[dim].width;
        var height = AD.dimensions[dim].height;        
        
        
        $('#'+AD.dialogId).dialog({
            autoOpen: true,
            height: height,
            width: width,
            modal: true,
            title: title,
            buttons: {
                "Save": function() { },
                "Cancel": function() {
                    $(this).dialog("close");
                }
            }
        });
        
        AppDialog._enableSave();
    },
    
    _submitForm: function() {
        var AD = AppDialog;
        AD._disableSave();
        
        var form = $('#'+AD.dialogId).find('form');        
        var url = form.attr('action');
        
        $.post(url, form.serialize(), function(response) {
            //alert(response.success);
            if(response.success == 'true') {
                alert('Saved successfully. '+response.message);
                AppDialog.closeDialog();
            } else {
                alert('Unable to save. '+response.message);
                AppDialog._enableSave();
            }            
        }, 'json');
    },
    
    _disableSave: function() {
        var AD = AppDialog;
        var buttons = $('#'+AD.dialogId).dialog('option', 'buttons', [
            {
                text: 'Saving..',
                click: function() { }
            }
        ]);
    },
    
    _enableSave: function() {
        var AD = AppDialog;
        var buttons = $('#'+AD.dialogId).dialog('option', 'buttons', [
            {
                text: 'Save',
                click: function() {
                    var AD = AppDialog;                    
                    if($(this).find('form').valid()) {
                        AD._submitForm();
                    }
                }
            },
            {
                text: 'Close',
                click: function() {$(this).dialog('close');}
            }
        ]);
    },
    
    closeDialog: function() {
        $('#'+AppDialog.dialogId).dialog('close');
    }
};

$(function() {
    $('.button').button();
});