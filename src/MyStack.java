import java.util.Arrays;

public class MyStack<T> {
    private T[] stackArray;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public MyStack() {
        stackArray = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    // Додає елемент в кінець
    public void push(T value) {
        ensureCapacity();
        stackArray[size++] = value;
    }

    // Видаляє елемент за індексом
    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        for (int i = index; i < size - 1; i++) {
            stackArray[i] = stackArray[i + 1];
        }
        stackArray[--size] = null;
    }

    // Очищує колекцію
    public void clear() {
        Arrays.fill(stackArray, 0, size, null);
        size = 0;
    }

    // Повертає розмір колекції
    public int size() {
        return size;
    }

    // Повертає перший елемент стеку
    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return stackArray[size - 1];
    }

    // Повертає перший елемент стеку та видаляє його з колекції
    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        T value = stackArray[--size];
        stackArray[size] = null;
        return value;
    }

    // Перевіряє і розширює місткість масиву, якщо необхідно
    private void ensureCapacity() {
        if (size == stackArray.length) {
            stackArray = Arrays.copyOf(stackArray, stackArray.length * 2);
        }
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Size: " + stack.size()); // Size: 3
        System.out.println("Peek: " + stack.peek()); // Peek: 3

        System.out.println("Pop: " + stack.pop()); // Pop: 3
        System.out.println("Size after pop: " + stack.size()); // Size after pop: 2

        stack.remove(0);
        System.out.println("Size after remove: " + stack.size()); // Size after remove: 1

        stack.clear();
        System.out.println("Size after clear: " + stack.size()); // Size after clear: 0
    }
}