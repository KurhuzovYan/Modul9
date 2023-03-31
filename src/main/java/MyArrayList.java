import java.util.Arrays;

public class MyArrayList {
    private Object[] myArray = new Object[0];
    private int indexOfElement = 0;

    public void add(Object o) {
        myArray = Arrays.copyOf(myArray, myArray.length + 1);
        myArray[indexOfElement] = o;
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
        return "MyArrayList: " + Arrays.toString(myArray) ;
    }

    public static void main(String[] args) {
        MyArrayList listStr = new MyArrayList();
        listStr.add("Hello");
        listStr.add(10);
        listStr.add('a');
        System.out.println(listStr);
        listStr.remote(1);
        System.out.println(listStr);
        listStr.add("World");
        System.out.println(listStr);
        System.out.println(listStr.size());
        listStr.clear();
        System.out.println(listStr.size());
        listStr.add("Hi");
        listStr.add(2);
        listStr.add("World!");
        listStr.get(2);
    }
}
