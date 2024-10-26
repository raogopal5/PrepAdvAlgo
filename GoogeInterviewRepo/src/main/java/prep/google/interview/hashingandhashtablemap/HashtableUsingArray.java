package prep.google.interview.hashingandhashtablemap;

public class HashtableUsingArray {

    private Item[] data;
    private int capacity;
    private int size;
    private static final Item AVAILABLE = new Item("Available", null);

    public HashtableUsingArray(int capacity) {

        this.capacity = capacity;
        data = new Item[capacity];
        for(int i = 0; i < data.length; i++) {

            data[i] = AVAILABLE;
        }
        size = 0;
    }

    public int size() {

        return size;
    }

    public int hashThis(String key) {

        return key.hashCode() % capacity;
    }

    public Object get(String key) {

        int hash = hashThis(key);

        while(data[hash] != AVAILABLE && data[hash].key() != key) {

            hash = (hash + 1) % capacity;
        }
        return data[hash].element();
    }

    public Object remove(String key) {
        // not important now.
        throw new UnsupportedOperationException("Can't remove");
    }

    public void put(String key, Object element) {

        if(key != null) {
            size++;
            int hash = hashThis(key);
            while(data[hash] != AVAILABLE && data[hash].key() != key) {

                hash = (hash + 1) % capacity;
            }

            data[hash] = new Item(key, element);

        }

    }

    public String toString() {

        String s = "<HashTable[";
        for(int i = 0; i < this.size(); i++) {

            s += data[i].toString();
            if(i < this.size() - 1) {

                s += ",";
            }
        }
        s += "]>";
        return s;
    }

    public static void main(String[] args) {
        HashtableUsingArray hashtableUsingArray = new HashtableUsingArray(5);
        hashtableUsingArray.put("3","RH");
        hashtableUsingArray.put("2","RHG");
        hashtableUsingArray.put("4","RHG");
        System.out.println(hashtableUsingArray.size());
        System.out.println(hashtableUsingArray);
    }

}
