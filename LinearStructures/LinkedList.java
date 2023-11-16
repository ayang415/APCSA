package LinearStructures;

import java.lang.Iterable;
import java.util.Iterator; 

public class LinkedList<E> implements Iterable<E>{
    private int size = 0;

    private Node<E> head, tail;

    public LinkedList() {}

    public LinkedList(E[] objects) {
        for(int i = 0; i < objects.length; i++) {
            //add(objects[i]);
        }
    }

    public void add(E e) {
        add(size, e);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index" + index + " out of bounds");
        }
    }

    public int indexOf(E e) {
        if(size == 0) return -1;

        int index = 0;
        Node<E> current = head;
        do{
            if(current.element == e) {
                return index;
            }
            current = current.next;
            index++;
        } while(current != null); //has to run once, then checks if it should continue

        return -1;
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;

        if(tail == null) { //the list was empty
            tail = head;
        }
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if(tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
            size++;
        }
    }

    public void add(int index, E e) {
        if(index == 0) addFirst(e);
        else if (index >= size) addLast(e);
        else {
            Node<E> current = head;
            for(int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<E>(e);
            (current.next).next = temp;
            size++;
        }
    }

    public E getFirst() {
        if(size == 0) return null;
        return head.element;
    }

    public E getLast() {
        if(size == 0) return null;
        return tail.element;
    }

    public E removeFirst() {
        if(size == 0) return null;
        else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if(head == null) tail = null; //we removed the only element, so the list is empty
            return temp.element;
        }
    }

    public E removeLast() {
        if(size == 0) return null;
        else if(size == 1) {
            Node<E> temp = head;
            clear();
            return temp.element;
        } else {
            Node<E> current = head;

            for(int i = 0; i < size - 2; i++) {
                current = current.next;
            }

            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }

    public E remove(int index) {
        checkIndex(index);
        if(index == 0) return removeFirst();
        else if (index == size) return removeLast();
        else {
            Node<E> current = head;
            for(int i = 1; i < index - 1; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = (current.next).next;
            size--;
            return temp.element;
        }
    }

    public void clear() {
        size = 0;
        head = tail = null;
    }

    public E get(int index) {
        checkIndex(index);
        if(index == 0) {
            return head.element;
        }
        Node<E> current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    public int lastIndexOf(E e) {
        if(size == 0) return -1;

        int index = 0;
        int latest = -1;
        Node<E> current = head;
        do{
            if(current.element == e) {
                latest = index;
            }
            current = current.next;
            index++;
        } while(current != null);

        return latest;
    }

    public E set(int index, E e) {
        checkIndex(index);
        Node<E> current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        Node<E> temp = current;
        current.element = e;
        return temp.element;
    }

    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    // a class inside a class !?
    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current = head;
        int i = 0;

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public E next() {
            Node<E> temp = current;
            current = current.next;
            i++;
            return temp.element;
        }

        @Override
        public void remove() {
            LinkedList.this.remove(i);
        }
    }

    @Override
    public String toString() {
        Node<E> current = head.next;

        if(size == 0) return "[]";
        String t = "[" + head.element;
        for(int i = 1; i < size; i++) {
            t += ", " + current.element;
            current = current.next;
        }
        return t + "]";
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }
}
