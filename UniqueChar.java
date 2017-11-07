package edu.buffalo.liveramp;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UniqueChar {
	public static void main(String[] args) {
		UniqueChar c  = new UniqueChar();
		c.findUniqueCommon("rimi das","rimjhim pandey");
		
		
		
	}

	private void findUniqueCommon(String string, String string2) {
		char[] c1  = string.toCharArray();
		char[] c2  = string2.toCharArray();
		Set<Character> uni = new HashSet<Character>();
		Set<Character> com = new HashSet<Character>();
		for(int i = 0;i<c1.length;i++)
		{
			uni.add(c1[i]);
		}
		for(int i = 0;i<c2.length;i++)
		{
			if(uni.contains(c2[i]))
			{
				
				com.add(c2[i]);
				
			}
			else
			{
				uni.add(c2[i]);
			}
			
		}
		Iterator iter = com.iterator();
		while (iter.hasNext()) {
			char c  = (Character) iter.next();
		    if(uni.contains(c))
		    	uni.remove(c);
		}
		
		System.out.println(uni + "\n" + com);
	}

}
