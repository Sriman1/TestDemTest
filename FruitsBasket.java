import java.util.HashMap;
import java.util.Map;

public class FruitsBasket {
	 public static int totalFruit(int[] tree) {
	        
		  
	        Map<Integer,Integer> map=new HashMap<>();
	        
	        
	        int i=0;
	        int j=0;
	        int max=Integer.MIN_VALUE;
	       
	        int newItem=0;
	        
	        while(j<tree.length){
	            
	            
	            
	            if(!map.containsKey(tree[j])){
	                
	                newItem++;
	            }
	            
	            map.put(tree[j],map.getOrDefault(tree[j],0)+1);
	            
	            
	            while(newItem>2){
	                
	                
	                
	                if(map.get(tree[i])==1){
	                    
	                    newItem--;
	                     
	                }
	                
	                    map.put(tree[i],map.getOrDefault(tree[i],0)-1);
	                    
	                    if(map.get(tree[i])==0){
		                    
		                   map.remove(tree[i]);
		                     
		                }
	                    i++;
	            }
	            
	            max=Math.max(max,j-i+1);
	            j++;
	            
	        }
	        
	        
	        return max;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tree= {3,3,3,1,2,1,1,2,3,3,4};
		totalFruit(tree);
	}

}
