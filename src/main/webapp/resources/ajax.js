$(function() {
	$(".widget input[type=submit], .widget a, .widget button").button();
	$("button, input, a").click(function(event) {

	});
});

$(document).ready(
		function() {
			$("#employeeDetails").click(
					function() {
						$.getJSON(
								"http://localhost:8080/hrspring/rest/employees/"
										+ $("#employeeDetails").val(),
								function(result) {
									departmentName=result.department.departmentName;
									$("#dialog").html('<table align="center" cellpadding="2">');
									$.each(result, function(key, value) {
										if(key==='department'){
											$("#dialog").append('<tr><td>'+key+'</td><td>'+departmentName+'</td></tr>')
										}else{
										$("#dialog").append('<tr><td>'+key+'</td><td>'+value+'</td></tr>')}
									});
									$("#dialog").append('</table>')
									$("#dialog").dialog("open");
								});
					});

		});

$(function() {
	$("#dialog").dialog({
		autoOpen : false
	});
});


$("#registerForm").on("submit", function(){
	var str = $("#registerForm").serialize();
	$.ajax({
	    type:"post",
	    data:str,
	    url:"http://localhost:8080/hrspring/rest/employees/add",
	    async: false,
	    dataType: "json",
	    success: function(){
	       alert("success");
	    }
	});
	   return false;
	 })