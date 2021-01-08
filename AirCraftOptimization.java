import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AirCraftOptimization {

	public static List<List<Integer>> optimized(int traveldist,int[][] forward, int[][] backward){
		
		Arrays.sort(forward,new Comparator<int[]>() {
			
			
			public int compare(int[] a,int [] b) {
				
				return a[1]-b[1];
			}
		});
	Arrays.sort(backward,new Comparator<int[]>() {
			
			
			public int compare(int[] a,int [] b) {
				
				return a[0]-b[0];
			}
		});
	
	int i=0;
	int j=backward.length-1;
	List<List<Integer>> result=new ArrayList<>();
	int optimal=Integer.MIN_VALUE;
	int idx=0;
	while(i<forward.length&&j>=0) {
		int miles=forward[i][1]+backward[j][1];
		if(miles>optimal&&miles<=traveldist) {
			result.clear();
			result.add(new ArrayList<>());
			result.get(0).add(forward[i][0]);
			result.get(0).add(backward[j][0]);
			optimal=miles;
			idx=1;
			i++;
		}
		else if(miles==optimal&&miles<=traveldist) {
			result.add(idx,new ArrayList<>());
			result.get(idx).add(forward[i][0]);
			result.get(idx).add(backward[j][0]);
			idx++;
			i++;
		}
		else if(miles>traveldist) {
			j--;
		}
		
	}
		
		return result;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxTravelDist=10000;
				int[][]forwardRouteList= {{1,3000},{2,5000},{3,7000},{4,10000}};
				int[][]returnRouteList= {{1,2000},{2,3000},{3,3000},{4,3000}};
	
				optimized(maxTravelDist,forwardRouteList,returnRouteList);
		}

}
