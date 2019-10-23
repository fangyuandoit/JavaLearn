package 手写源码系列;

/**
 * @Author: fang
 * @Date: 2019/10/23 21:59
 * @Description:
 */
public class MyHashMap<K, V> {

    private Entry[] table;

    private int size = 0;
    private int capacity = 8;


    public MyHashMap() {
        this.table = new Entry[capacity];
    }

    public int size() {
        return size;
    }


    public Object get(Object key) {

        int hash = key.hashCode();
        int i = hash % capacity;
        for (Entry<K, V> entry = table[i]; entry != null; entry = entry.next) {
            if (entry.k.equals(key)) {
                return entry.v;
            }
        }
        return null;


    }


    public Object put(K key, V value) {


        int hash = key.hashCode();
        int i = hash % capacity;

        for (Entry<K, V> entry = table[i]; entry != null; entry = entry.next) {
            if (entry.k.equals(key)) {
                V oldValue = entry.v;
                entry.v = value;
                return oldValue;
            }
        }
        addEntry(key, value, i);
        return null;
    }

    private void addEntry(K key, V value, int i) {
        Entry entry = new Entry(key, value, table[i]);
        table[i] = entry;
        size++;
    }

    class Entry<K, V> {
        private K k;
        private V v;
        private Entry<K, V> next;

        public Entry(K k, V v, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        public K getK() {
            return k;
        }

        public V getV() {
            return v;
        }

        public Entry<K, V> getNext() {
            return next;
        }
    }


}
