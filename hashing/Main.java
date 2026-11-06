package hashing;

import java.util.HashSet;
import java.util.Set;

public class Main {
    private static int HASH_TABLE_SIZE = 32;

    private static String[] hashTable;

    private static int myHashCode_OLD(String value) {
        int hash = 0;
        for (int i = 0; i < value.length(); i++) {
            hash = (hash * 31) + value.charAt(i);
        }
        return hash & Integer.MAX_VALUE; // Ensure the hash code is non-negative
    }

        private static int myHashCode(String value) {
        int hash = 0;
        for (int i = 0; i < value.length(); i++) {
            hash = (hash << 1) ^ value.charAt(i);
        }
        return hash & Integer.MAX_VALUE; // Ensure the hash code is non-negative
    }

    private static void insert(String value) {
        if (loadFactor() > 0.7) {
            resizeHashTable();
        }

        int hashCode = myHashCode(value) % HASH_TABLE_SIZE;
        if (hashTable[hashCode] == null) {
            hashTable[hashCode] = value;
        } else {
            System.out.println("Collision detected for " + value + " at index " + hashCode);
            // Handle collision (e.g., linear probing, chaining, etc.)
            while (hashTable[hashCode] != null) {
                hashCode = (hashCode + 1) % HASH_TABLE_SIZE; // Linear probing
            }
            hashTable[hashCode] = value;
        }
    }

    private static double loadFactor() {
        int occupiedSlots = 0;
        for (String value : hashTable) {
            if (value != null) {
                occupiedSlots++;
            }
        }
        return (double) occupiedSlots / HASH_TABLE_SIZE;
    }

    private static void resizeHashTable() {
        HASH_TABLE_SIZE *= 2; // Double the size of the hash table
        System.out.println("Resizing hash table to new size: " + HASH_TABLE_SIZE);
        rehash();
    }

    public static void main(String[] args) {
        // Set<Integer> javaHashCodes = new HashSet<>();
        // Set<Integer> myHashCodes = new HashSet<>();

        String[] names = {"Jan", "Piet", "Klaas", "Henk", "Joris", "Sander", "Sjaak", "Herman", "Hugo", "Willem"};
        HASH_TABLE_SIZE = names.length + 1; // Set the hash table size to twice the number of names
        hashTable = new String[HASH_TABLE_SIZE];

        for (String name : names) {
            //int javaHashCode = name.hashCode() % HASH_TABLE_SIZE;
            int myHashCode = myHashCode(name) % HASH_TABLE_SIZE;

            // System.out.println( name + ": " + javaHashCode +", " + myHashCode );
            System.out.println( name + ": " + myHashCode );

            // if (javaHashCodes.contains(javaHashCode)) {
            //     System.out.println("Collision detected for " + name + " with JAVA hash code: " + javaHashCode);
            // } else {
            //     javaHashCodes.add(javaHashCode);
            // }

            insert(name);
            // if (myHashCodes.contains(myHashCode)) {
            //     System.out.println("Collision detected for " + name + " with my hash code: " + myHashCode);
            // } else {
            //     myHashCodes.add(myHashCode);
            // }

            search(name);
        }

        search("Henry");
        delete("Piet");
        search("Henk");
    }

    private static int getHashIndex(String value) {
        int hashCode = myHashCode(value) % HASH_TABLE_SIZE;
        int searchCount = 0; // can we avoid this counting?
        while (searchCount < HASH_TABLE_SIZE
               && hashTable[hashCode] != null 
               && !hashTable[hashCode].equals(value)) {
            hashCode = (hashCode + 1) % HASH_TABLE_SIZE; // Linear probing
            searchCount++;
        }
        return hashCode;
    }


    private static void delete(String string) {
        int hashCode = getHashIndex(string);
        if (hashTable[hashCode] != null && hashTable[hashCode].equals(string)) {
            hashTable[hashCode] = null; // Mark the slot as empty
            System.out.println(string + " deleted from index " + hashCode);
            // Rehashing required for elements that were placed due to collision
            rehash();
        } else {
            System.out.println(string + " not found in the hash table.");
        }
    }

    private static void rehash() {
        String[] oldHashTable = hashTable;
        hashTable = new String[HASH_TABLE_SIZE];
        for (String value : oldHashTable) {
            if (value != null) {
                insert(value);
            }
        }
    }

    private static void search(String name) {
        int hashCode = getHashIndex(name);
        if (hashTable[hashCode] != null && hashTable[hashCode].equals(name)) {
            System.out.println(name + " found at index " + hashCode);
        } else {
            System.out.println(name + " not found in the hash table.");
        }
    }
    
}
