Feature: Validating the PlaceAPI
@AddPlace
Scenario Outline: Verify if Place is being Successfully added using 
		Given Add Place PayLoad with "<name>" "<language>" "<address>" "<PhoneNumber>"
		When User calls "AddPlace" API with "Post" Http request
		Then The API call got success with status code "200"
		And "status" in response body is "OK"
		And "scope" in response body is "APP"
		And Verify Place_Id created maps to "<name>" using "GetPlace" API
		
		Examples:
	  | name 				 | language  | address 																					  | PhoneNumber |
		|Anubhav Gupta |Hindi 		 |Amestredam House, Eletronic City, Phase 1, Banglore |7078466107   |	
#		|Deepanshi Garg|Hindi 		 |Sector 15, Gurgaon																  |7451087847   | 
#		|Gaurav 			 |Hindi 		 |Wakad, Pune																				  |7451046310   | 
		
@DeletePlace
Scenario: Verify if Delete Place API
		 Given Delete Place Payload
		 When User calls "DeletePlace" API with "Delete" Http request
		 Then The API call got success with status code "200"
		 And "status" in response body is "OK"
		
