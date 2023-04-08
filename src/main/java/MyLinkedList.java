import java.util.Arrays;

public class MyLinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (size == 0) {
            first = last = newNode;
        } else {
            newNode.prevElement = last;
            last.nextElement = newNode;
            last = newNode;
        }
        size++;
    }

    public void add(int index, E element) {
        Node<E> newNode = new Node<>(element);
        if (size == 0) {
            first = last = newNode;
        } else if (index == 0) {
            newNode.prevElement = null;
            first.prevElement = newNode;
            newNode.nextElement = first;
            first = newNode;
        } else if (index == size - 1) {
            newNode.prevElement = last;
            last.nextElement = newNode;
            last = newNode;
        } else {
            Node<E> current = getNodeByIndex(index - 1);
            Node<E> current2 = getNodeByIndex(index);
            newNode.nextElement = current.nextElement;
            current.nextElement = newNode;
            newNode.prevElement = current;
            current2.prevElement = newNode;
        }
        size++;
    }

    private Node<E> getNodeByIndex(int index) {
        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.nextElement;
        }
        return current;
    }

    public void remove(int index) {
        if (index == 0) {
            first = first.nextElement;
            first.prevElement = null;
            if (first == null) {
                last = null;
            }
        } else {
            Node<E> prev = getNodeByIndex(index - 1);
            prev.nextElement = prev.nextElement.nextElement;
            if (index == size - 1) {
                last = prev;
            }
        }
        size--;
    }

    public void clear() {
        first = last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        return getNodeByIndex(index).element;
    }


    @Override
    public String toString() {
        if (first == null) return Arrays.toString(new Object[0]);
        Object[] elements = new Object[size];
        int index = 0;
        for (Node<E> i = first; i != null; i = i.nextElement) {
            if (i.element != null) {
                elements[index] = i.element;
                index++;
            }
        }
        return Arrays.toString(elements);
    }


    private class Node<E> {

        private E element;
        private Node<E> prevElement;
        private Node<E> nextElement;

        public Node(E element) {
            this.element = element;
        }
    }
}
