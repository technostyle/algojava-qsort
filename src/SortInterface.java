package algojava;

import java.util.Arrays;
import java.util.Comparator;

public class SortInterface<T> {

    private Comparator<T> cmp;

    private void swap(T[] a, int i, int j) {
        T t;
        t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void myBasicQuickSort(T[] array, Comparator<T> cmp) {
        this.cmp = cmp;
        basicQuickSort(array, 0, array.length);
    }

    public void myBasicQuickSort(T[] array) {
        basicQuickSort(array, 0, array.length);
    }

    public void myAdvancedQuickSort(T[] array, Comparator<T> cmp) {
        this.cmp = cmp;
        advancedQuickSort(array, 0, array.length - 1);
    }

    public void standartJavaSort(T[] array, Comparator<T> cmp) {
        Arrays.sort(array, this.cmp);
    }

    private void basicQuickSort(T[] a, int left, int right) {

        if (right - left <= 1)
            return;

        T pivot = a[left];
        int i = left, j = right - 1;

        while (i < j) 
        {
            while (cmp.compare(a[i], pivot) < 0 && i < j)
                i++;

            while (cmp.compare(a[j], pivot) >= 0 && j > i)
                j--;

            if (i != j)
                swap(a, i, j);
        }

        if (i == left)
            i++;

        basicQuickSort(a, left, i);
        basicQuickSort(a, i, right);
    }

    private T medianOfTree(T a, T b, T c) {

        T med = a;
        if (
            (cmp.compare(a, b) <= 0 && cmp.compare(b, c) <= 0) ||
            (cmp.compare(c, b) <= 0 && cmp.compare(b, a) <= 0)
        ) {
            med = b;
        } else if (
            (cmp.compare(a, c) <= 0 && cmp.compare(c, b) <= 0) ||
            (cmp.compare(b, c) <= 0 && cmp.compare(c, a) <= 0)
        ) {
            med = c;
        }

        return med;
    }

    private void advancedQuickSort(T[] a, int left, int right) {

        int lenght = right - left + 1;

        if (lenght <= 1)
            return;

        if (lenght == 2) {
            if (cmp.compare(a[left], a[right]) > 0) 
                swap(a, left, right);
            return;
        }

        int middle = (left  + right) / 2;
        T med = medianOfTree(a[left], a[middle], a[right]);

        if (med == a[middle])
            swap(a, left, middle);
        else if (med == a[right])
            swap(a, left, right);

        int lt = left, gt = right;
        T pivot = a[left];
        int i = left + 1;
        while(i <= gt) {
            int c = cmp.compare(a[i], pivot);
            if      (c < 0) swap(a, lt++, i++);
            else if (c > 0) swap(a, i, gt--);
            else            i++;
        }

        advancedQuickSort(a, left, lt - 1);
        advancedQuickSort(a, gt + 1, right);
    }
}