package edu.buffalo.liveramp;

public class RemoveArrayDuplicates {


    public int removeDuplicates(int[] nums) {
        int c= 0;
        int p =1;
        if(nums.length<=1)
            return nums.length;
        
        for(int i = 0;i<nums.length -1 ;i++)
        {
            int curr = nums[i];
            int next = nums[i+1];
            if(curr==next)
            {
                if(i+2 < nums.length)
                { 
                    
                    nums[i+1] = nums[i+2];
                    if(nums[i+2] != curr ) 
                    {
                        nums[p] = nums[i+2];
                        c++;
                        p= p+1;
                    }
                    
                }
                else
                    c++;
                
            }
            else 
            {
                if(i+1 ==nums.length -1)
                    c+=2;
                else
                {
                    c++;
                    p= p+1;
                }
            }
                
        }
       return c; 
    }
}