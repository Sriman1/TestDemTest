
public class DecodeStrings {
	 public static String decodeString(String s) {
	        java.util.Stack<String> inte=new java.util.Stack<>();
	        
	        java.util.Stack<String> cha=new java.util.Stack<>();
	        String res="";
	        
	        for(int i=0;i<s.length();i++){
	            
	            
	            if(Character.isDigit(s.charAt(i))){
	                
	            	  String num="";
	            	  int j=i;
	                  while(Character.isDigit(s.charAt(j))){
	                      num+=s.charAt(j);
	                      j++;
	                  }
	                  inte.add(num);
	                  i=j-1;
	            }
	            else if(s.charAt(i)=='['){
	                
	                cha.push(res);
	                res="";
	            }
	            else if(s.charAt(i)==']'){
	                StringBuilder sb=new StringBuilder(cha.pop());
	                int popped=Integer.parseInt(inte.pop());
	                
	                for(int j=0;j<popped;j++){
	                    sb.append(res);
	                }
	                res=sb.toString();
	                
	            }
	            
	            else{
	                res+=s.charAt(i);
	            }
	            
	            
	            
	        }
	        
	        return res;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "100[abc]";
		decodeString(s);
	}

}
