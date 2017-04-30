$(function() {
	$("#datepicker").datepicker({
		dateFormat : "dd/mm/yy"
	}).val();
});

$(function() {
	$(".widget input[type=submit], .widget a, .widget button").button();
	$("button, input, a").click(function(event) {

	});
});
$("#salutation").selectmenu();

$(document).ready(function() {
	$('#registerForm').validate({
		success : "valid",
		rules : {
			name : {
				required : true
			},
			dataofBirth : {
				required : true
			},
			salary : {
				required : true,
				digits : true
			},
			jobTitle : {
				required : true
			},
			department : {
				required : true
			},
			email : {
				required : true,
				email : true
			}
		},
		highlight : function(element, errorClass) {
			$(element).fadeOut(function() {
				$(element).fadeIn();
			});
		}
	});
});