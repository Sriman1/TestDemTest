
public class FloorInAnArray {

	
	public static int floor(int[] nums,int target) {
		
		
		int start=0;
		int end=nums.length-1;
		
		
		
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(nums[end]<=target) {
				return nums[end];
			}
			 if(nums[mid]==target) {
				return nums[mid];
			}
			else if(nums[mid]>target) {
				end=mid-1;
			}
			else {
				start=mid+1;
			}
			
		}
		if(start<0||end<0) return -1;
		if(start>end) return nums[end];
		
		return nums[start];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {2,4,5,6,8,9,11,12,15,17,18,21,24,26};
		int target=1;
		System.out.println(floor(nums,target));

	}

}
