package pers.rasskazov.algoritmsanddatastructures.datastructure.stack;

import java.util.EmptyStackException;

public class StackList<T> {
    private Node<T> head = null;

    public void push(T object) {
        head = new Node<>(object, head);
    }

    public T pop() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();

        var value = head.getValue();
        head = head.getPreviousReference();
        return value;
    }

    public T top() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();

        return head.getValue();
    }

    public boolean isEmpty() {
        return head == null;
    }

    private class Node<T> {
        private T value;
        private Node<T> previousReference;

        Node(T value, Node<T> previousReference) {
            this.value = value;
            this.previousReference = previousReference;
        }

        T getValue() {
            return value;
        }

        Node<T> getPreviousReference() {
            return previousReference;
        }
    }
}
