import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.management.RuntimeErrorException;

public class Main {
    private static final int ARRAY_SIZE = 52;
    private static final int ELEMENT_RANGE = 25;

    private static int number_of_processing_steps = 0;

    private static int[] array = new int[ARRAY_SIZE];

    // Searching: Linear search
    private static boolean search(int element_to_search) {
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

    // Searching: Linear search: Minimum
    private static int search_maximum() {
        // TODO
        return array[0];
    }

    public static void main(String[] args) {
        randomize_array(array);
        print_array(array);

        reset_number_of_processing_steps();
        //boolean success = search(17);
        int min_element = search_minimum();
        print_number_of_processing_steps();

        //System.out.println( success ? "Found" : "Not in there" );
        System.out.println("Minimum found is " + min_element);
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

    private static void randomize_array(int[] array) {
        // what is the difference btw "int" and "Integer"
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * ELEMENT_RANGE) - ELEMENT_RANGE/2;
        }
    }
}