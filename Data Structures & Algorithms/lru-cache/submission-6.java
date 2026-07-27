class CacheEntries
{
	int key;
	int value;
	
	public CacheEntries(int key, int value)
	{
		this.key = key;
		this.value = value;
	}
	
}

class LRUCache 
{
     int capacity = 0;
	Map<Integer, CacheEntries> map = new HashMap<>();
	Deque<CacheEntries> deque = new LinkedList<>();
	
    public LRUCache(int capacity) 
    {
        this.capacity = capacity;
    }
    
    public int get(int key) 
    {
    	if(map.containsKey(key))
    	{
    		CacheEntries getVal = map.get(key);
    		deque.remove(getVal);
    		deque.addFirst(getVal);
    		
    		return getVal.value;
    	}
    	
        return -1;
    }
    
    // 1 1
    // 2 2
    // .. 3 3
    public void put(int key, int value) 
    {
    	if(map.containsKey(key))
    	{
    		CacheEntries existingEntry = map.get(key);
    		deque.remove(existingEntry);
    	}
    	
    	else if(map.size() >= capacity)
    	{
    		CacheEntries lastEntry = deque.removeLast();
    		map.remove(lastEntry.key);
    	}
    	
    	CacheEntries newEntry = new CacheEntries(key, value);
		map.put(key, newEntry);
		deque.addFirst(newEntry);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */