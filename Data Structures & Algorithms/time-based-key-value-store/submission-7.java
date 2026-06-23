class MapVal 
{
    String value;
    int timestamp;

    public MapVal(String value, int timestamp) 
    {
        this.value = value;
        this.timestamp = timestamp;
    }
}

class TimeMap 
{
    Map<String, List<MapVal>> map;
    public TimeMap() 
    {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) 
    {
        if(!map.containsKey(key))
        {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new MapVal(value, timestamp));
    }
    
    public String get(String key, int timestamp) 
    {
        if (!map.containsKey(key)) 
        {
            return "";
        }

        List<MapVal> mapValList = map.get(key);

        int st = 0;
        int ed = mapValList.size()-1;
        String res = "";

        while(st<=ed)
        {
            int mid = (st+ed)/2;
            MapVal curr = mapValList.get(mid);
            if(timestamp == curr.timestamp)
            {
                return  curr.value;  
            }
            if(timestamp>curr.timestamp)
            {
                res = curr.value;
                st = mid+1;
            }
            else
                ed = mid-1;
        }
        return res;
    }
}
