import java.util.Arrays;

public class MyStack<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public void push(E element) {
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

    public E remove(int index) {
        Node<E> x = getNodeByIndex(index);

        final E element = x.element;
        final Node<E> next = x.nextElement;
        final Node<E> prev = x.prevElement;

        if (index == 0) {
            if (size > 1) {
                first = first.nextElement;
                first.prevElement = null;
            } else {
                first = last = null;
            }
        } else if (index == size - 1) {
            last = last.prevElement;
            last.nextElement = null;
        } else {
            prev.nextElement = next;
            next.prevElement = prev;
        }
        size--;
        return element;
    }

    public void clear() {
        first = last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E peek() {
        return (E) last.element;
    }

    public E pop() {
        Node<E> lastToRemove = last;
        if (size > 1) {
            last = last.prevElement;
            last.nextElement = null;
        } else {
            first = last = null;
        }
        size--;
        return (E) lastToRemove.element;
    }


    private Node<E> getNodeByIndex(int index) {
        Node<E> currentToRemove = first;
        for (int i = 0; i < index; i++) {
            currentToRemove = currentToRemove.nextElement;
        }
        return currentToRemove;
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
