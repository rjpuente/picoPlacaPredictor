package Objects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Predictor {

    private String availability;
    private final String dayOfTheWeek;
    //List of license plates availables
    private final List<Integer> availablePlatesList;


    public Predictor(String licensePlate, String dateText, Integer hour, Integer minutes) {
        availability = "";
        availablePlatesList = new ArrayList<>();
        Integer lastDigit = getLastDigit(licensePlate);
        this.dayOfTheWeek = getDayOfTheWeek(dateText);
        getAvailabilityFromDay();
        if (getPlateNumberAvailability(lastDigit)) {
            getTimeAvailability(hour, minutes);
        } else {
            availability = Constants.AVAILABLE + dayOfTheWeek;
        }
    }

    private void getAvailabilityFromDay() {
        switch (dayOfTheWeek) {
            case Constants.MONDAY:
                fillAvailablePlateNumbersList(Constants.TYPE_MONDAY);
                break;
            case Constants.TUESDAY:
                fillAvailablePlateNumbersList(Constants.TYPE_TUESDAY);
                break;
            case Constants.THURSDAY:
                fillAvailablePlateNumbersList(Constants.TYPE_THURSDAY);
                break;
            case Constants.WEDNESDAY:
                fillAvailablePlateNumbersList(Constants.TYPE_WEDNESDAY);
                break;
            case Constants.FRIDAY:
                fillAvailablePlateNumbersList(Constants.TYPE_FRIDAY);
                break;
            default:
                availability = Constants.WEEKEND_MESSAGE;
                break;
        }
    }

    private void fillAvailablePlateNumbersList(Character type) {
        switch (type) {
            case Constants.TYPE_MONDAY:
                availablePlatesList.addAll(Arrays.asList(Constants.PLATE_NUMBER_ONE, Constants.PLATE_NUMBER_TWO));
                break;
            case Constants.TYPE_TUESDAY:
                availablePlatesList.addAll(Arrays.asList(Constants.PLATE_NUMBER_THREE, Constants.PLATE_NUMBER_FOUR));
                break;
            case Constants.TYPE_WEDNESDAY:
                availablePlatesList.addAll(Arrays.asList(Constants.PLATE_NUMBER_FOUR, Constants.PLATE_NUMBER_FIVE));
                break;
            case Constants.TYPE_THURSDAY:
                availablePlatesList.addAll(Arrays.asList(Constants.PLATE_NUMBER_SIX, Constants.PLATE_NUMBER_SEVEN));
                break;
            case Constants.TYPE_FRIDAY:
                availablePlatesList.addAll(Arrays.asList(Constants.PLATE_NUMBER_EIGHT, Constants.PLATE_NUMBER_NINE));
                break;
        }
    }

    private Boolean getPlateNumberAvailability(Integer lastDigit) {
        return availablePlatesList.contains(lastDigit);
    }

    private void getTimeAvailability(Integer hour, Integer minutes) {
        if ((hour >= Constants.START_HOUR_AM && hour <= Constants.FINISH_HOUR_AM)
                || (hour >= Constants.START_HOUR_PM && hour <= Constants.FINISH_HOUR_PM)
                && (minutes <= Constants.FINISH_MINUTES)) {
            availability = Constants.NOT_AVAILABLE;
        } else {
            availability = Constants.AVAILABLE + dayOfTheWeek;
        }
    }

    private String getDayOfTheWeek(String dateText) {
        Date date;
        String dayOfTheWeek = "";
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(dateText);
            dayOfTheWeek = new SimpleDateFormat("EEEEE", Locale.ENGLISH).format(date);
        } catch (ParseException pe) {
            pe.printStackTrace();
            Constants.showMessage(Constants.DATE_NOT_VALID);
        }
        return dayOfTheWeek;
    }

    private Integer getLastDigit(String licensePlate) {
        String lastDigitText = String.valueOf(licensePlate.charAt(licensePlate.length() - 1));
        return Integer.parseInt(lastDigitText);
    }

    public String getAvailability() {
        return availability;
    }
}
