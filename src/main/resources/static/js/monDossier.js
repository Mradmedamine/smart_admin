$(function() {

    var monDossierContainer = $('#dossier-container');

    initModal();

    $('.btn-delete').click(function(e) {
		var documentPanel = $(this).closest('#document-container');
		var documentId = $(documentPanel).data('document-id');
		var url = '/documents/' + documentId;
		$.ajax({
		    type : 'DELETE',
		    url : url,
		    success : function(result) {
			toastr['success'](message.common.savingSuccessMessage);
			$('#toast-container .toast-success').show();
			timer = setTimeout(function() {
			    location.reload();
			}, 1000);
		    }
		});
    });

    function initModal() {
	
		var modal = $('#documentModal');
		var actionForm = $(modal).find('form');
		var closeBtn = $(modal).find('.close');
		var backBtn = $(modal).find('.btn-cancel');
		var saveBtn = $(modal).find('.btn-save');
		var newBtn = $(monDossierContainer).find('#newDocument');
	
		var fileInput = $(actionForm).find(':file');
		var fileName = $(fileInput).attr('data-placeholder');

		$(newBtn).on('click', function() {
		    $(modal).jshow();
		});
	
		$(closeBtn).on('click', function() {
		    $(actionForm).reset();
		    $(modal).jhide();
		});
	
		$(backBtn).on('click', function() {
		    $(actionForm).reset();
		    $(modal).jhide();
		});
	
		$(saveBtn).on('click', function() {
		    $(actionForm).submit();
		});
	
		$(actionForm).submit(function() {
		    if ($(actionForm).valid()) {
			var file = $(actionForm).find('#physicalFile').prop('files')[0];
			if (file && file.size > 2048576) {
			    toastr["error"](message.common.fileSizeError);
			    $('#toast-container .toast-error').show();
			    return false;
			}
			if (!file) {
			    file = new File([ "" ], "");
			}
			var formObject = $(this).serializeObject();
			var formData = new FormData();
			formData.append("physicalFile", file);
	
			$.ajax({
			    type : 'POST',
			    url : "/documents",
			    data : formData,
			    async : false,
			    cache : false,
			    contentType : false,
			    processData : false,
			    success : function(result) {
				$(modal).hide();
				toastr['success'](message.common.savingSuccessMessage);
				$('#toast-container .toast-success').show();
				timer = setTimeout(function() {
				    location.reload();
				}, 1000);
			    }
			});
		    }
		    return false;
		});
	
		$(window).on('click', function(event) {
		    if (event.target == modal) {
			$(modal).hide();
		    }
		});
    }

});
