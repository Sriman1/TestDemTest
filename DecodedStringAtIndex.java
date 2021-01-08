
public class DecodedStringAtIndex {

	
	 public static String decodeAtIndex(String S, int K) {
	        StringBuilder str=new StringBuilder();
	        int start=0;
	        int i;
	        for(i=0;i<S.length();i++){
	            if(Character.isDigit(S.charAt(i))){
	                if(start-i==0) {
	                	for(int j=0;j<(S.charAt(i)-'0')-1;j++) {
	                		str.append(str);
	                		  if(str.length()>K){
		                          
		                          return findChar(str,K);
		                      }
	                	}
	                }
	                else {
	                  for(int j=0;j<(S.charAt(i)-'0');j++){
	                    
	                        str.append(S.substring(start,i));
	                      if(str.length()>K){
	                          
	                          return findChar(str,K);
	                      }
	                }
	                }
	                start=i+1;
	            }
	    }
	        
            return findChar(str.append(S.substring(start,i)),K);

	  
	}
	    
	  static  String findChar(StringBuilder str,int K){
	        String res="";
	        for(int i=0;i<str.length();i++){
	            
	            if(i==K-1){
	                
	                return res+str.charAt(i);
	            }
	        }
	        return res;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		decodeAtIndex("abc", 1);

	}

}
