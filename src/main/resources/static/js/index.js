$(function() {

	const FRANCE_COUNTRY_CODE = 'FR';

	var communesWidget;

	initCommunesList();
	initGeoLocation();
	
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

		// update info Widget
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

		// update communes widget
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
		if (filter.trim() === '') {
			$(elements).hide();
			$(elements).slice(0, 4).show();
		} else {
			for (var i = 0; i < elements.length; i++) {
				var span = elements[i].getElementsByTagName("span")[0];
				if (span.innerHTML.toUpperCase().indexOf(filter) > -1) {
					$(elements[i]).show();
				} else {
					$(elements[i]).hide();
				}
			}
		}
	}

	function initGeoLocation() {
		
		 if (navigator === undefined || navigator.geolocation === undefined) { 
			 $('#currentLocationBtn').hide(); 
		 } else {
			$('#currentLocationBtn').click(function(e) {
				event.preventDefault();
				navigator.geolocation.getCurrentPosition(function (position) {
//	                    alert('lat : ' + position.coords.latitude + ' long : ' + position.coords.longitude);
	                    $.ajax({
	            			type : 'GET',
	            			url : 'https://open.mapquestapi.com/geocoding/v1/reverse?key=CC8ZccdkIvqYozlac0KaE4v7feVzNVBN&location='+ 
	            			position.coords.latitude +',' + position.coords.longitude +'&includeRoadMetadata=true&includeNearestIntersection=true',
	            			success : function(result) {
	            				 alert(result.results[0].locations[0].adminArea5);
	            			},
	            			error : function(error) {
	            				toastr['error']('error occured ');
	            				$('#toast-container .toast-error').show();
	            			}
	            		});
	                },
	                function (error) {
	                    alert("Erreur à l'obtention des données de géolocalisation :" + error);
	                }
	            );
			});
	     }
	}

});
