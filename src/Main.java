package algojava;

import java.util.Scanner;
import java.time.LocalDate;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {

        System.out.println("Input array size");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 1)
            return;

        n = Math.min(n, 100000);
        System.out.printf("Array size: %d\n", n);

        EventsSortInterface sortInterface = new EventsSortInterface();
        String[] sortFields = new String[] {"x", "y", "z", "date"};
        String[] sortFunctions = 
        new String[] {
            "myBasicQuickSort", 
            "myAdvancedQuickSort",
            "standartJavaSort"
        };

        sortInterface.SetRandom(n);


        for(int i = 0; i < sortFunctions.length; i++) {
            System.out.printf("%s\n", sortFunctions[i]);
            for (int j = 0; j < sortFields.length; j++) {
                sortInterface.SortByField(sortFields[j], sortFunctions[i]);
                sortInterface.printSortStatus(sortFields[j]);
                sortInterface.reset();
            }
        }
    }
}
