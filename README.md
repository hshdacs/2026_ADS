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



# Algorithms

## Properties of Algorithms

- Determination
- Determinism
- Termination
- Efficiency

