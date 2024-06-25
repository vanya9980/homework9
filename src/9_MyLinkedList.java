class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        Node(T value, Node<T> next, Node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    public void add(T value) {
        Node<T> newNode = new Node<>(value, null, tail);
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
        size++;
    }
    public T remove(int index) {
        checkElementIndex(index);
        Node<T> nodeToRemove = node(index);
        T element = nodeToRemove.value;
        Node<T> next = nodeToRemove.next;
        Node<T> prev = nodeToRemove.prev;
        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            nodeToRemove.prev = null;
        }
        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            nodeToRemove.next = null;
        }
        nodeToRemove.value = null;
        size--;
        return element;
    }
    public void clear() {
        Node<T> current = head;
        while (current != null) {
            Node<T> next = current.next;
            current.value = null;
            current.next = null;
            current.prev = null;
            current = next;
        }
        head = tail = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public T get(int index) {
        checkElementIndex(index);
        return node(index).value;
    }
    private Node<T> node(int index) {
        if (index < (size >> 1)) {
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        } else {
            Node<T> current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
            return current;
        }
    }
    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }


    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.get(0)); // 1
        System.out.println(list.get(1)); // 2
        System.out.println(list.get(2)); // 3
        System.out.println(list.size()); // 3
        list.remove(1);
        System.out.println(list.get(1)); // 3
        System.out.println(list.size()); // 2
        list.clear();
        System.out.println(list.size()); // 0
    }

}