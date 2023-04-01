import java.util.Arrays;

public class MyArrayList<E> {
    private Object[] myArray = new Object[0];
    private int indexOfElement = 0;

    public void add(E element) {
        myArray = Arrays.copyOf(myArray, myArray.length + 1);
        myArray[indexOfElement] = element;
        indexOfElement++;
    }

    public void remote(int index) {
        Object[] myArrayNew = new Object[myArray.length - 1];
        System.arraycopy(myArray, 0, myArrayNew, 0, index);
        System.arraycopy(myArray, index + 1, myArrayNew, index, myArray.length - index - 1);
        myArray = myArrayNew;
        indexOfElement--;
    }

    public void clear() {
        myArray = Arrays.copyOf(myArray, 0);
        indexOfElement = 0;
    }

    public int size() {
        return myArray.length;
    }

    public void get(int index) {
        int i = 0;
        for (Object o : myArray) {
            if (i != index) {
                i++;
            } else {
                System.out.println(o);
            }
        }
    }

    @Override
    public String toString() {
        return "MyArrayList: " + Arrays.toString(myArray);
    }

}
