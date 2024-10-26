package prep.google.interview.hashingandhashtablemap;

import java.util.NoSuchElementException;

public class MapUsingLinkedList<K,V> {

    private static final int ARRAY_SIZE = 16;

    private NodeForMap<K, V>[] nodeList = new NodeForMap[ARRAY_SIZE];

    public void add(K key,V value)  {

        long hashCode = this.getHashCode(key);
        int index = this.getIndex(hashCode);

        if (index > ARRAY_SIZE) {
            throw new NoSuchElementException("Invalid key, please check again!");
        }

        // Checking if there is already a Node at the given index.
        if (this.nodeList[index] != null) {

            // We're getting the node at the given index, so that we can traverse to the end
            // and add the new node.
            NodeForMap<K, V> exitingNode = this.nodeList[index];

            while (exitingNode.getNext() != null) {
                exitingNode = exitingNode.getNext();
            }

            // We're creating the new node.
            NodeForMap<K, V> newNode = new NodeForMap<>();
            newNode.setKey(key);
            newNode.setValue(value);
            newNode.setHashCode(hashCode);

            exitingNode.setNext(newNode);

        } else {
            // If there's no node at the given index, we'll just create a new node and add to the array
            // at the given index.
            NodeForMap<K, V> newNode = new NodeForMap<>();
            newNode.setKey(key);
            newNode.setValue(value);
            newNode.setHashCode(hashCode);

            this.nodeList[index] = newNode;
        }
    }

    private long getHashCode(K key) {

        String keyString = key.toString();
        return keyString.hashCode();
    }

    private int getIndex(long hashCode) {

        return Math.toIntExact(hashCode % ARRAY_SIZE);
    }

    public void printHashMap() {

        System.out.println("==============================================");
        System.out.println("Printing map:");

        int index = 0;

        while (index < ARRAY_SIZE) {

            NodeForMap<K, V> node = this.nodeList[index];

            if (node != null) {

                int listIndex = 0;

                while (node != null) {

                    if (listIndex > 0) {
                        System.out.print(" || ");
                    }

                    System.out.print(node.getKey().toString() + " -> ");
                    System.out.print(node.getValue().toString());

                    node = node.getNext();
                    listIndex++;

                }

                System.out.println("");
            }

            index++;
        }

        System.out.println("==============================================");
    }

}
