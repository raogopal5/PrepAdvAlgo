package prep.google.interview.hashingandhashtablemap;

public class NodeForMap<K,V>{

    public K key;
    public V value;

    public NodeForMap<K,V> next;

    public long hashCode;

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

    public NodeForMap<K, V> getNext() {
        return next;
    }

    public void setNext(NodeForMap<K, V> next) {
        this.next = next;
    }

    public long getHashCode() {
        return hashCode;
    }

    public void setHashCode(long hashCode) {
        this.hashCode = hashCode;
    }
}
