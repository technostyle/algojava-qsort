package algojava;

import java.util.Comparator;

public class EventComparator implements Comparator<Event> {

    private int count;
    private String compField;

    public int getComparationsCount() {
        return count;
    }

    public String getCompField() {
        return compField;
    }

    public void setComparationField(String field) {

        if (field.equals(this.compField)) {
            return;
        }

        switch(field) {
            case "x":
            case "y":
            case "z":
                this.compField = field;
                break;
            default:
                this.compField = "date";
        }
        reset();
    }

    public void reset() {
        count = 0;
    }

    private int compareEvents(Event o1, Event o2) {
        int cmp = 0;

        switch(compField) {
            case("x"):
                cmp = o1.x().compareTo(o2.x());
                break;
            case("y"):
                cmp = o1.y().compareTo(o2.y());
                break;
            case("z"):
                cmp = o1.z().compareTo(o2.z());
                break;
            default:
                cmp = o1.compareTo(o2);
        }

        return cmp;
    }

    public EventComparator() {
        super();
    }

    @Override
    public int compare(Event o1, Event o2) {
        count++;
        return compareEvents(o1, o2);
    }
}
