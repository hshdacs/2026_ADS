# Data Structures

## Elementary Data Types
- Boolean (True/False - Non Zero / Zero - 1 Bit)
- Byte / Character (8 Bit, Char *C/C++)
- Short (16 Bit)
- Character (16 Bit *Java)
- Wide Char (16 Bit, wchar_t C/C++)
- Integer (32 Bit)
- Long (64 Bit)
- Float (32 Bit)
    - Compound type
    - Sign (1 Bit)
    - Exponent (8 Bit)
    - Mantisse (23 Bit -> 24 Bit for precision)
- Double (64 Bit)
    - Compound type
    - Sign (1 Bit)
    - Exponent (11 Bit)
    - Mantisse (52 Bit)
- Reference

## Compound Data Types

- Structures
- Record
- Dataset
- Class / Object

These extended data sets are represented as references in most PL (Java), some can store the element itself (C/C++)

## Array

- fundamental data type (built in in most PL)
- aka field, vector
- must be one of the above data types
- need to be acquired of memory storage (at compile time = static, at runtime = dynamic)
- basic operations
    - read / get (using numerical index)
    - write / set
    - create (**new**)
    - dispose / destroy (**delete**)
- in most PL zero based

## (Array) List

- Collection of ordered data
- typically dynamic (not of fixed size)
- sometime internally realized as an array, but reveales the reference
- basic operations
    - write / set (add, append, insert)
    - read / get (index like an array [])
    - delete / remove
    - clear
    - size / length
    - isEmpty
    - extend / shrink (sometimes not accessable)
        - typically doubling the capacity
        - sometimes with thresholds for +100%, +50%, ...
- advanced operations (algorithm section)
    - contains / search / find
    - sort
    - iterator
    - map / filter / forEach

## Linked List

- saving element with the information of its successor
- Node
```mermaid
    block-beta
        block
            Reference_to_next_element
            The_data_element
        end
  ```
- if there is no next element, then NIL/NULL is set
- we nee a reference to the first element (HEAD, ROOT)
- basic operations
    - write / set (add, append, insert)
        - create a new node
        - find last element and set next reference to current element
        - maybe store last element to speed up
        - insert at the beginning is very fast
    - read / get (index like an array [])
        - accessing by index we need to iterate by counting the elements
    - delete / remove
        - we need the element first, see read
        - removing just need to rewire the next reference
    - clear
        - clean up all nodes
    - size / length
    - isEmpty

Example
```mermaid
flowchart LR
   A["Head"] --> B["Node 1"]
   B --> C["Node 2"]
   C --> D["Node 3"]
   D --> E["NULL"]
 ```

Comparison Array (List) and Linked (List)
| Operation | Array | Linked List |
|-|-|-|
| create (insert) | slow O(n) | fast O(1) |
| read | fast O(1) | slow O(n) |
| update | fast | slow |
| delete | slow | fast |
| Memory | just the data | extra reference needed |

## Double Linked List

- Node
```mermaid
block-beta
        block
            Reference_to_next_element
            Reference_to_previous_element
            The_data_element
        end
  ```
- typically there are references to the first element (head, first), and last element (tail, last)
- easy of iterating from to front to last, and last to front
- also easy in deleting an element in the middle

### XOR Double Linked List

- Node
```mermaid
    block-beta
        block
            XOR_Reference_to_next/previous_element
            The_data_element
        end
  ```
- Storing an element means, XORing the previous and next reference as our XOR reference
- Getting the next element, XORing the previous reference
- Getting the previous element, XORing the next reference
- But not possible to get next or previous of a random element
- see [Wikipedia](https://en.wikipedia.org/wiki/XOR_linked_list)

## Set

| List | Set |
|-|-|
| ordered elements | unordered elements |
| double elements allowed | no double elements allowed |

- typically implemented as an arry or linked list

## Table (Map, Dictionary, Key/Value-Pairs)

- behaves like an array, but with an alphanumeric index, e.g. table['red']
- realization
    - two corresponding arrays, one for the keys, other the values
    - maybe, one array storing a node: key, value
        ```mermaid
            block-beta
                block
                    key_element
                    data_element
                end
        ```
    - keep this array sorted (SortedMap)
    - excursion:
        - linear search: O(n)
        - binary search: O(log_2 n)
        - hashing : O(1)
    - using hashing
        - converting a string (sequence of elements) into a number, e.g. ((('r' * 100) + 'e') * 100) + 'd'
        - using this number as the numerical index for a standard array
        - any hash function will return an integer (31 Bit)
        - this value will be truncated (modulo %) by the size of the designated array
        - truncating will lead to collision (different keys with the same number)
        - solutions
            - use the next free number (worse utilization of array space)
            - recalculating the array position
            - using a linked list on the index position
            (better utilization of array space)
        - array might get full
            - new bigger array must be allocated, the truncation value will be adopted and all old values/keys must be recalculated
            - often extended by an utilization of 70%


# Algorithms

## Properties of Algorithms

- Determination
- Determinism
- Termination
- Efficiency

