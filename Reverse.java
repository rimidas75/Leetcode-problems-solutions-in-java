
class Reverse {
	public static void main(String[] args) {
		Reverse s = new Reverse();
		try {
			System.out.println(s.reverse(-13456));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int reverse(int x) {
		if (x <= Integer.MIN_VALUE || x >= Integer.MAX_VALUE)
			return 0;
		long result = 0;
		int pos = 1;
		if (x < 0)
			pos = -1;
		if (pos < 0)
			x = x * (-1);
		int n = x;
		int reverse = 0;
		int r = 0;
		while (n > 0) {
			r = n % 10;
			result = ((long) reverse) * ((long) 10);
			// System.out.println("reverse now = " + reverse);
			if (result <= Integer.MIN_VALUE || result >= Integer.MAX_VALUE)
				reverse = 0;
			else
				reverse = reverse * 10 + r;
			n = n / 10;
		}
		if (pos < 0)
			result = ((long) reverse) * ((long) -1);
		if (result <= Integer.MIN_VALUE || result >= Integer.MAX_VALUE)
			reverse = 0;
		else
			reverse = reverse * (-1);
		reverse = reverse * (-1);

		return reverse;

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