$(function() {

	var communesWidget;

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
			updatePageComponents(code, region);
		}
	});

	function updatePageComponents(code, region) {
		
		//update info Widget
		$.ajax({
			type : 'GET',
			url : '/department/info/' + code,
			success : function(result) {
				$('#departmentInfoWidget').fadeOut(500, function() {
					$(this).replaceWith(result).fadeIn(500);
					$('#departmentInfoWidget #region').html(region);
				});
			},
			error : function(error) {
				toastr['error']('error occured ');
				$('#toast-container .toast-error').show();
			}
		});
		
		//update communes widget
		$.ajax({
			type : 'GET',
			url : '/department/communes/' + code,
			success : function(result) {
				$('#communesWidget').fadeOut(500, function() {
					$(this).replaceWith(result).fadeIn(500);
					initCommunesList();
				});
			},
			error : function(error) {
				toastr['error']('error occured ');
				$('#toast-container .toast-error').show();
			}
		});
	}

	function initCommunesList() {
		communesWidget = $('#communesWidget');
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
		
		$(communesWidget).find('#searchInput').on('change keyup paste', function(e) {
			filterCommunes($(this).val().toUpperCase())
		});
	}
	
	function filterCommunes(filter) {
		var elements = $(communesWidget).find('.communeItem');
		for (var i = 0; i < elements.length; i++) {
			var span = elements[i].getElementsByTagName("span")[0];
			if (span.innerHTML.toUpperCase().indexOf(filter) > -1) {
				$(elements[i]).show();
			} else {
				$(elements[i]).hide();
			}
		}
	}
	
});
