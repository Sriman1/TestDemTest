
public class CountSubsetsSatisfyCondition {
	static int count=0;
	public static int totalSubsets(int[] arr,int divisor) {
		
		
		 numSubsets(arr,0,divisor);
		 return count;
	}

	private static int numSubsets(int[] arr, int index, int divisor) {
		if(index>arr.length-1) return 0;
		
		int pick=arr[index]+numSubsets(arr,index+1,divisor);
		int noPick=numSubsets(arr,index+1,divisor);
		
		if((pick!=0&&pick%divisor==0)||(noPick!=0&&noPick%divisor==0)) {
			count++;
		}
		
	return pick+noPick;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,4,3,7};
		int x=2;
		totalSubsets(arr, x);

	}

}
