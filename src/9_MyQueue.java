import java.util.NoSuchElementException;

class MyQueue<T> {
    private Node<T> head; // Головний елемент черги
    private Node<T> tail; // Останній елемент черги
    private int size; // Розмір черги

    // Внутрішній клас для вузлів списку
    private static class Node<T> {
        private T value;
        private Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    public MyQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    // Метод для додавання елементу в кінець черги
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = tail;
        }
        size++;
    }

    // Метод для очищення черги
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    // Метод для отримання розміру черги
    public int size() {
        return size;
    }

    // Метод для отримання першого елементу черги без видалення
    public T peek() {
        if (head == null) {
            throw new NoSuchElementException("Черга порожня");
        }
        return head.value;
    }

    // Метод для отримання і видалення першого елементу черги
    public T poll() {
        if (head == null) {
            throw new NoSuchElementException("Черга порожня");
        }
        T value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue.peek());  // Виведе: 1
        System.out.println(queue.poll());  // Виведе: 1
        System.out.println(queue.size());  // Виведе: 2
        queue.clear();
        System.out.println(queue.size());  // Виведе: 0
    }
}