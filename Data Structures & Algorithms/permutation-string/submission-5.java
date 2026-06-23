class Solution {
    public boolean checkInclusion(String s1, String s2) 
    {
        if(s1.length()>s2.length() || s1.length()>0 &&s2.length()<=0)
            return false;

       int[] s1FreqArr = new int[26];
       int[] s2FreqArr = new int[26];

       int st=0;
       while(st<s1.length())
       {
        s1FreqArr[s1.charAt(st)-'a']++;
        s2FreqArr[s2.charAt(st)-'a']++;
        st++;
       }
        st=0;
        
        for(int ed=s1.length();ed<s2.length();ed++)
        {
            if(Arrays.equals(s1FreqArr,s2FreqArr))
                return true;
            char curr = s2.charAt(ed);
            st = ed-s1.length();
           s2FreqArr[s2.charAt(st)-'a']--;
           s2FreqArr[curr-'a']++;
        }

        return Arrays.equals(s1FreqArr,s2FreqArr);
    }
}

//  abc -> binary  111000...z

//a->1->0 REMOVE
//b->1 ->0 REMOVE
//c->1->0  REMOVE

//s1Len=3-> 2 -> 1 -> 0

//   0 1 2 3 4 5 6 
// //l e c a b e e
// //s1len ONLY if map[currCharATed]==0

// {
// IF(map.size()==0)
// return true
// }
// map.size()==0 ? true: false;


// //a->1->0
// //b->1
// //c->1->0 
//      0 1 2 3 4 5 6 7   
// //s2 l e c a a b e e

// st   ed   currCharEd  map    s1len
// 0    0       l         RS     3
// 0    1       e         RS     3
// 0    2       c      c->0      2
// 0    3       a      a->0      1
// 0    4       a      a->-1



