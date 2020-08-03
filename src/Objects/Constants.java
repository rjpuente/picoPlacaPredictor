package Objects;

import javax.swing.*;

public class Constants {

    /*
     * Plate days Type
     */

    public static final char TYPE_MONDAY = 'A';
    public static final char TYPE_TUESDAY = 'B';
    public static final char TYPE_WEDNESDAY = 'C';
    public static final char TYPE_THURSDAY = 'D';
    public static final char TYPE_FRIDAY = 'E';

    /*
     * Plate Numbers
     */
    public static final int PLATE_NUMBER_ZERO = 0;
    public static final int PLATE_NUMBER_ONE = 1;
    public static final int PLATE_NUMBER_TWO = 2;
    public static final int PLATE_NUMBER_THREE = 3;
    public static final int PLATE_NUMBER_FOUR = 4;
    public static final int PLATE_NUMBER_FIVE = 5;
    public static final int PLATE_NUMBER_SIX = 6;
    public static final int PLATE_NUMBER_SEVEN = 7;
    public static final int PLATE_NUMBER_EIGHT = 8;
    public static final int PLATE_NUMBER_NINE = 9;

    /*
     *  Day´s of the week
     */

    public static final String MONDAY = "Monday";
    public static final String TUESDAY = "Tuesday";
    public static final String WEDNESDAY = "Wednesday";
    public static final String THURSDAY = "Thursday";
    public static final String FRIDAY = "Friday";

    /*
     * Hours and minutes for "Pico y placa"
     */

    public static final Integer START_HOUR_AM = 7;
    public static final Integer FINISH_HOUR_AM = 9;
    public static final Integer START_HOUR_PM = 16;
    public static final Integer FINISH_HOUR_PM = 19;
    public static final Integer FINISH_MINUTES = 30;


    /*
     * Weekend message
     */

    public static final String WEEKEND_MESSAGE = "You´re able to road at any hour \n Don´t drink and drive";

    /*
     * Availability messages
     */
    public static final String AVAILABLE = "Your plate number is able to transit on ";
    public static final String NOT_AVAILABLE = "Your plate number is not available to transit";

    /*
     * Field´s length
     */

    public static final int PLATE_NUMBER_LENGTH = 7;
    public static final int YEAR_LENGTH = 4;
    public static final int MONTH_LENGTH = 2;
    public static final int DAY_LENGTH = 2;
    public static final int HOUR_LENGTH = 2;
    public static final int MINUTES_LENGTH = 2;

    /*
     * Required file message
     */

    public static final String REQUIRED_FIELD = "You must fill in the field: ";

    /*
     * Field´s type
     */

    public static String PLATE_TYPE = "License plate";
    public static String YEAR_TYPE = "Year";
    public static String MONTH_TYPE = "Month";
    public static String DAY_TYPE = "Day";
    public static String HOUR_TYPE = "Hour";
    public static String MINUTES_TYPE = "Minutes";

    /*
     * Messages to Option Pane
     */
    public static final String MAX_LENGTH = "Max length surpassed.";
    public static final String ONLY_NUMBERS = "Only numbers allowed.";
    public static final String PLATE_NOT_VALID = "Plate number not valid";
    public static final String YEAR_NOT_VALID = "Wrong year :(";
    public static final String MONTH_NOT_VALID = "Wrong month :(";
    public static final String DAY_NOT_VALID = "Wrong Day :(";
    public static final String HOUR_NOT_VALID = "Hour not valid";
    public static final String MINUTES_NOT_VALID = "Minutes not valid";
    public static final String DOESNT_EXIST = "Pico y placa doesn't exist before 2010";
    public static final String DATE_NOT_VALID = "Ups date typed it´s wrong!";

    public static void showMessage(String text){
        JOptionPane.showMessageDialog(null, text);
    }

}
