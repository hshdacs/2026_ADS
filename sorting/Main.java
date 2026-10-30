package sorting;

import java.util.Arrays;

public class Main {
    public interface MyIntComperator {
        int compare(int a, int b);
    }

    private static final int ARRAY_SIZE = 100;
    private static final int ELEMENT_RANGE = 90;
    private static final int ELEMENT_BIAS = -10;

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

    private static int search_minimum_pos(int[] array, int start_pos) {
        int minimum_element_pos = start_pos;
        for (int i = start_pos + 1; i < array.length; i++) {
            if (array[i] < array[minimum_element_pos]) {
                minimum_element_pos = i;
            }            
        }
        return minimum_element_pos;
    }

    // Selection Sort
    private static void selection_sorting(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int min_el_pos = search_minimum_pos(array, i);
            processing_steps += array.length;
            swap(array, i, min_el_pos);   
        }
    }

    // Insertion Sort
    private static void insertion_sorting(int[] array) {
        for (int i = 1; i < array.length; i++) {
            //array[0] is alread sorted
            int element = array[i];
            // check alread sorted list
            int j = i;
            while (j > 0 && array[j-1] > element) {
                processing_steps++;
                array[j] = array[j-1]; // we can also use swap(j, j-1)
                --j;
            }
            processing_steps++;
            array[j] = element; // j is our correct insert position
            //print_partial_array(array, 0, i);
        }
    }

    private static void qsort(int[] array, int left, int right) {
        if (left >= right) return;
 
        // pick an element which represents the medium of all values
        //int middle = array[ (left + right) / 2 ];
        int middle = array[ left ];

        // seperating the both lists
        int left_index = left;
        int right_index = right;
        while (left_index < right && array[left_index] < middle) {
            processing_steps++;
            left_index++;
        }
        while (right_index > left && array[right_index] > middle) {
            processing_steps++;
            right_index--;
        }
        if (left_index <= right_index) {
            swap(array, left_index, right_index);
            left_index++;
            right_index--;
        }

        // sorting both lists with its new elements
        if ( right_index > left ) qsort(array, left, right_index);
        if ( left_index < right ) qsort(array, left_index, right);
    }

    private static void quick_sorting(int[] array) {
        qsort(array, 0, array.length-1);
    }

    private static void merge(int[] array, int left, int middle, int right) {
        // create some helper memory to hold original data
        int[] h1 = new int[middle-left+1];
        int[] h2 = new int[right-middle];

        // copy original data to our temporary space
        for (int i = left; i <= middle; i++) h1[i-left] = array[i];
        for (int i = middle+1; i <= right; i++) h2[i-middle-1] = array[i];

        // now do merging by selecting the next smallest element
        for (int k=left, i=0, j=0; k <= right; k++) {
            processing_steps++;
            if (i >= h1.length)      array[k] = h2[j++];
            else if (j >= h2.length) array[k] = h1[i++];
            else if (h1[i] <= h2[j]) array[k] = h1[i++];
            else                     array[k] = h2[j++];
        }
    }

    private static void msort(int[] array, int left, int right) {
        if (left >= right) return;

        int split_position = (left + right) / 2;
        msort(array, left, split_position);
        msort(array, split_position+1, right);
        merge(array, left, split_position, right);
    }

    private static void merge_sorting(int[] array) {
        msort(array, 0, array.length-1);
    }

    public static void main(String[] args) {
        int[] array = new int[ARRAY_SIZE];
        randomize_array(array);
        advanced_sorting(array, (a, b) -> b - a);
        print_array(array);
        reset_processing_steps();
        merge_sorting(array);
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