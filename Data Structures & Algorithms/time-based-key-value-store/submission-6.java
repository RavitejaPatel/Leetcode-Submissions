class TimeMapValues
{
    public String val;
    public int time;

    public TimeMapValues(String val, int time)
    {
        this.val = val;
        this.time = time;
    }
}

class TimeMap 
{
    Map<String, List<TimeMapValues>> map;

    public TimeMap() 
    {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) 
    {
        if(!map.containsKey(key))
            map.put(key, new ArrayList<TimeMapValues>());

        map.get(key).add(new TimeMapValues(value, timestamp));
    }
    
    public String get(String key, int timestamp) 
    {
        String res = "";

        if(!map.containsKey(key))
            return res;


        List<TimeMapValues> keyList = map.get(key);
        int st = 0;
        int ed = map.get(key).size()-1;
        

        while(st<=ed)
        {
            int mid = (st+ed)/2;
            TimeMapValues currTSdetailsAtMid = keyList.get(mid);

            int currTSatMid = currTSdetailsAtMid.time;

            if(currTSatMid == timestamp)
                return currTSdetailsAtMid.val;
            
            else if(currTSatMid<timestamp)
            {
                res = currTSdetailsAtMid.val;
                st = mid+1;
            }
            else
                ed = mid-1;
        }
        return res;
    }
}
