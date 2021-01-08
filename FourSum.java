import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	
	 public static List<List<Integer>> fourSum(int[] nums, int target) {
	       Arrays.sort(nums);
	       List<List<Integer>> res=new ArrayList<>();
		 for(int i=0;i<nums.length-3;i++) {
			 List<List<Integer>> l=threeSum(nums,target-nums[i],i);
		     for(List<Integer> list:l) {
		    	if(list.size()==3) {
		    		list.add(0,nums[i]);
		    	}
		    	res.add(list);
		     }
		 }
	return res;
	}
	 
	 
	 public static List<List<Integer>> threeSum(int[] nums,int target,int first) {
	        
	  
	        
	        List<List<Integer>> res=new ArrayList<>();
	        for(int i=first;i<nums.length-2;i++){
	            
	          
	            
	            
	            if(i==0||nums[i]!=nums[i-1]){
	                
	                int start=i+1;
	                int end=nums.length-1;
	                
	                while(start<end){
	                    
	                    
	                    if(nums[i]+nums[start]+nums[end]==target){
	                        List<Integer> curr=new ArrayList<>();
	                        curr.add(nums[i]);
	                        curr.add(nums[start]);
	                        curr.add(nums[end]);
	                        
	                        res.add(curr);
	                         int currEnd=end;
	                        
	                        while(nums[end]==nums[currEnd]&&end>start){
	                            
	                            end--;
	                        }
	                          int currStart=start;
	                        while(nums[start]==nums[currStart]&&start<end){
	                            start++;
	                        }
	                    }
	                    
	                    else if(nums[i]+nums[start]+nums[end]>0){
	                        
	                        int currEnd=end;
	                        
	                        while(nums[end]==nums[currEnd]&&end>start){
	                            
	                            end--;
	                        }
	                        
	                    }
	                    else{
	                        
	                        int currStart=start;
	                        while(nums[start]==nums[currStart]&&start<end){
	                            start++;
	                        }
	                    }
	                    
	                }
	                
	                
	            }
	            
	            
	            
	        }
	        return res;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
fourSum(new int[] {-2,-1,0,0,1,2}, 0);
	}

}
