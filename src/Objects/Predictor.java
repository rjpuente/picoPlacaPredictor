package Objects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Predictor {

    private static final Character ROJO = 'R';
    private static final Character YELOW = 'Y';
    private static final Character GREEN = 'G';

    private String licensePlate;
    private String year;
    private String month;
    private String day;

    private Character lastDigit;
    private Map<String, String> availableList;



    public Predictor(String licensePlate, String year, String month, String day) {
        this.licensePlate = licensePlate;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void predict(){
        this.lastDigit = getPlateLastNumber(licensePlate);
    }

    private Character getPlateLastNumber(String licensePlate) {
        return licensePlate.charAt(licensePlate.length() - 1);
    }

    private String verifyAvailability(){
        availableList = new HashMap<>();
        switch (lastDigit){
            case '0':
                availableList.put("","");
                break;
            case '1':
                break;
            case '2':
                break;
            case '3':
                break;
            case '4':
                break;
            case '5':
                break;
            case '6':
                break;
            case '7':
                break;
            case '8':
                break;
            case '9':
                break;
        }
        return "";
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Character getLastDigit() {
        return lastDigit;
    }

    public void setLastDigit(Character lastDigit) {
        this.lastDigit = lastDigit;
    }
}
