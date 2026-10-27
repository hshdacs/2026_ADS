import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.management.RuntimeErrorException;

public class Main {
    private static final int ARRAY_SIZE = 52;
    private static final int ELEMENT_RANGE = 25;
    private static final int ELEMENT_BIAS = 0;
    private static final int ELEMENT_TO_SEARCH = 17;

    private static int number_of_processing_steps = 0;

    private static int[] array = new int[ARRAY_SIZE];

    // Searching: Linear search
    private static boolean linear_search(int element_to_search) {
        for (int element : array) {
            number_of_processing_steps++;
            if (element == element_to_search)
                return true;
        }
        return false;
    }

    // Searching: Linear search: Minimum
    private static int search_minimum() {
        assert(array.length > 0); // or
        if (array.length == 0)
            throw new RuntimeException("Array is empty!");

        int minimum_element = array[0];
        for (int element : array) {
            number_of_processing_steps++;
            if (element < minimum_element) {
                minimum_element = element;
            }
        }
        return minimum_element;
    }

    // Searching: Linear search: Maximum
    private static int search_maximum() {
        // TODO
        return array[0];
    }

    // Searching: Linear search: Second Maximum
    private static int search_second_maximum() {
        // TODO
        return array[0];
    }

    // Searching: Binary Search Recursive Helper
    private static boolean binary_search_rec(int element_to_search,
        int start_index, int last_index) {
        int middle = start_index + (last_index - start_index) / 2;
//        number_of_processing_steps++;
        if (last_index < start_index) return false;
        number_of_processing_steps++;
        if (array[middle] == element_to_search)
            return true;
        else {
//            number_of_processing_steps++;
            if (array[middle] > element_to_search)
                return binary_search_rec(element_to_search, start_index, middle-1);
            else
                return binary_search_rec(element_to_search, middle+1, last_index);
        }
    }

    // Searching: Binary search (recursive)
    private static boolean binary_search(int element_to_search) {
        Arrays.sort(array); // for the moment
        return binary_search_rec(element_to_search, 0, array.length-1);
    }

    private static boolean binary_search_iterative(int element_to_search) {
        Arrays.sort(array); // for the moment
        // TODO
        return false;
    }

    // Searching: Binary search (insertion point)
    private static int binary_search_insertion_point(int element_to_search) {
        Arrays.sort(array); // for the moment
        // magic starts here
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            print_partial_array(array, left, right);
            number_of_processing_steps++;
            int middle = left + (right - left) / 2;
            if (array[middle] == element_to_search)
                return middle;
            if (array[middle] > element_to_search)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        randomize_array(array);
        print_array(array);

        reset_number_of_processing_steps();
        //boolean success = linear_search(ELEMENT_TO_SEARCH);
        //boolean success = binary_search(ELEMENT_TO_SEARCH);
        int insertion_point = binary_search_insertion_point(ELEMENT_TO_SEARCH);
        //int min_element = search_minimum();
        print_number_of_processing_steps();

        //System.out.println( success ? "Found" : "Not in there" );
        //System.out.println("Minimum found is " + min_element);

        System.out.println("Insertion point is " + insertion_point);
        print_array(array, insertion_point);
    }

    private static void print_number_of_processing_steps() {
        System.out.println("Number of processing steps: " + 
            number_of_processing_steps);
    }

    private static void reset_number_of_processing_steps() {
        number_of_processing_steps = 0;
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