public class Main {
    public static void main(String[] args) {

        //        Object[] myArrayNew = new Object[myArray.length - 1];
//        System.arraycopy(myArray, 0, myArrayNew, 0, index);
//        System.arraycopy(myArray, index + 1, myArrayNew, index, myArray.length - index - 1);
//        myArray = myArrayNew;
        MyLinkedList <String> linkedList = new MyLinkedList<>();
        MyArrayList <String> arrayList = new MyArrayList<>();
        MyArrayList <Integer> arrayList2 = new MyArrayList<>();

        arrayList.add("Hello");
        arrayList.add("My");
        arrayList.add("World");
        System.out.println(arrayList);
        System.out.println(arrayList.size());
        System.out.println(arrayList.get(2));
        arrayList2.add(12);
        arrayList2.add(23);
        arrayList2.add(42);
        arrayList2.add(12);
        System.out.println(arrayList2);
        arrayList.remove(1);
        System.out.println(arrayList);
        System.out.println(arrayList.size());
        System.out.println(arrayList2.get(3));

//        linkedList.add("Hello");
//        linkedList.add("My");
//        linkedList.add("World");
//        System.out.println(linkedList);
//        System.out.println(linkedList.get(1));
//        System.out.println(linkedList.size());
//        linkedList.remove(2);
//        System.out.println(linkedList);
//        linkedList.remove(0);
//        System.out.println(linkedList);
//        linkedList.add("Name");
//        linkedList.add("Name");
//        linkedList.add("Name");
//        System.out.println(linkedList);
//        linkedList.clear();
//        System.out.println(linkedList);
//        System.out.println(linkedList.size());
//        linkedList.add("Hello");
//        System.out.println(linkedList);
//        System.out.println(linkedList.size());
//        System.out.println(linkedList.get(0));
    }
}
