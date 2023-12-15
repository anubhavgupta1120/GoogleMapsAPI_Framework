package StepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.runner.RunWith;
import PayloadFile.Payload;
import Resources.CommonUtils;
import Resources.ConstantResources;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@RunWith(Cucumber.class)
public class SD_1 extends CommonUtils {

	RequestSpecification Given;
	Response response;
	static List<String> placeId = new ArrayList<>();

	@Given("^Add Place PayLoad with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void add_place_pay_load_with(String name, String language, String address, String phoneNumber)
			throws IOException {
		Given = given().spec(RequestSpecification())
				.body(Payload.AddPlacePayload(name, language, address, phoneNumber));
	}

	@When("^User calls \"([^\"]*)\" API with \"([^\"]*)\" Http request$")
	public void user_calls_api_with_http_request(String APICall, String APIMethod) {
		ConstantResources resources = ConstantResources.valueOf(APICall);
		if (APIMethod.equalsIgnoreCase("Post")) {
			response = Given.when().post(resources.getResource()).then().extract().response();
		}
		if (APIMethod.equalsIgnoreCase("Get")) {
			response = Given.when().get(resources.getResource()).then().extract().response();
		}
		if (APIMethod.equalsIgnoreCase("Put")) {
			response = Given.when().put(resources.getResource()).then().extract().response();
		}
		if (APIMethod.equalsIgnoreCase("Delete")) {
			response = Given.when().delete(resources.getResource()).then().extract().response();
		}
	}

	@Then("^The API call got success with status code \"([^\"]*)\"$")
	public void the_api_call_got_success_with_status_code(String statusCode) {
		assertEquals(String.valueOf(response.getStatusCode()), statusCode);
		placeId.add(getJsonData(response, "place_id"));
	}

	@Then("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	public void in_response_body_is(String Key, String val) {
		String actualVal = getJsonData(response, Key);
		assertEquals(actualVal, val);
	}

	@And("^Verify Place_Id created maps to \"([^\"]*)\" using \"([^\"]*)\" API$")
	public void verify_placeid_created_maps_to_something_using_something_api(String Actualname, String APICall)
			throws Throwable {
		Given = given().spec(RequestSpecification()).queryParam("place_id", placeId.get(placeId.size()-1));
		user_calls_api_with_http_request(APICall, "Get");
		String Expectedname = getJsonData(response, "name");
		assertEquals(Expectedname, Actualname);
	}
	
	@Given("^Delete Place Payload$")
	public void delete_place_payload() throws IOException {
			Given = given().spec(RequestSpecification()).body(Payload.DeletePlacePayload(placeId.get(0)));		
	}

}
