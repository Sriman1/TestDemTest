
public class CountOfSubsets {

	
	public static int subSets(int[] arr ,int X) {
		
		
		
		
		return totalSub(arr,X,0);
		
	}
	private static int totalSub(int[] arr, int x, int index) {
		if(x==0) return 1;
		if(index>arr.length-1) return 0;
	
		return totalSub(arr, x-arr[index], index+1)+
			
		totalSub(arr, x, index+1);
	
		
		
	}
	
	public static int subsetsDiff(int[] nums, int diff) {
		int sum=0;
		for(int i:nums) sum+=i;
		
		return diff(nums,sum-diff,0);
		
	}
	
	private static int diff(int[] nums, int target, int index) {
		
		if(target==0) return 1;
		if(index>nums.length-1) return 0;
		int subsets=0;
		
		
		subsets+=diff(nums, target-nums[index], index+1);
		subsets+=diff(nums, target, index+1);
		return subsets;
		
	}
	public static boolean subsetSum(int[] arr, int x ,int index) {
		
		if(x==0) return true;
		if(index>arr.length-1) return false;
		
		for(int i=index;i<arr.length;i++) {
			
			if(subsetSum(arr, x-arr[i], i+1)) {
				return true;
			}
		}
		
		return false;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int arr[] = {1,1,1,1}; int X = 1;
		System.out.println(subSets(arr, X));
	}

}
