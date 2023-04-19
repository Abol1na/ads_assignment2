# ads_assignment2

## Project Description
The project description is a set of instructions for creating two classes, MyArrayList and MyLinkedList, that implement the List interface. The purpose of this project is to practice implementing common data structures in Java.

For MyArrayList, you are instructed to create an instance variable of type Object[] to hold the elements of the list, as well as an int variable called size to keep track of the number of elements. You should then implement the add, get, and remove methods, as well as the size method, as specified in the instructions. The MyArrayList class is an implementation of the MyList interface, which represents a simple list data structure. The MyArrayList class uses an array to store its elements, and it resizes the array when necessary to accommodate new elements.

For MyLinkedList, you are instructed to create a private inner class called Node that contains an element of type E and references to the next and previous nodes in the list. You should also define instance variables called head and tail to reference the first and last nodes in the list, respectively. Similarly to MyArrayList, you should implement the add, get, and remove methods, as well as the size method, as specified in the instructions.

## MyArrayList methods
<details>
<summary>Methods</summary>
  <details>
  <summary>size()</summary>
  Returns the number of elements in the list.
  </details>
  <details>
  <summary>contains(Object o)</summary>
  Returns true if the list contains the specified element, false otherwise.
  </details>
  <details>
  <summary>add(T item)</summary>
  Adds the specified element to the end of the list.
  </details>
  <details>
  <summary>add(T item, int index)</summary>
  Adds the specified element to the list at the specified index. If the index is out of range, an IndexOutOfBoundsException is thrown.
  </details>
  <details>
  <summary>remove(T item)</summary>
  Removes the first occurrence of the specified element from the list, if it is present. Returns true if the element was removed, false otherwise.
  </details>
  <details>
  <summary>remove(int index)</summary>
  Removes the element at the specified index from the list. Returns the element that was removed. If the index is out of range, an IndexOutOfBoundsException is thrown.
  </details>
  <details>
  <summary>clear()</summary>
  Removes all elements from the list.
  </details>
  <details>
  <summary>get(int index)</summary>
  Returns the element at the specified index. If the index is out of range, an IndexOutOfBoundsException is thrown.
  </details>
  <details>
  <summary>indexOf(Object o)</summary>
  Returns the index of the first occurrence of the specified element in the list, or -1 if the element is not present.
  </details>
  <details>
  <summary>lastIndexOf(Object o)</summary>
  Returns the index of the last occurrence of the specified element in the list, or -1 if the element is not present.
  </details>
  <details>
  <summary>sort()</summary>
  Sorts the elements in the list in ascending order using their natural order.
  </details>
