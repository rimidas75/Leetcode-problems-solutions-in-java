package edu.buffalo.liveramp;

public class MinimumSort {
	
	public int minSort(int[] nums){
		
		int i=0;
		int j=nums.length-1;
		while(i<nums.length-1 && nums[i]<=nums[i+1]){
			i++;
		}
		while(j>0 && nums[j]>=nums[j-1])
			j--;
		int[] minmax= findMinMax(nums,i,j);
		int minSearch = binaryMinSearch(nums,0,i-1,minmax[1]);
		int maxSearch = binaryMaxSearch(nums,j+1,nums.length-1,minmax[0]);
		//int maxSearch = maxSearch(nums,nums.length-1,j+1,minmax[0]);
		//int minSearch = minSearch(nums,0,i-1,minmax[1]);
		System.out.println("minsearch and axsearch == "+ minSearch + " "+ maxSearch);
		return (maxSearch!=-1 ? maxSearch : j) - (minSearch!=-1 ? minSearch : i) + 1;
		
	}
	
	public int[] findMinMax(int[] nums , int start , int end){
		
		System.out.println(start + " "+ end);
		int max=Integer.MIN_VALUE;
		int min =Integer.MAX_VALUE;
		for(int i=start;i<=end;i++){
			if(nums[i]>max)
				max=nums[i];
			if(nums[i]<min)
				min=nums[i];
		}
		System.out.println(" max min - "+ max + " "+ min);
		return new int[]{max,min};
		
	}
	
	/*public int minSearch(int[] nums,int start , int end ,int value){
		
		for(int i=start;i<=end;i++){
			
			if(nums[i]>value)
				return i;
		}
		
		return -1;
		
	}*/
	
	public int binaryMinSearch(int[] nums , int start , int end , int value){
		System.out.println("binary min value = "+ value);
		while(start<end){
			
			int mid = start + (end-start)/2;
			if(nums[mid]<=value)
				start=mid+1;
			else
				end=mid;
			
		}
		return nums[start]>value ? start : -1;
		
	}
	
public int binaryMaxSearch(int[] nums , int start , int end , int value){
		System.out.println("binary max value = "+ value);
		while(start<end){
			
			int mid = start + (end-start)/2;
			if(nums[mid]<value)
				start=mid+1;
			else
				end=mid;
			
		}
		return nums[start]>=value ? start-1 : -1;
		
	}
	
	/*public int maxSearch(int[] nums ,int start , int end,int value){
		
		for(int i=start;i>=end;i--){
			
			if(nums[i]<value)
				return i;
			
		}
		
		return -1;
		
	}*/

	public static void main(String[] args) {
		MinimumSort ms = new MinimumSort();
		System.out.println(ms.minSort(new int[]{0, 1,6, 15, 25, 6,45, 7, 30, 40,45, 50}));
	}

}
