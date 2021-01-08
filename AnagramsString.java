import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramsString {
	 public static List<Integer> findAnagrams(String s, String p) {
	        List<Integer> list=new ArrayList<>();
	        int i=0;
	        while(i<s.length()-p.length()+1){
	          
	            if(check(s.substring(i,i+p.length()),p)){
	                
	                list.add(i);
	            }
	            
	            i++;
	            
	    }
	        return list;
	 }
	        
	        
	        static boolean check(String str, String p){
	            char[] strArr=str.toCharArray();
	            char[] pArr=p.toCharArray();
	        	Arrays.sort(strArr);
	        	Arrays.sort(pArr);		
	          for(int i=0;i<strArr.length;i++) {
	            
	            if(strArr[i]!=pArr[i]) return false;
	          }
	          
	          return true;
	        }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "abab";String p= "ab";
		findAnagrams(s, p);
	}

}
