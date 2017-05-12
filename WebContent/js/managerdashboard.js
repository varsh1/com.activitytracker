$(function() {
	var projectsummary = $("button[name=projectsummary]");
	var projectList = ("div.projectList");
	var projectdropdown = $("select[name=project]");
	var employeeList = $("div.employeeList");
	var employeesummary = $("button[name=employeesummary]");
	var employeeNameInput = $("input[name=employeeList]");
	var projectdetails = $("#projectdetails");
	var employeetaskdetails = $("#employeetaskdetails");
	var getemployeereport = $("button[name=getemployeereport]");
	var getprojectreport = $("button[name=getprojectreport]");
	var employeeName = $("input[name=employeeList]");
	var employeeId = $("input[name=employeeid]");
	var errorMessage = $("div.error-message");
	var successMessage = $("div.success-message");
	
	$(projectsummary).on("click", function() {
		$(projectList).removeClass("hidden");
		if(!employeeList.hasClass("hidden")) {
			$(employeeList).addClass("hidden");
		}
		
	});
	
	$(employeesummary).on("click", function() {
		$(employeeList).removeClass("hidden");
		if(!$(projectList).hasClass("hidden")) {
			$(projectList).addClass("hidden");
		}
		
	});
	
	$(employeeNameInput).autocomplete({
		
		minLength: 0,
		source : function(request, response) {
			
			$.ajax({
				type : "POST",
				url : context + "/ManagerEmployeeMapping",
				
				success : function(data) {

					mydata = $.parseJSON(data);
					response(mydata);
					
					response($.map(mydata, function(data, index) {
						return {
							label : data.employeeName,
							value : data.employeeId
						};
						
					}));
				},

			});
		},
		select : function(event, ui) {
			event.preventDefault();
			console.log("Selected: " + ui.item.label + " - "+ ui.item.value);
			$(employeeName).val(ui.item.label); 
			$(employeeId).val(ui.item.value);

		}
	}).on('focus', function(event) {
	    $(this).autocomplete("search", "");});
	
	
	$(getprojectreport).on("click", function() {
		$.ajax({
			method: "post",
			url: context+"/ProjectReport",
			data: $("form").serialize(),
		
			success: function(data) {
				
				var result = $.trim(data);
				if(result==="internalerror") {
					$(errorMessage).removeClass("display-none").fadeIn("4000").delay("3000").fadeOut("4000");
				}
				else {
					var project = $.parseJSON(data);
					console.log(project);
					$(employeetaskdetails).addClass("hidden").closest(".table").addClass("hidden");
					$(projectdetails).removeClass("hidden").closest(".table").removeClass("hidden");
					$(projectdetails).dataTable({
						"oLanguage": {
							"sEmptyTable": "You do not have any tasks in this project!"
							},
	            		data: project,
	            		"destroy": true,
	            		columns: [
	            			{"data": "taskId", className: "numericCol"},
	            			{"data": "taskName"},
	            			{"data": "assigneeName"},
	            			{"data": "status", "orderable" :false,
	                			"render" : function(data) {
	                				return data.toUpperCase();
	                			}	
	                		},
	            			{"data": "comments" , "orderable" :false},
	            			{"data": "estimatedTime", className: "numericCol"},
	            			{"data": "hoursLogged", className: "numericCol"},
	            			{"data": "loggedDate",
	            				
	            			"render" : function(data) {
	            				if(data!=null) {
	            					var formattedDate = new Date(data);
	            					formattedDate = formattedDate.getDate() +"/"+ formattedDate.getMonth()+"/"+formattedDate.getFullYear();
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
	
	
	$(getemployeereport).on("click", function() {
		if(!$(employeeNameInput).val()) {
			$("label[name=chooseAtleastOneMessage]").removeClass("hidden");
			return false;
		}
		else {
			$("label[name=chooseAtleastOneMessage]").addClass("hidden");
				$.ajax({
				method: "post",
				url: context+"/EmployeeReport",
				data: $("form").serialize(),
			
				success: function(data) {
					console.log(data);
					var result = $.trim(data);
					if(result==="internalerror") {
						$(errorMessage).removeClass("display-none").fadeIn("4000").delay("3000").fadeOut("4000");
					}
					else {
						var employeetasks = $.parseJSON(data);
						console.log(employeetasks);
						 $(projectdetails).addClass("hidden").closest(".table").addClass("hidden");
						 $(employeetaskdetails).removeClass("hidden").closest(".table").removeClass("hidden");;
						 $(employeetaskdetails).dataTable({
							"oLanguage": {
								"sEmptyTable": "There are no tasks for this employee in this project !"
								},
		            		data: employeetasks,
		            		"destroy": true,
		            		columns: [
		            			{"data": "projectId", className: "numericCol"},
		            			{"data": "projectName"},
		            			{"data": "taskId", className: "numericCol"},
		            			{"data": "taskName"},
		            			{"data": "status", "orderable" :false,
		                			"render" : function(data) {
		                				return data.toUpperCase();
		                			}	
		                		},
		            			{"data": "comments" , "orderable" :false},
		            			{"data": "estimatedTime", className: "numericCol"},
		            			{"data": "hoursLogged", className: "numericCol"},
		            			{"data": "loggedDate",
		            				
		            			"render" : function(data) {
		            				if(data!=null) {
		            					var formattedDate = new Date(data);
		            					formattedDate = formattedDate.getDate() +"/"+ formattedDate.getMonth()+"/"+formattedDate.getFullYear();
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
				error: function(data) {
					$(errorMessage).html("Couldn't connect to server. Please try again later").removeClass("display-none").fadeIn("4000").delay("3000").fadeOut("4000");
				}
			});
		 }
	});
		
});