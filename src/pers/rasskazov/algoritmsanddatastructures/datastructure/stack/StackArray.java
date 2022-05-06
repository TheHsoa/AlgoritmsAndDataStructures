package pers.rasskazov.algoritmsanddatastructures.datastructure.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackArray<T> {
    private T[] elementData;
    private int head = -1;

    public StackArray() {
        //noinspection unchecked
        elementData = (T[]) new Object[10];
    }

    public void push(T object) {
        head++;
        if (head >= elementData.length) {
            grow();
        }

        elementData[head] = object;
    }

    public T pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return elementData[head--];
    }

    public T top() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return elementData[head];
    }

    public boolean isEmpty(){
        return head == -1;
    }

    private void grow() {
        var oldCapacity = elementData.length;
        var newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity < 0) throw new OutOfMemoryError();
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
}

