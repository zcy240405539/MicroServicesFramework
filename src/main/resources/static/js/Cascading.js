		
	$(document).ready(function() {
		$("#selCountry").change(selectC);
	});
	
	function selectC()
	{	
		console.log("changed");
		var cityList= new Array();
		var countryIndex;
		
		cityList['us']=['New York','Chicago','Los Angeles', 'San Francisco'];
		cityList['cn']=['Beijing','Shanghai','Shenzhen', 'Hongkong'];
		cityList['ru']=['Moscow','Saint Petersburg','Chelyabinsk', 'Yekaterinburg'];
		cityList['in']=['Delhi','Mumbai','Bengaluru', 'Kolkata'];
		
		// index of 1st level of menu
		var e = document.getElementById('selCountry');
		var countryIndex = e.options[e.selectedIndex].value;
		//console.log(e.selectedIndex);
		//console.log(e.text);
		var op;

		//clear 2nd level menu, display default
		document.getElementById('selCity').options.length=1;
		
		//display all items in list in a loop
		for(var i in cityList[countryIndex]) 
		{
			console.log(cityList[countryIndex][i]);
			op=new Option(cityList[countryIndex][i],cityList[countryIndex][i]);
			document.getElementById('selCity').options.add(op);
		}
	}



	