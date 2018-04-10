$(document).ready(
		function() {

			$('#francemap').vectorMap(
					{
						map : 'france_fr',
						hoverOpacity : 0.5,
						hoverColor : false,
						backgroundColor : "#ffffff",
						colors : couleurs,
						borderColor : "#000000",
						selectedColor : "#EC0000",
						enableZoom : true,
						showTooltip : true,
						onRegionClick : function(element, code, region) {
							$.ajax({
							    type : 'GET',
							    url : '/department/' + code,
							    success : function(result) {
							    	$('#departmentInfoWidget').fadeOut(500, function()
					    			{     
					    			    $(this).replaceWith(result).fadeIn(500);
					    			    $('#departmentInfoWidget #region').html(region);
					    			    $('#departmentInfoWidget .selectpicker').selectpicker('refresh');
					    			});

							    },
							    error : function(error) {
							    	toastr['error']("error occured ");
							    	$('#toast-container .toast-error').show();
							    }
							});
						}
					});
		});