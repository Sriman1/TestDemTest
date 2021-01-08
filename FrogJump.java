import java.util.HashSet;
import java.util.Set;

public class FrogJump {
	 public static boolean canCross(int[] stones) {
	        
	        Set<Integer> set=new HashSet<>();
	        for(int i:stones) set.add(i);
	        return cross(stones,1,1,stones[stones.length-1],set);
	        
	    }
	    
	   static  boolean cross(int[] stones,int jumps,int currStone,int lastStone,Set <Integer> set){
	        
	        if(currStone>lastStone){
	            return false;
	        }
	        if(currStone==lastStone){
	            return true;
	        }
	        
	        if(!set.contains(currStone)){
	            return false;
	        }
	        
	        
	        
	        if(currStone==1&&jumps==1||jumps-1==0){
	            
	            return cross(stones,jumps+1,currStone+jumps+1,lastStone,set)||cross(stones,jumps,currStone+jumps,lastStone,set);
	        }
	        
	        
	        
	        return cross(stones,jumps-1,currStone+jumps-1,lastStone,set)||cross(stones,jumps+1,currStone+jumps+1,lastStone,set)||cross(stones,jumps,currStone+jumps,lastStone,set);
	        
	        
	        
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		canCross(new int[] {0,1,3,5,6,8,12,17});
	}

}
