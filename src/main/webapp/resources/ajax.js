$(function() {
	$(".widget input[type=submit], .widget a, .widget button").button();
	$("button, input, a").click(function(event) {

	});
});

$(function() {
	$("#datepicker").datepicker({
		dateFormat : "yy-mm-dd",
		changeMonth : true,
		changeYear : true,
		yearRange : "1930:2010"
	}).val();
});

$(document)
		.ready(
				function() {
					$(".employeeDetails")
							.click(
									function() {
										$
												.getJSON(
														"http://localhost:8080/hrspring/rest/employees/"
																+ $(this)
																		.attr(
																				"value"),
														function(result) {
															departmentName = result.department.departmentName;
															$("#dialog")
																	.html(
																			'<table align="center" cellpadding="2">');
															$
																	.each(
																			result,
																			function(
																					key,
																					value) {
																				if (key === 'department') {
																					$(
																							"#dialog")
																							.append(
																									'<tr><td>'
																											+ key
																											+ '</td><td>'
																											+ departmentName
																											+ '</td></tr>')
																				} else {
																					$(
																							"#dialog")
																							.append(
																									'<tr><td>'
																											+ key
																											+ '</td><td>'
																											+ value
																											+ '</td></tr>')
																				}
																			});
															$("#dialog")
																	.append(
																			'</table>')
															$("#dialog")
																	.dialog(
																			"open");
														});
									});

				});

$(function() {
	$("#dialog").dialog({
		autoOpen : false
	});
});

$(function() {
	var dialog, form,

	// From
	// http://www.whatwg.org/specs/web-apps/current-work/multipage/states-of-the-type-attribute.html#e-mail-state-%28type=email%29
	
	
	emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/, name = $("#name"), email = $("#email"), password = $("#password"), allFields = $(
			[]).add(name).add(email).add(password), tips = $(".validateTips");

	function updateTips(t) {
		tips.text(t).addClass("ui-state-highlight");
		setTimeout(function() {
			tips.removeClass("ui-state-highlight", 1500);
		}, 500);
	}

	$.fn.serializeObject = function() {
		var o = {};
		var a = this.serializeArray();
		$.each(a, function() {
			if (o[this.name] !== undefined) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};

	function addUser() {
		var jsonText = JSON.stringify($('#myForm').serializeObject());
		  id = $( "#id" );
		  name = $( "#name" );
		  salary = $( "#salary" );
		  jobTitle = $( "#jobTitle" );
		  department = $( "#department" );
	      email = $( "#email" ); 
		$.ajax({
			url : "http://localhost:8080/hrspring/rest/employees/add",
			type : "POST",
			data : jsonText,
			contentType : "application/json; charset=utf-8",
			success : function() {
				dialog.dialog("close");
				// location.reload();
				$("tbody").append(
						"<tr>"
								+ "<td>"
								+ 1 + "</td>" + "<td>"
								+ name.val() + "</td>" + "<td>"
								+ salary.val() + "</td>" + "<td>"
								+ jobTitle.val() + "</td>" + "<td>"
								+ department.val() + "</td>" + "<td>"
								+ email.val() + "</td>" + "</tr>");
			}
		});
		return true;
	}

	dialog = $("#dialog-form").dialog({
		autoOpen : false,
		height : 600,
		width : 450,
		modal : true,
		buttons : {
			"Create an account" : addUser,
			Cancel : function() {
				dialog.dialog("close");
			}
		},
		close : function() {
			form[0].reset();
			allFields.removeClass("ui-state-error");
		}
	});

	form = dialog.find("form").on("submit", function(event) {
		event.preventDefault();
		addUser();
	});

	$("#create-user").button().on("click", function() {
		dialog.dialog("open");
	});
});