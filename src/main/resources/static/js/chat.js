$(function() {
	
var chatPage = document.querySelector('#chat-container');
var usernameForm = document.querySelector('#usernameForm');
var messageArea = document.querySelector('#chat ul');
var messageForm = document.querySelector('#messageForm');

var colors = [ '#2196F3', '#32c787', '#00BCD4', '#ff5652', '#ffc107',
		'#ff85af', '#FF9800', '#39bbb0' ];

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
}

function getAvatarColor(messageSender) {
	var hash = 0;
	for (var i = 0; i < messageSender.length; i++) {
		hash = 31 * hash + messageSender.charCodeAt(i);
	}

	var index = Math.abs(hash % colors.length);
	return colors[index];
}

usernameForm.addEventListener('submit', connect, true);
messageForm.addEventListener('submit', sendMessage, true);

});