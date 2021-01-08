import java.util.HashMap;
import java.util.Map;

public class ConsecutiveCharacters {
public static int maxPower(String s) {
        
        int j=0;
        int count=0;
        int max=0;
        int i=0;
        Map<Character,Integer> map=new HashMap<>();
        while(i<s.length()){
            
            
            if(map.get(s.charAt(i))==null||map.get(s.charAt(i))==0){
                count++;
            }
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);

            while(count>1) {
            if(map.get(s.charAt(j))==1){      
                count--;
            }
            map.put(s.charAt(j),map.get(s.charAt(j))-1);

            	j++;
            }
            
            i++; 
            max=Math.max(max,i-j);
           
        
        }
        
    
         //max=Math.max(max,i-j);
        return max;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abbcccddddeeeeedcba";
		maxPower(s);
		

	}

}
