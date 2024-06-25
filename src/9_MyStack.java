import java.util.Arrays;

class MyStack {
    private Object[] elements;
    private int size;
    public MyStack() {
        elements = new Object[10];
        size = 0;
    }
    public void push(Object value) {
        ensureCapacity();
        elements[size++] = value;
    }
    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Object removedElement = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return removedElement;
    }
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }
    public int size() {
        return size;
    }
    public Object peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements[size - 1];
    }
    public Object pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        Object topElement = elements[--size];
        elements[size] = null;
        return topElement;
    }
    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push("First");
        stack.push("Second");
        stack.push("Third");

        System.out.println("Size: " + stack.size()); // Output: Size: 3
        System.out.println("Peek: " + stack.peek()); // Output: Peek: Third

        System.out.println("Pop: " + stack.pop()); // Output: Pop: Third
        System.out.println("Size after pop: " + stack.size()); // Output: Size after pop: 2

        stack.remove(0);
        System.out.println("Size after remove: " + stack.size()); // Output: Size after remove: 1

        stack.clear();
        System.out.println("Size after clear: " + stack.size()); // Output: Size after clear: 0
    }
}