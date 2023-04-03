import java.util.Arrays;

public class MyArrayList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] myArray = new Object[size];

    public void add(E element) {
        if (myArray.length == size) {
            Object[] newArray = new Object[myArray.length + DEFAULT_CAPACITY];
            System.arraycopy(myArray, 0, newArray, 0, size);
            myArray = newArray;
        }
        myArray[size] = element;
        size++;
    }

    public void remove(int index) {
        System.arraycopy(myArray, index + 1, myArray, index, myArray.length - index - 1);
        size--;
    }

    public void clear() {
        myArray = Arrays.copyOf(myArray, 0);
        size = 0;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        E element = null;
        for (int i = 0; i <= index; i++) {
            element = (E) myArray[i];
        }
        return (E) ("Element by index " + index + " -> " + element);
    }

    @Override
    public String toString() {
        Object[] elementWithoutNull = new Object[size];
        int i = 0;
        for (Object el : myArray) {
            if (el != null) {
                elementWithoutNull[i] = el;
                i++;
            }
        }
        return Arrays.toString(elementWithoutNull);
    }

}
