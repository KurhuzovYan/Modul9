import java.util.Arrays;

public class MyArrayList<E> {
    private Object[] myArray = new Object[0];
    private int size = 0;

    public void add(E element) {
        myArray = Arrays.copyOf(myArray, myArray.length + 1);
        myArray[size] = element;
        size++;
    }

    public void remove(int index) {
        Object[] myArrayNew = new Object[myArray.length - 1];
        System.arraycopy(myArray, 0, myArrayNew, 0, index);
        System.arraycopy(myArray, index + 1, myArrayNew, index, myArray.length - index - 1);
        myArray = myArrayNew;
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
        return element;
    }

    @Override
    public String toString() {
        return Arrays.toString(myArray);
    }

}
