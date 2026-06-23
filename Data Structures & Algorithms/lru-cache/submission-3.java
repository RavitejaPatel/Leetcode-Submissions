class CacheInfo
{
    int key;
    int value;

    public CacheInfo(int key, int value)
    {
        this.key=key;
        this.value=value;
    } 
}

class LRUCache 
{
    int capacity;
    Map<Integer,CacheInfo> map = null;
    //Map<Integer,Integer> map = null;
    Deque<CacheInfo> dq = null;
    public LRUCache(int capacity) 
    {
        this.capacity = capacity;
        this.map =  new HashMap();
        this.dq = new ArrayDeque();
    }
    
    public int get(int key) 
    {
        if(!map.containsKey(key))
        {
            return -1;
        }
        CacheInfo info = map.get(key);
        dq.remove(info);
        dq.addFirst(info);
        return info.value;
    }
    
    public void put(int key, int value) 
    {
        if(map.containsKey(key))
        {
           CacheInfo info = map.get(key);
           dq.remove(info);
        }
        else if(map.size()>=capacity)
        {
            CacheInfo lastEntry = dq.removeLast();
            map.remove(lastEntry.key);
        }

        CacheInfo newInfo = new CacheInfo(key,value);
        map.put(key,newInfo);
        dq.addFirst(newInfo);
    }
}
