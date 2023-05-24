class LFUCache {
    int capacity;
    int min=-1;
    HashMap<Integer,Integer> keyValue=new HashMap<>();
    HashMap<Integer,Integer> keyFreq = new HashMap<>();
    HashMap<Integer, LinkedHashSet<Integer>> freqKeys=new HashMap<>();

    public LFUCache(int _capacity) {
        capacity=_capacity;
        freqKeys.put(1,new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if(!keyValue.containsKey(key)){
            return -1;
        }else{
            int freq=keyFreq.get(key);
            keyFreq.put(key,freq+1);
            freqKeys.get(freq).remove(key);
            if(freq==min&&freqKeys.get(freq).size()==0){
                min++;
            }
            if(!freqKeys.containsKey(freq+1)){
                freqKeys.put(freq+1,new LinkedHashSet<>());
            }
            freqKeys.get(freq+1).add(key);
            return keyValue.get(key);
        }
    }
    
    public void put(int key, int value) {
        if(capacity<=0){
            return;
        }
        if(keyValue.containsKey(key)){
            keyValue.put(key,value);
            get(key);
            return;
        }
        if(keyValue.size()>=capacity){
            int keyToBeRemoved=freqKeys.get(min).iterator().next();
            freqKeys.get(min).remove(keyToBeRemoved);
            keyValue.remove(keyToBeRemoved);
            keyFreq.remove(keyToBeRemoved);
            
        }
        keyValue.put(key,value);
        keyFreq.put(key,1);
        min=1;
        freqKeys.get(min).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */