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
        return unlink(index);
    }

    public int size() {
        return size;
    }

    E unlink(int index) {
        Node<E> x = getNodeByIndex(index);

        final E element = x.element;
        final Node<E> next = x.nextElement;
        final Node<E> prev = x.prevElement;

        if (index == 0) {
            first = first.nextElement;
            first.prevElement = null;
        } else if (index == size - 1) {
            last = last.prevElement;
            last.nextElement = null;
        } else {
            prev.nextElement = next;
            next.prevElement = prev;
//            x.prevElement = null;
//            x.nextElement = null;
        }
        size--;
        return element;
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
