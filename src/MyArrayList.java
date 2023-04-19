public class MyArrayList<T> implements MyList<T> {
    private T[] arr;
    private int size;

    MyArrayList(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
    @Override
    public void add(T item) {
        if(size == arr.length){
            increaseBuffer();
        }
        arr[size++] = item;
    }

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

    public void increaseBuffer(){
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
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < size; i++){
            if(arr[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {

    }

    public void delete(int index){
        checkIndex(index);
        for(int i= index + 1; i<size; i++){
            arr[i-1] = arr[i];
        }
        size--;
    }
    public void checkIndex(int index){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }
}