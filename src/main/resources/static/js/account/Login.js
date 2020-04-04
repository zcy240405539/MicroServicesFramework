$(document).ready(function() {
	$("#emailTextBox").blur(validateLogin);
	$("#passwordTextBox").blur(validatePassword);
	$("#emailTextBoxReg").blur(checkUser);
	$("#passwordTextBoxReg").blur(validatePasswordReg);
	//$("#passwordTextBox").click(checkIfEmptyJquery);
	//$("#logo").mouseenter(changeLogo);
});

function validateLogin(){
	//var emailElement=$("#emailTextBox");
	if(this.value==""){
		$('#emailHelp').text('Please do not leave email blank!');
		$('#emailHelp').show();
	}else if(this.value.indexOf("@") == -1){
		$('#emailHelp').text('Please fill in a valid email address!');
		$('#emailHelp').show();
	}else{
		$('#emailHelp').hide();
	}
}

function validatePassword(){
	//var passwordElement = document.getElementById("passwordTextBox");
	//var passwordElement=$("#passwordTextBox");
	if(this.value == ""){
		//document.getElementById('passwordHelp').style.display='block';
		//$('#passwordHelp').css("display","block");	
		$('#passwordHelp').show();
	}else{
		$('#passwordHelp').hide();
	}
}

function validatePasswordReg(){
	if(this.value == ""){
		$('#passwordHelpReg').show();
	}else{
		$('#passwordHelpReg').hide();		
	}
}


function checkUser(){
	var checkUserAjaxObj={
	        url: '/doesUserExist',
	        type: 'post',
	        data: {
			   eid:$("#emailTextBoxReg").val()
			},
	        context: this,
		    success: function (data) {
	        		if(data=="true")
	        			alert("userid already taken");
		        },
	        error: function (data) {
	        	console.log("failure");
	        }
	};
	
	$.ajax(checkUserAjaxObj);
		
	//var emailElement = this;
	if(this.value==""){
		$('#emailHelpReg').text('Please do not leave email blank!');
		$('#emailHelpReg').show();
	}else if(this.value.indexOf("@") == -1){
		$('#emailHelpReg').text('Please fill in a valid email address!');
		$('#emailHelpReg').show();
	}else{
		$('#emailHelpReg').hide();
	}
	
}







