Feature: Testing CRUD methods on account details using cucumber

	Scenario: Getting Account details with user account-id
		When the client calls GET /Account/1837440
		Then the client receives GET status code of 200
		
	Scenario: Posting a record in Account table
		When the client calls POST /Account 
		Then the client receives POST status code of 201
		
	Scenario: Updating a record in Account table
	  When the client calls PUT /Account/1837440
	  Then the client receives PUT status code of 200
	  
	 Scenario: Deleting a record in Account table
	 	When the client calls DELETE /Account/1839540
	 	Then the client receives DELETE status code of 204
		
		
	
