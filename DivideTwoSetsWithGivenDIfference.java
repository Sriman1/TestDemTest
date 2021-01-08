
public class DivideTwoSetsWithGivenDIfference {

	
	public static int diffSubsets(int[] arr,int diff) {
		int sum=0;
		for(int i: arr) sum+=i;
		return diffSubsets(arr,diff,0,0,sum);
	}
	private static int diffSubsets(int[] arr, int diff, int index,int currSum,int sum ) {
		if(Math.abs(currSum-sum)==diff) {
			return 1;
		}
		if(index>arr.length-1) return 0;

		
		int addToSet=diffSubsets(arr,diff,index+1,currSum+arr[index],sum-arr[index]);
		int skipElement=diffSubsets(arr, diff, index+1, currSum, sum);
		
		return addToSet+skipElement;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] arr= {3,1,2,3};
int diff=3;
diffSubsets(arr, diff);
	}

}
