package sportmateinc.sportmatebusinesslayer.entity;

public class Location {
    private int id;
    private String country;
    private String city;
    private String place;
    private double latitude;
    private double longitude;

    public Location(int id, String country, String city, String place, double latitude, double longitude) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.place = place;
        this.latitude = latitude;
        this.longitude = longitude;

    }

    @Override
	public String toString() {
		return "Location [id=" + id + ", country=" + country + ", city=" + city + ", place=" + place + ", latitude="
				+ latitude + ", longitude=" + longitude + "]";
	}

	public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getPlace() {
        return place;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

}
