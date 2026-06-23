class Solution {

    public boolean isPalindrome(String s) 
	 {
		
		 String str = sanitizeString(s);
		 int st = 0;
		 int ed = str.length()-1;
		 System.out.println(str);
		 while(st<ed)
		 {
			 if(Character.toLowerCase(str.charAt(st)) !=Character.toLowerCase(str.charAt(ed)) )
				 return false;
			 st++;
			 ed--;
		 }
	        return true;
	 }
	 
	 private String sanitizeString(String s)
	 {
		 StringBuilder sanitizedStr = new StringBuilder();
		 
		 for(char c : s.toCharArray())
		 {
			 if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) 
			 {
				 sanitizedStr.append(c);
			}
			 else
				 continue;
		 }
		 return sanitizedStr.toString();
	 }
}
