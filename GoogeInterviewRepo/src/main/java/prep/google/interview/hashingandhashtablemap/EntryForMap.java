package prep.google.interview.hashingandhashtablemap;

public class EntryForMap<K,V> {

    public K key;

    public   V value;

    public EntryForMap<K,V> next;


    public EntryForMap(K key, V value, EntryForMap<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public EntryForMap(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public EntryForMap<K, V> getNext() {
        return next;
    }

    public void setNext(EntryForMap<K, V> next) {
        this.next = next;
    }
}
