package algojava;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Event implements Comparable<Event> {
    private Float x, y, z;
    private LocalDate recordTime;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public Float x() {
        return x;
    }

    public Float y() {
        return y;
    }

    public Float z() {
        return z;
    }

    public LocalDate recordTime() {
        return recordTime;
    }

    public Event(float x, float y, float z, LocalDate recordTime) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.recordTime = recordTime;
    }

    public Event copy() {
        return new Event(
            this.x,
            this.y,
            this.z,
            this.recordTime
        );
    }

    @Override
    public String toString() {
        return String.format("%f %f %f (%s)", x, y, z, recordTime.format(dateFormatter));
    }

    @Override
    public int compareTo(Event o) {
        int cmp = recordTime.compareTo(o.recordTime);
        return cmp;
    }
}