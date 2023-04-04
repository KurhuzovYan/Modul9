import java.util.Arrays;

public class MyQueue<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (size == 0) {
            first = last = newNode;
        } else {
            last.nextElement = newNode;
            newNode.prevElement = last;
            last = newNode;
        }
        size++;
    }

    public E peek() {
        return (E) first.element;
    }

    public E poll() {
        Node<E> elementToRemove = first;
        if (size > 1) {
            first = first.nextElement;
            first.prevElement = null;
        } else {
            first = last = null;
        }
        size--;
        return (E) elementToRemove.element;
    }

    public int size() {
        return size;
    }

    public void clear() {
        first = last = null;
        size = 0;
    }

    @Override
    public String toString() {
        Object[] toPrint = new Object[size];
        int i = 0;
        for (Node<E> x = first; x != null; x = x.nextElement) {
            if (x.element != null) {
                toPrint[i] = x.element;
                i++;
            }
        }
        return Arrays.toString(toPrint);
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
