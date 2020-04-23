$(document).ready(function() {
	$("#emailTextBox").blur(validateLogin);
	$("#passwordTextBox").blur(validatePassword);
	$("#emailTextBoxReg").blur(checkUser);
	$("#passwordTextBoxReg").blur(validatePasswordReg);
});

function validateLogin(){
	//var emailElement=$("#emailTextBox");
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
	//alert("triggered");
	var checkUserAjaxObj={
	        url: '/doesUserExist',
	        type: 'get',
	        data: {
	        	userid:$("#emailTextBoxReg").val()
			},
	        context: this,
		    success: function (data) {  	
	        		if(data.userchecked==true){
	        			//alert("user id already taken");
	        			$('#emailHelpReg').text('User ID already taken!');
	        			$('#emailHelpReg2').hide();
	        			$('#emailHelpReg').show();
		    		}else{
		    			$('#emailHelpReg2').text('User ID is available!');
		    			$('#emailHelpReg').hide();
		    			$('#emailHelpReg2').show();
		    			
		    		}
		        },
	        error: function (data) {
	        	console.log("failure");
	        	alert(data.userid+" error");
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
