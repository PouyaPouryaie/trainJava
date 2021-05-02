package lambdatrain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapObjectToAnother {

    public static void main(String[] args){

        Function<GoogleGeoLocation, MyLocation> externalToMyLocation = (googleGeoLocation) -> {
            MyLocation myLocation = new MyLocation();
            myLocation.setCountryCode(Double.valueOf(googleGeoLocation.getHomeMobileCountryCode()));
            myLocation.setNetworkCode(Double.valueOf(googleGeoLocation.getHomeMobileNetworkCode()));
            myLocation.setMyCarrier(googleGeoLocation.getCarrier());
            myLocation.setMyRadioType(googleGeoLocation.getRadioType());
            return myLocation;
        };

/*        Function<GoogleGeoLocation, MyLocation> externalToMyLocation = new Function<GoogleGeoLocation, MyLocation>() {
            @Override
            public MyLocation apply(GoogleGeoLocation googleGeoLocation) {

                MyLocation myLocation = new MyLocation();
                myLocation.setCountryCode(Double.valueOf(googleGeoLocation.getHomeMobileCountryCode()));
                myLocation.setNetworkCode(Double.valueOf(googleGeoLocation.getHomeMobileNetworkCode()));
                myLocation.setMyCarrier(googleGeoLocation.getCarrier());
                myLocation.setMyRadioType(googleGeoLocation.getRadioType());
                return myLocation;
            }
        };*/

        GoogleGeoLocation googleGeoLocation1 = new GoogleGeoLocation(
                310,410,"gsm", "Vodafone");
        GoogleGeoLocation googleGeoLocation2 = new GoogleGeoLocation(
                222,777,"gprs", "Verizon");
        GoogleGeoLocation googleGeoLocation3 = new GoogleGeoLocation(
                111,234,"gsm", "Sprint");
        GoogleGeoLocation googleGeoLocation4 = new GoogleGeoLocation(
                345,567,"gprs", "Us Cell");

        List<GoogleGeoLocation> gLocations = new ArrayList<>();
        gLocations.add(googleGeoLocation1);
        gLocations.add(googleGeoLocation2);
        gLocations.add(googleGeoLocation3);
        gLocations.add(googleGeoLocation4);

        List<MyLocation> myLocations = gLocations.stream().map(externalToMyLocation).collect(Collectors.toList());

        System.out.println(myLocations);

    }

}

class GoogleGeoLocation{
    private Integer homeMobileCountryCode;
    private Integer homeMobileNetworkCode;
    private String radioType;
    private String carrier;


    public GoogleGeoLocation(Integer homeMobileCountryCode,
                             Integer homeMobileNetworkCode, String radioType, String carrier) {
        this.homeMobileCountryCode = homeMobileCountryCode;
        this.homeMobileNetworkCode = homeMobileNetworkCode;
        this.radioType = radioType;
        this.carrier = carrier;
    }

    public Integer getHomeMobileCountryCode() {
        return homeMobileCountryCode;
    }

    public void setHomeMobileCountryCode(Integer homeMobileCountryCode) {
        this.homeMobileCountryCode = homeMobileCountryCode;
    }

    public Integer getHomeMobileNetworkCode() {
        return homeMobileNetworkCode;
    }

    public void setHomeMobileNetworkCode(Integer homeMobileNetworkCode) {
        this.homeMobileNetworkCode = homeMobileNetworkCode;
    }

    public String getRadioType() {
        return radioType;
    }

    public void setRadioType(String radioType) {
        this.radioType = radioType;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
}

class MyLocation{

    private Double countryCode;
    private Double networkCode;
    private String myRadioType;
    private String myCarrier;

    public Double getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Double countryCode) {
        this.countryCode = countryCode;
    }

    public Double getNetworkCode() {
        return networkCode;
    }

    public void setNetworkCode(Double networkCode) {
        this.networkCode = networkCode;
    }

    public String getMyRadioType() {
        return myRadioType;
    }

    public void setMyRadioType(String myRadioType) {
        this.myRadioType = myRadioType;
    }

    public String getMyCarrier() {
        return myCarrier;
    }

    public void setMyCarrier(String myCarrier) {
        this.myCarrier = myCarrier;
    }

    @Override
    public String toString() {
        return "MyLocation{" +
                "countryCode=" + countryCode +
                ", networkCode=" + networkCode +
                ", myRadioType='" + myRadioType + '\'' +
                ", myCarrier='" + myCarrier + '\'' +
                '}';
    }
}