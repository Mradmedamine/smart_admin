$(function() {

	initCommunesList();
	
	$('#francemap').vectorMap({
		map : 'france_fr',
		hoverOpacity : 0.5,
		hoverColor : false,
		backgroundColor : '#ffffff',
		colors : couleurs,
		borderColor : '#000000',
		selectedColor : '#EC0000',
		enableZoom : true,
		showTooltip : true,
		onRegionClick : function(element, code, region) {
			updatePageComponent(code, region);
		}
	});

	function updatePageComponent(code, region) {
		$.ajax({
			type : 'GET',
			url : '/department/' + code,
			success : function(result) {
				$('#departmentInfoWidget').fadeOut(500, function() {
					$(this).replaceWith(result).fadeIn(500);
					$('#departmentInfoWidget #region').html(region);
					$('#departmentInfoWidget .selectpicker').selectpicker('refresh');
				});
			},
			error : function(error) {
				toastr['error']('error occured ');
				$('#toast-container .toast-error').show();
			}
		});
	}
	
	function initCommunesList() {
		var communesWidget = $('#communesWidget');
		
		$(communesWidget).find('.communeItem').slice(0, 4).show();
		$(communesWidget).find('#loadMore').on('click', function(e) {
			e.preventDefault();
			$('.communeItem:hidden').slice(0, 4).slideDown();
			if ($('.communeItem:hidden').length == 0) {
				$(communesWidget).find('#load').fadeOut('slow');
			}
			$('html,body').animate({
				scrollTop : $(this).offset().top
			}, 1500);
		});
	}
	
});
