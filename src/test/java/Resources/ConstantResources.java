package Resources;

// enum is the specian class in java which has collection of constant and methods
public enum ConstantResources {

	// This is how we Declare constant method in enum
	// If you have multiple method declare all at once and seperate it by using ','
	// and at the end put ';'
	AddPlace("/maps/api/place/add/json"), DeletePlace("/maps/api/place/delete/json"),
	UpdatePlace("/maps/api/place/update/json"), GetPlace("/maps/api/place/get/json");

	// This is constructor and it can not have any access modifier
	private String resource;

	ConstantResources(String resource) {  // If you want to invoke this construstor from another class then call enumName.valueOf().
		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}

}
