package algojava;

import java.util.Random;
import java.util.Calendar;
import java.time.LocalDate;

public class RandomEvent extends Random {

    private Random random;
    private int minYear, curYear;

    public RandomEvent() {
        Calendar calendar = Calendar.getInstance();
        curYear = calendar.get(Calendar.YEAR);
        minYear = 1900;

        random = new Random();
    }

    private int randomIntBetween(int from, int to) {
        return random.nextInt(to - from) + from;
    }

    private LocalDate nextDate() {
        return LocalDate.of(
            randomIntBetween(minYear, curYear),
            randomIntBetween(1, 12),
            randomIntBetween(1, 28)
        );
   }
    protected Event nextEvent() {
        return new Event(
            random.nextFloat(),
            random.nextFloat(),
            random.nextFloat(),
            nextDate()
        );
   }
}