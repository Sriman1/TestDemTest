
public class DecodeString {
	public static String decodeString(String s) {
        java.util.Stack<String> st=new java.util.Stack<>();
        java.util.Stack<Integer> in=new java.util.Stack<>();
        int index=0;
        String res="";

     while(index<s.length()){
         
         if(Character.isDigit(s.charAt(index))){
            int count=0;
            while(Character.isDigit(s.charAt(index)))
            {
                count=count*10+s.charAt(index)-'0';
                index++;
                
            }
             in.push(count);   
         }
         
         else if(s.charAt(index)=='['){
             
             st.push(res);
             res="";
             index++;
             
         }
         else if(s.charAt(index)==']'){
             StringBuilder sb=new StringBuilder(st.pop());

            
             int popped=in.pop();
//             String ap=st.pop();
             for(int i=0;i<popped;i++){
                 
                 sb.append(res);
                 
             }
            
             index++;
             res=sb.toString();
             
         }
         else{
             
             res+=s.charAt(index);
             index++;
         }

         
     }
       
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="2[abc]3[cd]ef";
		decodeString(s);

	}

}
