class CacheInfo
{
    int key;
    int value; 
    
    public CacheInfo(int key, int value)
    {
        this.key = key;
        this.value = value;
    }
}

class LRUCache 
{
    int capacity=0;
    Map<Integer, CacheInfo> map = new HashMap();
    Deque<CacheInfo> dq = new LinkedList();

    public LRUCache(int capacity) 
    {
        this.capacity = capacity;
        // map = new HashMap();
        // dq = new LinkedList<>();
    }
    
    public int get(int key) 
    {
        if(map.containsKey(key))
        {
            CacheInfo getVal = map.get(key);
            dq.remove(getVal);
            dq.addFirst(getVal);
            return getVal.value;
        }
       return -1; 
    }
    
    public void put(int key, int value) 
    {
        if(map.containsKey(key))
        {
          CacheInfo existingEntries = map.get(key);
          dq.remove(existingEntries);
        }
 
        else if(map.size()>=capacity)
        {
            CacheInfo lastEntry = dq.removeLast();
            map.remove(lastEntry.key);
        }
        CacheInfo newEntry = new CacheInfo(key, value);
        map.put(key, newEntry);
        dq.addFirst(newEntry);
        
    }
}
