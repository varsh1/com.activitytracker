$(function() {
	
	var datepicker = $("#datepicker");
	var taskName = $("input[name=taskname]");
	var addTask = $("button[name=addtask]");
	var taskId = $("input[name=taskid]");
	var successMessage = $("div.success-message");
	var errorMessage = $("div.error-message");
	
	//$("div.submit-success").css("display","none");
	var mydata;
	$(datepicker).datepicker({
		dateFormat : "dd/mm/yy",
		maxDate: 0,
		beforeShowDay : $.datepicker.noWeekends,
		beforeShow : function(input, inst) {
			setTimeout(function() {
				inst.dpDiv.css({
					top : $(datepicker).offset().top + 35,
					left : $(datepicker).offset().left
				});
			}, 0);
		}

	}).datepicker("setDate", new Date());
	$("input").focus(function() {
		$('html, body').animate({
			scrollTop : $(this).offset().top - 25
		}, 10);
	});

	$(taskName).autocomplete(
			{
				source : function(request, response) {

					$.ajax({
						type : "POST",
						url : context + "/TaskDetails",
						data : {
							term : request.term
						},

						success : function(data) {

							taskdetails = $.parseJSON(data);
							response(taskdetails);
							
							response($.map(taskdetails, function(data, index) {
								return {
									label : data.taskName,
									value : data.taskId
								};
								
							}));
						},
						error: function() {
							
						}

					});
				},
				select : function(event, ui) {
					event.preventDefault();
					console.log("Selected: " + ui.item.label + " - "+ ui.item.value);
					$(taskName).val(ui.item.label); // display the selected text
					$(taskId).val(ui.item.value);

				}

			});
	
	$(addTask).on("click", function() {
		
		$.ajax({
			method: "post",
			url: context+"/AddTask",
			data: $("form").serialize(),
			success: function(data) {
				console.log("submitted" + data);
				var result = $.trim(data);
				if(result=="success") {
				$("form").trigger("reset");
				$(successMessage).removeClass("display-none").fadeIn("4000").delay("3000").fadeOut("4000");
				}
				else {
					$(errorMessage).removeClass("display-none").fadeIn("4000").delay("3000").fadeOut("4000");
				}
			},
			error : function() {
				window.location.href = context+"/error.jsp"
			}
		});
	});

});