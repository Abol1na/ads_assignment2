public class MyArrayList<T> implements MyList<T> {
    private T[] arr;
    private int size;

    MyArrayList(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }

    /**
     * add adds an item to the end of the array
     * @param - item
     */
    @Override
    public void add(T item) {
        if(size == arr.length){
            increaseBuffer();
        }
        arr[size++] = item;
    }

    /**
     * add adds an item to a specific index in the array. If the array is full, it doubles the capacity.
     * @param item
     * @param index
     * @throws IndexOutOfBoundsException if index is out of range below
     */
    @Override
    public void add(T item, int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(size == arr.length){
            increaseBuffer();
        }
        for(int i = size; i > index; i--){
            arr[i] = arr[i-1];
        }
        arr[index] = item;
        size++;
    }
    /**
     * Removes an item from the array
     * @param item
     * @return true if found and removed, false otherwise
     */
    @Override
    public boolean remove(T item) {
        for(int i = 0; i < size; i++){
            if(arr[i].equals(item)){
                for(int j = i; j < size-1; j++){
                    arr[j] = arr[j+1];
                }
                size--;
                return true;
            }
        }
        return false;
    }
    /**
     * remove deletes an item from the array at a specific index.
     * @param index
     * @return the removed item
     * @throws IndexOutOfBoundsException if index is out of range below
     */
    @Override
    public T remove(int index) {
        checkIndex(index);
        T removedItem = arr[index];
        for(int i = index; i < size-1; i++){
            arr[i] = arr[i+1];
        }
        size--;
        return removedItem;
    }


    private void increaseBuffer(){
        T[] newArr = (T[]) new Object[arr.length*2];
        for(int i=0; i< arr.length; i++){
            newArr[i]=arr[i];
        }
        arr = newArr;
    }

    public T getElement(int index) {
        checkIndex(index);
        return arr[index];
    }
    /**
     * Gets the size of the array
     * @return the size of the array
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * contains - checks if the array contains a certain object
     * @param o the object to check for
     * @return true if the object is found, false otherwise
     */
    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < size; i++){
            if(arr[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    /**
     * clear initializing array with size 5 and setting size 0
     */
    @Override
    public void clear() {
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }

    /**
     * get - gets the element at the specified index
     * @param index
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range below
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }

    /**
     * indexOf - returns the index of the first specified element in the list, or -1 if the list does not contain the element
     * @param o the element to search for
     */
    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < size; i++){
            if(arr[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in the list, or -1 if the list does not contain the element.
     *
     * @param o the element to search for
     * @return the index of the last occurrence of the element in the list, or -1 if the list does not contain the element
     */
    @Override
    public int lastIndexOf(Object o) {
        for(int i = size-1; i >= 0; i--){
            if(arr[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    /**
     * sorts the list using the natural order of elements
     */
    @Override
    public void sort() {
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 1; i < size; i++) {
                if (((Comparable) arr[i-1]).compareTo(arr[i]) > 0) {
                    Object temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = (T) temp;
                    swap = true;
                }
            }

        }
    }


    /**
     * checkIndex - helper method to check if the given index is valid
     * @param index
     */
    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }
}