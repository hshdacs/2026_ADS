package sorting;

import java.util.Arrays;

public class Main {
    public interface MyIntComperator {
        int compare(int a, int b);
    }

    private static final int ARRAY_SIZE = 52;
    private static final int ELEMENT_RANGE = 1000;
    private static final int ELEMENT_BIAS = 0;

    private static int processing_steps = 0;

    private static void swap(int[] array, int pos1, int pos2) {
        int tmp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = tmp;
    }

    // an advanced version of bubble sort
    private static void advanced_sorting(int[] array, MyIntComperator comperator) {
        boolean isUnsorted = true;
        while (isUnsorted) { 
            isUnsorted = false;
            for (int i = 1; i < array.length; i++) {
                if (comperator.compare(array[i-1], array[i]) < 0) {
                    swap(array, i-1, i);
                    isUnsorted = true;
                }
            }
        }
    }

    // Bubble Sort
    private static void bubble_sorting(int[] array) {
        boolean isUnsorted = true;
        while (isUnsorted) { 
            isUnsorted = false;
            for (int i = 1; i < array.length; i++) {
                processing_steps++;
                if (array[i-1] > array[i]) {
                    swap(array, i-1, i);
                    isUnsorted = true;
                }
            }
        }
    }

    private static void sorting(int[] array) {
        
    }


    public static void main(String[] args) {
        int[] array = new int[ARRAY_SIZE];
        randomize_array(array);
        advanced_sorting(array, (a, b) -> b - a);
        print_array(array);
        reset_processing_steps();
        bubble_sorting(array);
        print_processing_steps();
        print_array(array);
        System.out.println( isArraySorted(array) ? "Sorted" : "UNSORTED");
    }

    private static void reset_processing_steps() {
        processing_steps = 0;
    }

    private static void print_processing_steps() {
        System.out.println(":: " + processing_steps);
    }

    private static boolean isArraySorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i-1] > array[i])
                return false;
        }
        return true;
    }

    private static void print_array(int[] array) {
        System.out.println(
            Arrays.toString(array)
            );
    }

    private static void print_partial_array(int[] array, int left, int right) {
        System.out.print("[");
        for (int i = left; i <= right; i++) {
            if (i > left) System.out.print(", ");
            System.out.print(array[i]);
        }
        System.out.println("], " + left + ", " + right);
    }

    private static void print_array(int[] array, int index_marker) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(array[i]);
            if (i == index_marker) System.out.print("*");
        }
        System.out.println("]");
    }

    private static void randomize_array(int[] array) {
        // what is the difference btw "int" and "Integer"
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * ELEMENT_RANGE) - ELEMENT_BIAS;
        }
    }
}