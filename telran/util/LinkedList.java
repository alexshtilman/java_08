package telran.util;

public class LinkedList<T> {
    private static class Node<T> {
        public T obj;
        public Node<T> next;
        public Node<T> prev;

        public Node(T obj) {
            this.obj = obj;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public void add(T obj) {
        Node<T> node = new Node<>(obj);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public void remove(T obj) {
        // TODO
    }

    public T get(int index) {
        if (index < 0 || index >= size)
            return null;
        return (index < size / 2) ? getFromLeft(index) : getFromRight(index);

    }

    private T getFromRight(int index) {
        Node<T> current = tail;
        for (int i = size - 1; i > index; i--) {
            current = current.prev;
        }
        return current.obj;
    }

    private T getFromLeft(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.obj;
    }

    private Node<T> getNodeFromRight(int index) {
        Node<T> current = tail;
        for (int i = size - 1; i > index; i--) {
            current = current.prev;
        }
        return current;
    }

    private Node<T> getNodeFromLeft(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public int size() {
        return size;
    }

    public boolean add(int index, T obj) {
        if (index < 0 || index >= size)
            return false;
        if (index == 0)
            setHead(obj);
        else {
            addMiddle(index, obj);
        }
        size++;
        return true;
    }

    public T remove(int index) {
        if (index < 0 || index >= size)
            return null;
        Node<T> node = getNode(index);
        T res = node.obj;
        if (index == 0)
            removeHead();
        else if (index == size - 1)
            removeTail();
        else
            removeNode(node);
        size--;
        return res;
    }

    private void removeNode(Node<T> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // avoid memory leak
        node.next = null;
        node.prev = null;
        node.obj = null;
    }

    private void removeTail() {
        tail.prev.next = null;
        tail = tail.prev;
    }

    private void removeHead() {
        head.next.prev = null;
        head = head.next;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size)
            return null;
        return (index < size / 2) ? getNodeFromLeft(index) : getNodeFromRight(index);
    }

    private void addMiddle(int index, T obj) {
        Node<T> newItem = new Node<>(obj);
        Node<T> nodeCurrent = getNode(index);

        newItem.prev = nodeCurrent.prev;
        newItem.next = nodeCurrent;
        nodeCurrent.prev.next = newItem;
        nodeCurrent.prev = newItem;
    }

    private void setHead(T obj) {
        Node<T> newHead = new Node<>(obj);
        newHead.next = head;
        newHead.prev = null;
        head = newHead;

    }
}
