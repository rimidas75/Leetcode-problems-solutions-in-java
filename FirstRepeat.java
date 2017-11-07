package edu.buffalo.liveramp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstRepeat {
	public static void main(String[] args) {
		FirstRepeat f = new FirstRepeat();
		f.findFirstRepeat("rabdfjuolpppnhydh");
		
	}

	private void findFirstRepeat(String string) {
		char[] rr = string.toCharArray();
		int index = 0;
		int minIndex = Integer.MAX_VALUE;
		Map<Character,Integer> mp = new HashMap<Character,Integer>();
		for(int i = 0;i<rr.length;i++)
		{
			if(!mp.containsKey(rr[i]))
			{	mp.put(rr[i], i);
			//index ++;
			}
			else
			{
				minIndex = Math.min(minIndex, mp.get(rr[i]));
			}
		}
		
		System.out.println(rr[minIndex]);
				
				
		}
		
	

}
