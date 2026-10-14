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
- Node ```mermaid
    block
        block
            Reference to next Element
            The data element
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

Comparison Array (List) and Linked (List)
| Operation | Array | Linked List |
|-|-|-|
| create (insert) | slow O(n) | fast O(1) |
| read | fast O(1) | slow O(n) |
| update | fast | slow |
| delete | slow | fast |
| Memory | just the data | extra reference needed |

## Double Linked List

- Node ```mermaid
    block
        block
            Reference to next element
            Reference to previous element
            The data element
        end
  ```
- typically there are references to the first element (head, first), and last element (tail, last)
- easy of iterating from to front to last, and last to front
- also easy in deleting an element in the middle

### XOR Double Linked List

- Node ```mermaid
    block
        block
            XOR Reference to next/previous element
            The data element
        end
  ```
- Storing an element means, XORing the previous and next reference as our XOR reference
- Getting the next element, XORing the previous reference
- Getting the previous element, XORing the next reference
- But not possible to get next or previous of a random element
- see [Wikipedia](https://en.wikipedia.org/wiki/XOR_linked_list)

# Algorithms

## Properties of Algorithms

- Determination
- Determinism
- Termination
- Efficiency

