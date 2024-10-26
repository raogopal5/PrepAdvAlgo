package prep.google.interview.hashingandhashtablemap;

public class CustomHashMap<K,V> {
    /**
     * hash map can create by using hashing,array and linkedlist
     */

    private static int DEFAULT_CAPACITY = 16;

    private EntryForMap<K, V>[] hashTable;

    private int capacity;


    public CustomHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        this.hashTable = new EntryForMap[capacity];
    }


    public int hash(K key){
        // Using modulo "% capacity" to make sure that returned hash in the range of
        // underlying Array size
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        if (key == null) {
            return;
        }
        // Create a key-value pair
        EntryForMap<K, V> newEntry = new EntryForMap<>(key, value);
        //create hash to find the location in bucket or array for empty case
        int hash = hash(key);
        if (hashTable[hash] == null) {
            hashTable[hash] = newEntry;
        } else {
            // else - "Hash Bucket" is not Empty, Known as "Hash Collision"
            // New Entry is created and linked to Previous Node in Same Bucket
            EntryForMap<K, V> current = hashTable[hash];
            EntryForMap<K, V> previous = null;

            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = newEntry.value;
                    return;
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }

    }



    public V get(K key) {
        if (key == null) {
            return null;
        }
        // Create a key-value pair
        // if - "Hash Bucket" is Empty, Return null
        int hash = hash(key);
        if (hashTable[hash] == null) {
            hashTable[hash] = null;
        } else {
            // else - "Hash Bucket" is not Empty
            // Traverse through all the linked Nodes in the Bucket
            // Use `equals` method to find the correct key-value pair
            EntryForMap<K, V> current = hashTable[hash];
            while (current != null) {
                if (current.key.equals(key)) {
                    return current.value;
                }
                current = current.next;
            }

        }
        return null;
    }

    public void print(){
        for(int i=0;i<capacity;i++){
            if(hashTable[i] != null){
               EntryForMap<K,V> current = hashTable[i];
               while (current !=null){
                   System.out.println("key is ->"+current.key +" value ->" +current.value);
                   current = current.next;
               }

            }
        }
    }

    public void remove(K key){
        int hash = hash(key);
        EntryForMap<K, V> previous = null;
        EntryForMap<K, V> current = hashTable[hash];
        while (current != null){
            if(current.key.equals(key)) {
                if (previous == null) {
                    current = current.next;
                    hashTable[hash] = current;
                    return;
                }
            }else{
                previous = previous.next;
            }
        }
        previous = current;
        current = current.next;
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> customHashMap = new CustomHashMap<String, Integer>();
        customHashMap.put("A",1);
        customHashMap.put("B",2);
        customHashMap.put("C",3);
        customHashMap.print();
        customHashMap.remove("A");
        customHashMap.print();
        Integer resultOfA = customHashMap.get("A");
        System.out.println("resultOfA ->" + resultOfA);
    }

}
