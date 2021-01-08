import java.util.Collections;
import java.util.PriorityQueue;

public class FindtheHighestProfit {
	
	public static long highProfit(int suppliers,int[] inventory,int order) {
		
		
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i:inventory) pq.add(i);
		
	long ans=0;	
		while(order>0) {
			
			int count=0;
			int polled=pq.poll();
			count+=1;
			
			while(!pq.isEmpty()&&polled==pq.peek()&&order>0) {
				count++;
				pq.poll();
				order-=count;
			}
			
			if(!pq.isEmpty()&&polled!=pq.peek()) {
				order--;
			}
			ans+=polled*count;
			
			
			
			
			
			while(count-->0) {
				pq.add(polled-1);
			}
			
			
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int suppliers=2;
		int[] inventory= {3,5};
		int order=8;
		
		highProfit(suppliers, inventory, order);

	}

}
