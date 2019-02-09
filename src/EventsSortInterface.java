package algojava;

import java.util.Scanner;
import java.util.Random;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class EventsSortInterface {

    private Event[] events;
    private Event[] auxEvents;
    private int size;
    private EventComparator cmp;
    private int lastSortComparationsCount;
    private SortInterface<Event> sortInterface;

    public EventsSortInterface() {
        this.cmp = new EventComparator();
        this.sortInterface = new SortInterface<Event>();
    }

    public void SetRandom(int size) {

        if (size <= 0) {
            return;
        }

        this.size = size;
        this.events = new Event[size];
        this.auxEvents = new Event[size];
        RandomEvent random = new RandomEvent();

        for (int i = 0; i < size; i++) {
            this.events[i] = random.nextEvent();
            this.auxEvents[i] = this.events[i].copy();
        }
    }

    public void PrintAuxArray() {
        for (int i = 0; i < auxEvents.length; i++) {
            System.out.printf("%s\n", auxEvents[i]);
        }
    }

    public boolean isSorted(String field) {
        cmp.setComparationField(field);
        boolean isSorted = true;

        for(int i = 1; i < auxEvents.length; i++) {
            if (cmp.compare(auxEvents[i - 1], auxEvents[i]) > 0) {
                isSorted = false;
                break;
            }
        }

        return isSorted;
    }

    public void printSortStatus(String field) {
        System.out.printf(
            "Field: %s Sorted: %b Comparations: %d\n", 
            field, isSorted(field), lastSortComparationsCount
        );
    }

    public int getLastSortComparationsCount() {
        return lastSortComparationsCount;
    }

    public void reset() {
        this.cmp.reset();
        for(int i = 0; i < events.length; i++)
            auxEvents[i] = events[i].copy();
    }

    public void SortByField(String field, String method) {

        cmp.setComparationField(field);
        switch(method) {
            case "myBasicQuickSort":
                sortInterface.myBasicQuickSort(auxEvents, cmp);
                break;
            case "myAdvancedQuickSort":
                sortInterface.myAdvancedQuickSort(auxEvents, cmp);
                break;
            default:
                sortInterface.standartJavaSort(auxEvents, cmp);
        }

        this.lastSortComparationsCount = cmp.getComparationsCount();
    }
}