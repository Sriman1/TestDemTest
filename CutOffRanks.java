import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class CutOffRanks {
	 public static int cutOffRank(int cutOffRank, int num, int[] scores) {
	        
	       Map<Integer,Queue<Integer>> map=new HashMap<>();
	       PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
	       int[] ranks=new int[scores.length];
	       
	       for(int s:scores){
	           pq.add(s);
	       }
	       
	       for(int i=0;i<scores.length;i++){
	    	   if(map.containsKey(scores[i])) {
	    		   map.get(scores[i]).add(i);
	    		   continue;
	    	   }
	           
	           map.put(scores[i],new ArrayDeque<>());
	           map.get(scores[i]).add(i);
	       }
	       
	       
	     
	       int rank=1;
	       while(!pq.isEmpty()){
	           
	           int curr=pq.poll();
	           int counter=0;
	           while(!map.get(curr).isEmpty()){
	               ranks[map.get(curr).poll()]=rank;
	               counter++;
	               
	           }
	           
	           rank+=counter;
	           
	       }
	       int result=0;
	       for(int i:ranks){
	           
	           if(i<=cutOffRank) result++;
	           
	       }
	        
	        return result;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores= {1,2};
		int num=2;
		int cutOff=1;
		cutOffRank(cutOff, num, scores);

	}

}
