import java.util.Arrays;

class MyArrayList {
    private Object[] elements;
    private int size;

    // Початковий розмір масиву
    private static final int DEFAULT_CAPACITY = 10;

    // Конструктор за замовчуванням
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // Метод для додавання елемента в кінець
    public void add(Object value) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = value;
    }

    // Метод для видалення елемента за індексом
    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null; // Звільняємо останній елемент
    }

    // Метод для очищення колекції
    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // Метод для отримання розміру колекції
    public int size() {
        return size;
    }

    // Метод для отримання елемента за індексом
    public Object get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }

    // Приватний метод для збільшення розміру масиву
    private void increaseCapacity() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add("Hello");
        list.add("World");
        System.out.println("Size: " + list.size()); // Output: Size: 2
        System.out.println("Element at index 1: " + list.get(1)); // Output: Element at index 1: World
        list.remove(0);
        System.out.println("Size after removal: " + list.size()); // Output: Size after removal: 1
        list.clear();
        System.out.println("Size after clear: " + list.size()); // Output: Size after clear: 0
    }
}