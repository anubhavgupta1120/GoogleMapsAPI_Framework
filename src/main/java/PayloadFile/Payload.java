package PayloadFile;

import java.util.List;

import Pojo.GooglePlaceAPI.AddPlaceReq;
import Pojo.GooglePlaceAPI.DeletePlaceReq;
import Pojo.GooglePlaceAPI.Locations;

public class Payload {

	public static AddPlaceReq AddPlacePayload(String name, String language, String address, String PhoneNumber) {
		AddPlaceReq addPlace = new AddPlaceReq();
		Locations location = new Locations();
		location.setLat(44.0);
		location.setLng(30);
		addPlace.setAccuracy(40);
		addPlace.setAddress(address);
		addPlace.setPhone_number(PhoneNumber);
		addPlace.setWebsite("http://google.com");
		addPlace.setLanguage(language);
		addPlace.setName(name);
		addPlace.setTypes(List.of("Shoes", "Books"));
		addPlace.setLocation(location);
		return addPlace;
	}
	
	public static DeletePlaceReq DeletePlacePayload(String placeId) {
		DeletePlaceReq deletePlace = new DeletePlaceReq();
		deletePlace.setPlace_id(placeId);
		return deletePlace;
	}

}
