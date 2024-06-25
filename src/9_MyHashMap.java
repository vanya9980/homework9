import java.util.Objects;

class MyHashMap {
    private static class Node {
        final Object key;
        Object value;
        Node next;
        Node(Object key, Object value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    private Node[] buckets;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;
    public MyHashMap() {
        this.buckets = new Node[DEFAULT_CAPACITY];
        this.size = 0;
    }
    private int hash(Object key) {
        return (key == null) ? 0 : Math.abs(key.hashCode() % buckets.length);
    }
    public void put(Object key, Object value) {
        int index = hash(key);
        Node current = buckets[index];
        Node prev = null;

        while (current != null) {
            if (Objects.equals(current.key, key)) {
                current.value = value;
                return;
            }
            prev = current;
            current = current.next;
        }
        Node newNode = new Node(key, value, buckets[index]);
        buckets[index] = newNode;
        size++;
    }
    public Object get(Object key) {
        int index = hash(key);
        Node current = buckets[index];
        while (current != null) {
            if (Objects.equals(current.key, key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
    public Object remove(Object key) {
        int index = hash(key);
        Node current = buckets[index];
        Node prev = null;

        while (current != null) {
            if (Objects.equals(current.key, key)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }
    public void clear() {
        buckets = new Node[DEFAULT_CAPACITY];
        size = 0;
    }
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("key1", "value1");
        myHashMap.put("key2", "value2");
        System.out.println(myHashMap.get("key1")); // Виведе "value1"
        System.out.println(myHashMap.size()); // Виведе 2
        myHashMap.remove("key1");
        System.out.println(myHashMap.get("key1")); // Виведе null
        myHashMap.clear();
        System.out.println(myHashMap.size()); // Виведе 0
    }
}