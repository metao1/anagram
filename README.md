# AnagramChecker

An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

## Design
The `AnagramChecker` interface provides a method for checking if two strings are anagrams of each other.
It provides extensibility by allowing different implementations of the `AnagramChecker` interface to be used.

## Decision driver
There are many ways of implementation if two strings are anagrams of each other.
### Sorting approach
We sort the characters in each string and compare the sorted strings.

Pros: 
- Supports all type of input character sets, beside word.
- Space efficient as complexity is O(1).

Cons:
- It is not very efficient because sorting complexity is O(n log n).

### Using hash table
We use hash table to count the number of occurrences of each character in each string and compare the counts.
Pros:
- Supports all type of input character sets, beside word.
- It is much efficient compared to sorting approach.

Cons:
- Space complexity is O(n) as extra space.
- It is not very scalable.
- It is not very flexible.

### Using array based approach
We use an array to count the number of occurrences of each character in each string and compare the counts.
Pros:

- It is easy to understand and maintain.
- It is much efficient compared to sorting approach.

Cons:
- It is limited number of characters set we defined as constant.

## Implementation
✅ `As definition of anagram is limited to word, we can use an array based approach.`

The `ArrayAnagramChecker` class implements the `AnagramChecker` interface.
Inside `areAnagrams` method, we can pass two strings we want to check if they are anagrams of each other. 
The method will return `true` if the texts are anagrams of each other, and `false` otherwise.

Here's an example that demonstrates how to implement the `AnagramChecker` using `ArrayAnagramChecker` class:

```java
AnagramChecker anagramChecker = new ArrayAnagramChecker();
boolean result = anagramChecker.areAnagrams("restful", "fluster");
System.out.println(result); // true
```

## Complexity
The time complexity of the `areAnagrams` method is O(n), where n is the length of the strings.
The space complexity of the `areAnagrams` method is O(1), since the size of the array is fixed.

## Testing
The `Main` class provides a set of test cases for the `ArrayAnagramChecker` class. 
To run the tests, simply run the `Main` class as a JUnit test.

The test cases cover a variety of scenarios, including strings of different lengths, strings with the same characters 
but different counts, strings with different characters, strings with the same characters but different cases, strings 
with spaces and punctuation, and strings with numbers. These tests help ensure that the ArrayAnagramChecker class is 
working correctly and can handle a wide range of inputs.