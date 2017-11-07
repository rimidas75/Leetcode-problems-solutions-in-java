package edu.buffalo.liveramp;

import java.util.Arrays;
import java.util.Collections;

public class maxTime {
	String maxString  = "";
	public static void main(String[] args) {
		maxTime mt = new maxTime();
		String s = mt.findMaxTime(new int[]{2,4,0,0});
		System.out.println(s.substring(0,2)+":"+s.substring(2));
	}

	private String findMaxTime(int[] is) {
		Arrays.sort(is);
		
		for(int i = 0; i< (is.length)/2; i++)
			{
			int temp = is[i];
			is[i] = is[is.length-i-1];
			is[is.length-i-1] = temp;
			}
		
		int c = 0;
		//Boolean[] bArr = new Boolean[is.length];
		StringBuilder sb  ;
		while(c<is.length)
		{  sb = new StringBuilder();
		for(int i = 0;i<is.length;i++)
		{
			sb = sb.append(is[i]);
		}
		//System.out.println(sb);
		checkforString(sb);
		//rotate array
		is  = rotate(is);
		
		c++;
		}
		return maxString;
		
		
	}

	private int[] rotate(int[] is) {
		int temp = is[0];
		for(int f = 0;f<is.length-1;f++)
		{
			is[f] = is[f+1];
		}
		is[3] = temp;
		
		return is;
		
		
	}

	private boolean checkforString(StringBuilder sb) {
	char[] arr = sb.toString().toCharArray();
		String hh = sb.substring(0, 2);
		StringBuilder hh_swap = new StringBuilder();
		hh_swap = hh_swap.append(arr[1]).append(arr[0]);
		String mm = sb.substring(2, 4);
		StringBuilder mm_swap = new StringBuilder();
		mm_swap = mm_swap.append(arr[3]).append(arr[2]);
		String finalStr = "";
		//System.out.println(hh + " " +hh_swap + " "+ mm + " " +mm_swap);
		// for hours
	if((hh.compareTo("23")<0 || hh.compareTo("23")==0) && (hh_swap.toString().compareTo("23")<0 || hh_swap.toString().compareTo("23")==0))
	{
		String hour = hh.compareTo(hh_swap.toString())>0? hh : hh_swap.toString();
			finalStr = finalStr+ hour ;
	}
	else if(hh.compareTo("23")<0 || hh.compareTo("23")==0)
	{
		finalStr = finalStr+ hh ;
	}
	else if(hh_swap.toString().compareTo("23")<0 || hh_swap.toString().compareTo("23")==0)
	{
		finalStr = finalStr+ hh_swap.toString() ;
	}
			
	//System.out.println("after hours = "+ finalStr);
	if(finalStr.equals(""))
		return false;
	// for mins
	boolean changed = false;
	if((mm.compareTo("59")<0 || mm.compareTo("59")==0)&& (mm_swap.toString().compareTo("59")<0 || mm_swap.toString().compareTo("59")==0))
	{
		String min = mm.compareTo(mm_swap.toString())>0? mm : mm_swap.toString();
			finalStr = finalStr+ min ;
			changed = true;
	}
	else if(mm.compareTo("59")<0 || mm.compareTo("59")==0)
	{
		finalStr = finalStr+ mm ;
		changed = true;
	}
	else if(mm_swap.toString().compareTo("59")<0 || mm_swap.toString().compareTo("59")==0)
	{
		finalStr = finalStr+ mm_swap.toString() ;
		changed = true;
	}
	if(!changed)
		return false;
	
	if(finalStr.compareTo(maxString)>0)
		maxString  = finalStr;
	
		return true;
	
	}

}
