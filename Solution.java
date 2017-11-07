package edu.buffalo.liveramp;

public class Solution {
	
	    public int solution(int[] A) {
	        // write your code in Java SE 8
	        int j = 0,k = 0;
	        for(int i = 0;i<A.length;i++)
	        {
	            j = 0;
	          k = i+1;
	          int sum_I = 0;
	          int sum_J = 0;
	          // System.out.println(i);
	            while(j<i)
	            {
	                sum_I = sum_I +A[j];
	               
	                j++;
	                
	            }
	            System.out.println(sum_I);
	            while(  k<=A.length-1)
	            {
	                sum_J = sum_J +A[k];
	                //System.out.println( k + " ");
	                k++;
	            }
	           System.out.println(sum_J);
	            if(sum_I== sum_J)
	            {
	                //System.out.println(sum_I + " "+i);
	                 return i;
	            }
	           
	        }
	        return -1;
	    }
	    public static void main(String[] args) {
			Solution s  = new Solution();
			int  i = s.solution(new int[]{0, 1111111111, -111111111});
			System.out.println(i);
					
		}
}
