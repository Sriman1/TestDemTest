import java.util.HashMap;
import java.util.Map;

public class InterleavingStrings {

	    public static boolean isInterleave(String s1, String s2, String s3) {
	               
	        if(s1.length()+s2.length()!=s3.length()) return false;

	        Map<String,Boolean> map=new HashMap<>();
	        return isInterleaved(s1,s2,s3,0,0,0,map);
	        
	    }
	    
	    
	   static boolean isInterleaved(String s1,String s2 ,String s3,int p1, int p2, int p3,Map<String,Boolean> map){
	        
	        if(p3>s3.length()-1) return true;
	        
	        if((p1>s1.length()-1&&s1.length()!=0)||p2>s2.length()-1&&s2.length()!=0) return true;
	        String key=p1+"*"+p2+"*"+p3;
	        if(map.containsKey(key)) return map.get(key);
	        
	        boolean possible=false;
	        if(s3!=null&&(s1.length()==0||s2.length()==0)) return false;
	        if(s3.charAt(p3)!=s1.charAt(p1)&&s3.charAt(p3)!=s2.charAt(p2)) possible= false;
	        
	        
	        else if(s3.charAt(p3)==s1.charAt(p1)&&s3.charAt(p3)==s2.charAt(p2)){
	            
	            
	            possible= isInterleaved(s1,s2,s3,p1+1,p2,p3+1,map)||isInterleaved(s1,s2,s3,p1,p2+1,p3+1,map);
	            
	            
	        }
	        
	        else if(s3.charAt(p3)==s1.charAt(p1)){
	            
	            possible= isInterleaved(s1,s2,s3,p1+1,p2,p3+1,map);
	        }
	         
	        else if(s3.charAt(p3)==s2.charAt(p2)){
	             possible= isInterleaved(s1,s2,s3,p1,p2+1,p3+1,map);
	     }
	 
	        map.put(key,possible);
	        
	        return map.get(key);
	        
	    }
	
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="a";
		String s2="";
		String s3="c";
		isInterleave(s1, s2, s3);
		

	}

}
