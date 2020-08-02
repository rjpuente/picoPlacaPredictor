package Objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Predictor {

    private static  final char PAR = 'P';
    private static  final char IMPAR = 'I';

    private String licensePlate;
    private String year;
    private String month;
    private String day;

    private Integer lastDigit;
    private List<String> availableDays;


    public Predictor(String licensePlate, String year, String month, String day) {
        this.licensePlate = licensePlate;
        this.year = year;
        this.month = month;
        this.day = day;
        this.lastDigit = getLastDigit(licensePlate);
        this.availableDays = new ArrayList<>();
    }

    private String verifyAvailability() {
        Character type = getEvenOrOdd(lastDigit);

        return "";
    }

    private List<String> availabilityForPlateNumber(Character type){
        switch (type){
            case PAR:
                break;
            case IMPAR:
                break;
        }
        return availableDays;
    }

    private Integer getLastDigit(String licensePlate) {
        String lastDigitText = String.valueOf(licensePlate.charAt(licensePlate.length() - 1));
        return Integer.parseInt(lastDigitText);
    }

    private Character getEvenOrOdd(Integer lastDigit) {
        if (lastDigit % 2 == 0) {
            return PAR;
        } else {
            return IMPAR;
        }
    }
}
