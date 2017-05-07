$(function() {
	$("#datepicker").datepicker({
		dateFormat : "dd/mm/yy",
		changeMonth : true,
		changeYear : true,
		 yearRange: "1930:2010"
	}).val();
});

$(function() {
	$(".widget input[type=submit], .widget a, .widget button").button();
	$("button, input, a").click(function(event) {

	});
});
$("#salutation").selectmenu();

$.validator.addMethod("dateFormat", function(value, element) {
	return value.match(/^dd?-dd?-dd$/);
}, "Please enter a date in the format dd-mm-yyyy.");

$(document).ready(function() {
	$('#registerForm').validate({
		success : "valid",
		rules : {
			name : {
				required : true
			},
			dataofBirth : {
				required : true,
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

function myFunction() {
	// Declare variables
	var input, filter, table, tr, td, i;
	input = document.getElementById("myInput");
	filter = input.value.toUpperCase();
	table = document.getElementById("employeesTable");
	tr = table.getElementsByTagName("tr");

	// Loop through all table rows, and hide those who don't match the search
	// query
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[1];
		if (td) {
			if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}
	}
}