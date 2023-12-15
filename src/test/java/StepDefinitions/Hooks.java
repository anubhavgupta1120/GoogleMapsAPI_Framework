package StepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	@Before("@DeletePlace")
	public void run() throws IOException {
		if (SD_1.placeId.isEmpty() || SD_1.placeId == null) {
			SD_1 sd = new SD_1();
			sd.add_place_pay_load_with("Anchal", "English", "Noida", "7654329871");
			sd.user_calls_api_with_http_request("AddPlace", "Post");
			sd.the_api_call_got_success_with_status_code("200");
		}

	}

}
