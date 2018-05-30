$(function() {

	const ENTER_KEY_CODE = 13;

	var commentsContainer = $('#comments-container');
	var commentBox = $(commentsContainer).find('#commentBox');

	$(commentsContainer).find('#showCommentBox').click(function(e) {
		$(commentBox).jshow();
	});

	$(commentBox).find('input').keypress(function(e) {
		if (e.which === ENTER_KEY_CODE) {
			saveComment(commentBox.data('url'), $(this).val());
		}
	});

	function saveComment(url, comment) {
		$.ajax({
			type : 'POST',
			url : url,
			data : {
				comment : comment
			},
			success : function(result) {
				timer = setTimeout(function() {
					location.reload();
				}, 500);
			}
		});
	}

});
