class LRUData
{
    int key;int value;
    public LRUData(int k,int v)
    {
        this.key=k;
        this.value=v;
    }
}
class LRUCache 
{
    Map<Integer,LRUData> map = null;
    Deque<LRUData> dq = null; 
    int capacity ;

    public LRUCache(int capacity) 
    {
        map = new HashMap<>();
        dq =  new LinkedList();
        this.capacity=capacity;
    }
    
    public int get(int key) 
    {
        if(map.containsKey(key))
        {
            LRUData data = map.get(key);
            dq.remove(data);
            dq.addFirst(data);
            return data.value;
        }
        return -1;
    }
    
    public void put(int key, int value) 
    {
        //addFirst(e) removeFirst() removeLast()
        if(map.containsKey(key))
        {
            LRUData data = map.get(key);
            System.out.println("removing data "+data.key+" "+data.value);
            dq.remove(data);
        }

        else if(map.size()>=capacity)
        {
            LRUData data = dq.removeLast();
            map.remove(data.key);
        }
         LRUData data = new LRUData(key,value); 
            dq.addFirst(data);
            System.out.println("adding data "+data.key+" "+data.value);
            map.put(key,data);  
        
    }

}
