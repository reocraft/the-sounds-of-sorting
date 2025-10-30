package edu.grinnell.csc207.soundsofsorting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;
import edu.grinnell.csc207.soundsofsorting.sorts.Sorts;

public class SortsTests {
    /**
     * @param <T> the carrier type of the array
     * @param arr the array to check
     * @return true iff <code>arr</code> is sorted.
     */
    public static <T extends Comparable<? super T>> boolean sorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] makeTestArray() {
        return new Integer[] {
            3, 7, 9, 1, 2,
            18, 16, 15, 19, 8,
            14, 12, 5, 13, 4,
            6, 0, 17, 11, 10
        };
    }

    public void testSort(Consumer<Integer[]> func) {
        Integer[] arr = makeTestArray();
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    @Test
    public void testBubbleSort() {
        testSort(Sorts::bubbleSort);
    }
    
    @Test
    public void testInsertionSort() {
        testSort(Sorts::insertionSort);
    }
    
    @Test
    public void testSelectionSort() {
        testSort(Sorts::selectionSort);
    }

    @Test
    public void testMergeSort() {
        testSort(Sorts::mergeSort);
    }
    
    @Test
    public void testQuickSort() {
        testSort(Sorts::quickSort);
    }

    @Test
    public void testEventSort() {
        testSort(Sorts::eventSort);
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 2, 8, 1, 3};

        // Run mergeSort
        List<SortEvent<Integer>> lst = Sorts.selectionSort(arr);

        // Print out all the events
        for (SortEvent<Integer> l : lst) {
            System.out.println(l);
        }

        // Apply all the events to a fresh copy of the array
        Integer[] arr2 = {5, 2, 8, 1, 3};
        for (SortEvent<Integer> l : lst) {
            l.apply(arr2);
        }

        System.out.println("After applying events: " + Arrays.toString(arr2));

        // Optional: compare to fully sorted array
        Integer[] expected = {1, 2, 3, 5, 8};
        System.out.println("Sorted correctly? " + Arrays.equals(arr2, expected));
    }
}