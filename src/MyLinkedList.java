public class MyLinkedList<T> implements MyList<T> {
    private class Node {
        T element;
        Node next;
        Node prev;

        public Node(T element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public void add(T element) {
        Node node = new Node(element);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    @Override
    public void add(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = new Node(element);
        if (index == 0) {
            node.next = head;
            head.prev = node;
            head = node;
        } else if (index == size) {
            tail.next = node;
            node.prev = tail;
            tail = node;
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            node.next = current;
            node.prev = current.prev;
            current.prev.next = node;
            current.prev = node;
        }
        size++;
    }

    @Override
    public boolean remove(T item) {
        Node current = head;

        while (current != null) {
            if (current.element.equals(item)) {
                if (current.prev == null) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                } else if (current.next == null) {
                    tail = current.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

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

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current;
        int count;

        if (index < size / 2) {
            current = head;
            count = 0;
            while (count < index) {
                current = current.next;
                count++;
            }
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

    @Override
    public void sort() {
        if (size <= 1) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node curr = head;
            while (curr.next != null) {
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