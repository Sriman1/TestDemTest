import java.util.ArrayList;

public class CountSubsets {

	static int subsets(int[] arr, int X, int index) {
		if(X==0) {
			return 1;
		}
		int sum=0;
		for(int i=index;i<arr.length;i++) {
			if(X>0) {
				sum+=subsets(arr, X-arr[i], i+1);
			}
		}
		return sum;
	}
	
	public static int solve(ArrayList<Integer> A) {
        int sum=0;
        for(int i:A){
            sum+=i;
        }
        return min(A,0,sum,0);
    }
    
  static  int min(ArrayList<Integer> A, int idx, int sum,int currSum){
        
        if(idx>A.size()-1){
            return Integer.MIN_VALUE;
        }
        if(currSum>sum/2){
            return Integer.MIN_VALUE;
        }
        
        int pick=min(A,idx+1,sum,currSum+A.get(idx));
        int noPick=min(A,idx+1,sum,currSum);
        
        return sum-Math.max(pick,noPick);
        
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,1,1,1};
		int X = 1;
System.out.println(subsets(arr, X,0));
	}

}
