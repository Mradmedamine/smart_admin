$(function() {

	var chatPage = document.querySelector('#chat-container');
	var chatHeader = $(chatPage).find('.card-header');
	var chatBody = $(chatPage).find('.card-body');
	var chatFooter = $(chatPage).find('.card-footer');
	
	var usernameForm = document.querySelector('#usernameForm');
	var messageArea = document.querySelector('#chat ul');
	var messageForm = document.querySelector('#messageForm');

	function connect(event) {
		event.preventDefault();
		var username = document.querySelector('#usernameForm #name').value.trim();
		$.ajax({
			type : 'POST',
			url : '/chat/connect',
			data : {
				sender : username,
				type : 'JOIN'
			},
			success : function(result) {
				$(usernameForm).jhide();
				$(messageArea).jshow();
				$(messageForm).jshow();
				showReceivedMessage(result);
			},
			error : function(error) {
				onError(error);
			}
		});
	}

	function onError(error) {
		toastr['error']('error occured ');
		$('#toast-container .toast-error').show();
	}

	function sendMessage(event) {
		event.preventDefault();
		cleanSuggestions();
		var username = document.querySelector('#usernameForm #name').value.trim();
		var message = document.querySelector('#messageForm #message').value.trim();
		$.ajax({
			type : 'POST',
			url : '/chat/sendMessage',
			data : {
				sender : username,
				content : message,
				type : 'CHAT'
			},
			success : function(result) {
				showReceivedMessage(result);
			},
			error : function(error) {
				onError(error);
			}
		});
	}

	function showReceivedMessage(messageElements) {
		$(messageArea).html($(messageArea).html() + messageElements);
		messageArea.scrollTop = messageArea.scrollHeight;
		initSuggestions();
	}

	function showHideChat() {
		if ($(chatBody).is(':visible')) {
			$(chatBody).jhide();
			$(chatFooter).jhide();
		} else {
			$(chatBody).jshow();
			$(chatFooter).jshow();
		}
	};
	
	function initSuggestions() {
		$(messageArea).find('.suggestion').click(function(e) {
			$('#messageForm #message').val($(this).text());
		});
	}
	
	function cleanSuggestions() {
		$(messageArea).find('.suggestion').remove();
	}
	
	$(chatHeader).on('click', showHideChat);
	usernameForm.addEventListener('submit', connect, true);
	messageForm.addEventListener('submit', sendMessage, true);
	

});