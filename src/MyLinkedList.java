public class MyLinkedList<T> implements MyList<T> {
    private class Node {
        T element; // The element stored in the node
        Node next; // Reference to the next node in the list
        Node prev; // Reference to the previous node in the list

        // Constructor for creating a new node with a given element
        public Node(T element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }
    }
    // Instance variables for the linked list
    private Node head; // Reference to the first node in the list
    private Node tail; // Reference to the last node in the list
    private int size; // Number of nodes in the list

    // Constructor for creating a new, empty linked list
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Returns the number of elements in the list
    @Override
    public int size() {
        return size;
    }
    // Returns true if the list contains the given element, false otherwise
    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }
    // Adds a new element to the end of the list
    @Override
    public void add(T element) {
        Node node = new Node(element); // Create a new node with the given element
        if (head == null) { // If the list is empty, set the new node as both head and tail
            head = node;
            head = node;
            tail = node;
        } else { // Otherwise, append the new node to the end of the list
            tail.next = node; // Set the next reference of the current tail to the new node
            node.prev = tail; // Set the prev reference of the new node to the current tail
            tail = node; // Set the new node as the new tail of the list
        }
        size++; // Increment the size of the list
    }

    // Add an element at the specified index
    @Override
    public void add(T element, int index) {
        // Check if index is valid
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        // Create a new node with the given element
        Node node = new Node(element);
        // Special case for adding at the beginning of the list
        if (index == 0) {
            node.next = head;
            head.prev = node;
            head = node;
        }
        // Special case for adding at the end of the list
        else if (index == size) {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        // General case for adding in the middle of the list
        else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            node.next = current;
            node.prev = current.prev;
            current.prev.next = node;
            current.prev = node;
        }
        size++; // Increment the size of the list
    }

    // Remove the first occurrence of the specified item from the list
    @Override
    public boolean remove(T item) {
        Node current = head;

        while (current != null) {
            // If the current node contains the item to remove
            if (current.element.equals(item)) {
                // Special case for removing the first node in the list
                if (current.prev == null) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                }
                // Special case for removing the last node in the list
                else if (current.next == null) {
                    tail = current.prev;
                    tail.next = null;
                }
                // General case for removing a node in the middle of the list
                else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--; // Decrement the size of the list
                return true;
            }
            current = current.next;
        }
        // If the item was not found in the list, return false
        return false;
    }

    // Remove the element at the specified index and return it
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node current;

        if (index == 0) {
            current = head;
            head = current.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (index == size - 1) {
            current = tail;
            tail = current.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
        } else {
            if (index < size / 2) {
                current = head;
                int count = 0;
                while (count < index) {
                    current = current.next;
                    count++;
                }
            } else {
                current = tail;
                int count = size - 1;
                while (count > index) {
                    current = current.prev;
                    count--;
                }
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        size--;
        return (T) current.element;
    }

    // Removes all elements from the list
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    // Returns the element at the specified index in the list
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current;
        int count;
        // Traverse the list from the head if the index is in the first half of the list
        if (index < size / 2) {
            current = head;
            count = 0;
            while (count < index) {
                current = current.next;
                count++;
            }
            // Traverse the list from the tail if the index is in the second half of the list
        } else {
            current = tail;
            count = size - 1;
            while (count > index) {
                current = current.prev;
                count--;
            }
        }

        return (T) current.element;
    }

    // Returns the index of the first occurrence of the specified element in the list,
    // or -1 if the element is not found in the list
    @Override
    public int indexOf(Object o) {
        Node curr = head;
        int index = 0;
        while (curr != null) {
            if (curr.element.equals(o)) {
                return index;
            }
            curr = curr.next;
            index++;
        }
        return -1;
    }

    // Returns the index of the last occurrence of the specified element in the list,
    // or -1 if the element is not found in the list
    @Override
    public int lastIndexOf(Object o) {
        Node curr = tail;
        int index = size - 1;
        while (curr != null) {
            if (curr.element.equals(o)) {
                return index;
            }
            curr = curr.prev;
            index--;
        }
        return -1;
    }

    // Sorts the elements in the list in ascending order
    @Override
    public void sort() {
        // If the list is empty or contains only one element, no need to sort
        if (size <= 1) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node curr = head;
            while (curr.next != null) {
                // If the current element is greater than the next element, swap them
                if (((Comparable<T>) (T) curr.element).compareTo((T)curr.next.element) > 0) {
                    // Swap elements
                    T temp = (T) curr.element;
                    curr.element = curr.next.element;
                    curr.next.element = (T) temp;
                    swapped = true;
                }
                curr = curr.next;
            }
        } while (swapped);
    }
}