
public class GasStations {
	 public static int canCompleteCircuit(int[] gas, int[] cost) {
		   int total=0;
	        int n=gas.length;
	        for(int i=0;i<n;i++){
	        	total=0;
	            if(total+gas[i]-cost[i]<0) continue;
	            else total+=gas[i]-cost[i];
	            for(int j=(i+1)%n;j<2*n;j++){
	                if(total+gas[j%n]-cost[j%n]<0) break;
	                
	                else{
	                    total+=gas[j%n]-cost[j%n];
	                    if(j%n==i) return i;
	                }
	            }
	        }
	        return -1;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[] gas  = new int []{5,1,2,3,4};
				int[] cost =new int[] {4,4,1,5,1};
				
				canCompleteCircuit(gas, cost);
	}

}
