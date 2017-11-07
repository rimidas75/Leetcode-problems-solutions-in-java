package edu.buffalo.liveramp;
public class MaximumTime {
	
	String maxString="";
	
	public String maxTime(int[] nums){
		backtrack("",nums,new boolean[nums.length]);
		return maxString.equalsIgnoreCase("") ? "Not Possible" : (maxString.substring(0, 2)+":"+maxString.substring(2));
	}
	
	public void backtrack(String tempStr ,int[] nums,boolean[] used){
		
		if(tempStr.length()==nums.length){
			
			if(!(tempStr.substring(0,2).compareTo("23")>0 
					 || tempStr.substring(2,4).compareTo("59")>0)){
				if(tempStr.compareTo(maxString)>0)
					maxString=tempStr;
			}
		}
		
		for(int i=0;i<nums.length;i++){
			
			if(used[i] || (i>0 && nums[i]==nums[i-1] && !used[i-1])) continue;
			used[i]=true;
			tempStr=tempStr+nums[i];
			backtrack(tempStr,nums,used);
			used[i]=false;
			tempStr=tempStr.substring(0,tempStr.length()-1);
			
		}
		
		
		
	}

	public static void main(String[] args) {
		MaximumTime mt = new MaximumTime();
		System.out.println(mt.maxTime(new int[]{9,2,1,9}));
	}

}
