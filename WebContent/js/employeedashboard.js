$(function(){
	var projectreport = $("button[name=projectdetails]");
	var projectdetails = $("#projectdetails");
	var addtask = $("button[name=addtask]");
	var errorMessage = $("div.error-message");
	var successMessage = $("div.success-message");
	
	$("button[name=choose]").on("click", function() {
		$.ajax({
			method: "post",
			url: context+"/EmployeeTaskHistory",
			data: $("form").serialize(),
		
			success: function(data) {
				var result = $.trim(data);
				console.log(result);
				if(result == "internalerror") {
					$(errorMessage).removeClass("display-none").fadeIn("4000").delay("3000").fadeOut("4000");
				}else {
				var project = $.parseJSON(data);
				console.log(project);
				 $(projectdetails).removeClass("hidden");
				$(projectdetails).dataTable({
					"oLanguage": {
						"sEmptyTable": "You do not have any tasks in this project!"
						},
            		data: project,
            		"destroy": true,
            		columns: [
            			{"data": "taskId", className: "numericCol"},
            			{"data": "taskName"},
            			{"data": "status", "orderable" :false,
            			"render" : function(data) {
            				return data.toUpperCase();
            			}	
            			},
            			
            			{"data": "comments", "orderable" :false},
            			{"data": "estimatedTime", className: "numericCol"},
            			{"data": "hoursLogged", className: "numericCol"},
            			{"data": "loggedDate",
            				
            			"render" : function(data) {
            				if(data!=null) {
            					var formattedDate = new Date(data);
            					var month = formattedDate.getMonth() + 1;
            					formattedDate = formattedDate.getDate() +"/"+ month +"/"+formattedDate.getFullYear();
            					return formattedDate;
            				}
            				else {
            					return "";
            				}
            				
            			}
            				
            			}
            			
            		]
            	});
			  }
			},
			error: function() {
				$(errorMessage).html("Couldn't connect to server. Please try again later").removeClass("display-none").fadeIn("4000").delay("3000").fadeOut("4000");
			}
		});
	});
	

	
	$(projectreport).on("click", function() {
		$("form").attr("action", context+"/ProjectDetails");
		$("form").submit();
		return true;
	});
	
	$(addtask).on("click", function() {
		$("form").attr("action", context+"/pages/addtask.jsp");
		$("form").submit();
		return true;
	});
});