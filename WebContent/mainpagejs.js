var app = angular.module('Sectors', []);
	
	app.controller('getSector', function($scope, $http) {	
			
			var tab,flag;
			this.tab=1;
			this.flag=0;
			var value;
			var details;
			var cont;
			$scope.value="IN";
			var email="";
			window.onload=function()
			{
			    document.getElementById('home').style.display='block';
				//document.getElementById('wid').style.display='block';
				document.getElementById('signup').style.display='none';
				document.getElementById('mypage').style.display='none';
				document.getElementById('sector').style.display='none';
				document.getElementById('aboutpage').style.display='none';
			
				
				$http.get('http://localhost:8080/RestDemoService/sectorDisplay')
					.then(function(response) {
        $scope.content = response.data;
        
        $scope.statustext = response.status;
		
        
											});
					
			};
			this.savedata=function(Company,Price)
			{
				
				console.log(Company);
				if ($scope.value=="OUT")
					{
					//var Status=document.getElementById("status").textContent;
					var volume=document.getElementById("quant").textContent;
					var volumeBuy=document.getElementById("quant1").textContent;
					
					if(volumeBuy=="")
						{ var serviceName='http://localhost:8080/RestDemoService/Savenew';
					 	var varname = {login:{email_id:$scope.email},savedetail:[{securityCode:Company,curr_price:Price,status:"BUY",volume:volumeBuy}]};
					    var jsonv = JSON.stringify(varname);
						console.log(jsonv);
							
										$http.post(serviceName,jsonv,{'Content':'application/json','Accept':'application/json'})
										.then(function(response){			//Anonymus function for success callback
							
											$scope.cont=response.data;
											alert("DATA IS SAVED!");//Prints success log
								
								
										},function(response){				//Anonymus function for error callback
							
								console.log("There was an error: " + response.status + " " + response.statusText);
																//Prints error log
												});
						}
					else
						{
						var serviceName='http://localhost:8080/RestDemoService/Savenew';
					 	var varname = {login:{email_id:$scope.email},savedetail:[{securityCode:Company,curr_price:Price,status:"SELL",volume:volume}]};
					    var jsonv = JSON.stringify(varname);
						console.log(jsonv);
							
										$http.post(serviceName,jsonv,{'Content':'application/json','Accept':'application/json'})
										.then(function(response){			//Anonymus function for success callback
							
											$scope.cont=response.data;
											alert("DATA IS SAVED!");//Prints success log
								
								
										},function(response){				//Anonymus function for error callback
							
								console.log("There was an error: " + response.status + " " + response.statusText);
																//Prints error log
												});
						}
					 
							
					}
				else
					{
					alert("YOU ARE NOT LOGGED IN!");
					
					}
			
				
				
			};
			
			
			this.mypage=function()
			{
					$http.get('http://localhost:8080/RestDemoService/sectorDisplay')
					.then(function(response) {
        $scope.mypage = response.data;
        
			});
			};
			
				this.select = function(setTab) {
                this.tab = setTab;
				if (this.tab === 1)
				{
					document.getElementById('home').style.display='block';
				//document.getElementById('wid').style.display='block';
				document.getElementById('sector').style.display='none';
				 document.getElementById('signup').style.display='none';
				document.getElementById('mypage').style.display='none';
				document.getElementById('aboutpage').style.display='none';
				}
				else if (this.tab === 2)
				{
					document.getElementById('home').style.display='none';
				//	document.getElementById('wid').style.display='none';
				   document.getElementById('sector').style.display='none';
					document.getElementById('signup').style.display='none';
					document.getElementById('mypage').style.display='block';
					document.getElementById('aboutpage').style.display='none';
					
				}
                else if (this.tab === 3)
				{
					document.getElementById('home').style.display='none';
					//document.getElementById('wid').style.display='none';
					document.getElementById('sector').style.display='none';
					document.getElementById('signup').style.display='block';
				    document.getElementById('mypage').style.display='none';	
					document.getElementById('aboutpage').style.display='none';
				}
                else if (this.tab === 4)
				{
				document.getElementById('home').style.display='none';
				//document.getElementById('wid').style.display='none';
				document.getElementById('sector').style.display='none';
					document.getElementById('signup').style.display='none';
				    document.getElementById('mypage').style.display='none';
					document.getElementById('aboutpage').style.display='block';
				    
					
				}
                else if (this.tab === 5)
				{
					document.getElementById('home').style.display='none';
									
					document.getElementById('signup').style.display='none';
				    document.getElementById('mypage').style.display='none';	
					
				document.getElementById('sector').style.display='block';
			
				} 
            };
	
            this.back=function(){
            	document.getElementById('home').style.display='block';
            }
	this.submit = function(UIname,UIsymbol,serviceName) {
	
		this.select(5);
	var varname = {name:UIname,symbol:UIsymbol};
    var jsonv = JSON.stringify(varname);
	console.log(jsonv);
		$http.post(serviceName,jsonv,{'Content':'application/json','Accept':'application/json'})
		.then(function(response){			//Anonymus function for success callback
		
			console.log(response.data);		//Prints success log
			        $scope.prediction = response.data;
			
			
		},function(response){				//Anonymus function for error callback
		
			console.log("There was an error: " + response.status + " " + response.statusText);
											//Prints error log
							});
			
		};
		
		
	this.login=function()
	{ 
		if ($scope.value=="IN")
			{
			var Uname=document.getElementById("uname").value;
			  var Upswd=document.getElementById("psw").value;
			  $scope.email=Uname;
			  
			  	var varname = {email_id:Uname,password:Upswd};
		    var jsonv = JSON.stringify(varname);
			console.log(jsonv);
				$http.post('http://localhost:8080/RestDemoService/Login',jsonv,{'Content':'application/json','Accept':'application/json'})
				.then(function(response){			//Anonymus function for success callback
				
					console.log(response.data);		//Prints success log
					        $scope.login = response.data;
					        if ($scope.login=="") {
					            alert("NOT VALID USERNAME OR PASSWORD");
					        }
					        else
					        	{
					        	$scope.value="OUT";
					        	 alert("YOU ARE LOGGED IN!");
					        	 $scope.cont=response.data;
					        	 document.getElementById('id01').style.display='none';
					        	 
					        	}
					
					
				},function(response){				//Anonymus function for error callback
				
					console.log("There was an error: " + response.status + " " + response.statusText);
													//Prints error log
									});
			
			}
		else
			{
			document.getElementById('id01').style.display='none';
			 document.getElementById('mypage').style.display='none';
			 $scope.value="IN";
			 alert(" YOU ARE LOGGED OUT !");
			 
			}
		
		
	 // this.submit(Uname,Upswd, 'http://localhost:8080/RestDemoService/Login');
	  
	  this.flag=1;
      mypage();
	
	};
	
	
	this.signup=function()
	{
		var first_name=document.getElementById('fname').value;
	  var last_name=document.getElementById('lname').value;
	  var email_id =document.getElementById('eid').value;
	  var Password=document.getElementById('passwd').value;
		var phn_no=document.getElementById('phone').value;
		  $scope.email=email_id;
		  
	  var serviceName='http://localhost:8080/RestDemoService/SignUp';
	 	var varname = {first_name:first_name,last_name:last_name,email_id:email_id,password:Password,phn_no:phn_no};
    var jsonv = JSON.stringify(varname);
	console.log(jsonv);
		$http.post(serviceName,jsonv,{'Content':'application/json','Accept':'application/json'})
		.then(function(response){			//Anonymus function for success callback
		
			console.log(response.data);		//Prints success log
			        $scope.content_new = response.data;

					//this.select(1);
			        document.getElementById('home').style.display='block';
			        document.getElementById('signup').style.display='none';
					alert("Welcome to BREAD N BUCKS!");
			
		},function(response){				//Anonymus function for error callback
		
			console.log("There was an error: " + response.status + " " + response.statusText);
											//Prints error log
							});
	
	  this.flag=1;
	};
	
	});