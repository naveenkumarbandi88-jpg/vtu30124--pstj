import java.util.LinkedList;

class MyHashSet {
    private static final int BASE = 769; // A prime number to minimize collisions
    private LinkedList<Integer>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        buckets = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    private int hash(int key) {
        return key % BASE;
    }
    
    public void add(int key) {
        int bucketIndex = hash(key);
        if (!buckets[bucketIndex].contains(key)) {
            buckets[bucketIndex].add(key);
        }
    }
    
    public void remove(int key) {
        int bucketIndex = hash(key);
        buckets[bucketIndex].remove((Integer) key);
    }
    
    public boolean contains(int key) {
        int bucketIndex = hash(key);
        return buckets[bucketIndex].contains(key);
    }
}




Input
["MyHashSet","add","add","add","remove","contains","add","add","add","remove","contains","add","add","add","remove","contains","add","add","add","remove","contains"]
[[],[1],[10001],[1],[1],[1],[7],[10007],[7],[7],[7],[123],[10123],[123],[123],[123],[5000],[15000],[5000],[5000],[5000]]
Output
[null,null,null,null,null,false,null,null,null,null,false,null,null,null,null,false,null,null,null,null,false]
Expected
[null,null,null,null,null,false,null,null,null,null,false,null,null,null,null,false,null,null,null,null,false]
