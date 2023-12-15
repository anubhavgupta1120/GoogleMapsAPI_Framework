package Resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonUtils {
	private static RequestSpecification request;

	public RequestSpecification RequestSpecification() throws IOException {
		if (request == null) {
			PrintStream log = new PrintStream(new FileOutputStream("LogFiles/Logging.txt"));
			request = new RequestSpecBuilder().setBaseUri(getGlobalData("BaseUrl")).addQueryParam("key", "qaclick123")
					.setContentType(ContentType.JSON).addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
			return request;

		}
		return request;

	}

	public String getGlobalData(String Key) throws IOException {
		Properties properties = new Properties();
		FileInputStream FIS = new FileInputStream(
				"/Users/anubhavgupta/Documents/eclipse-workspace(Java)/GoogleMapsAPI_Framework/src/test/java/Resources/GlobalData.properties");
		properties.load(FIS);
		return properties.getProperty(Key);
	}
	
	public String getJsonData(Response response, String key) {
		String res = response.asString();
		JsonPath jsonPath = new JsonPath(res);
		return jsonPath.getString(key);
	}

}
