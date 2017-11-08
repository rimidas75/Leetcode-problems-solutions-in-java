
class RomanToInt {
	public static void main(String[] args) {
		RomanToInt s = new RomanToInt();
		try {
			System.out.println(s.romanToInt("CMXCVIII"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public int romanToInt(String s) {
		int finalNum = 0;
		for(int i = 0;i<=s.length()-1;i++)
	       {
			// System.out.println(i);
	           char curr = s.charAt(i);
	           if(i<s.length() && i+1 <s.length())
	           {   
	           char next = s.charAt(i+1);
	          
	           if(romanCharToInt(curr) >= romanCharToInt(next))
	           {
	        	   finalNum  = finalNum+romanCharToInt(curr);
	        	  /* if(i+1 == s.length()-1)
	        		   finalNum  = finalNum+ romanCharToInt(next);*/
	           }
	           else
	           {
	        	   finalNum  = finalNum - romanCharToInt(curr) +romanCharToInt(next);
	        	   i ++;
	           }
	           }
	           else
	           {
	        	   finalNum  = finalNum+romanCharToInt(curr); 
	           }
	          // System.out.println(finalNum);
	       }
		return finalNum;
		
	}
	public int romanCharToInt(char x)
	{
		
		 switch(x)
         {
             case 'I':return 1;
             case 'V':return 5;  
             case 'X':return 10; 
             case 'L':return 50; 
             case 'C':return 100; 
             case 'D':return 500;
             case 'M':return 1000;
         }
		return 0;
	}
}