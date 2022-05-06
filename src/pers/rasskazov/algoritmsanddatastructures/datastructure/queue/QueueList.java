package pers.rasskazov.algoritmsanddatastructures.datastructure.queue;

import java.util.NoSuchElementException;

public class QueueList<T> {
    private Node<T> head = null;
    private Node<T> bot = null;

    public void enqueue(T object) {
        var newNode = new Node<>(object);
        if(bot == null) {
            bot = newNode;
            head = newNode;
        }
        else {

            head.setNextReference(newNode);
            head = newNode;
        }
    }

    public T dequeue() throws NoSuchElementException {
        if(isEmpty()) throw new NoSuchElementException();

        var value = bot.getValue();
        bot = bot.getNextReference();
        if(bot == null) head = null;
        return value;
    }

    public T getBottom() throws NoSuchElementException {
        if(isEmpty()) throw new NoSuchElementException();

        return bot.getValue();
    }

    public boolean isEmpty() {
        return bot == null;
    }

    private class Node<T> {
        private T value;
        private Node<T> nextReference = null;

        Node(T value) {
            this.value = value;
        }

        T getValue() {
            return value;
        }

        Node<T> getNextReference() {
            return nextReference;
        }

        void setNextReference(Node<T> nextReference) { this.nextReference = nextReference; }
    }
}
