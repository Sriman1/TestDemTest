
public class BasicCalculator {
	  public static int calculate(String s) {
	        java.util.Stack<String> st=new java.util.Stack<>();
	                s = s.replaceAll("\\s+","").trim();
	if(s==null||s.length()==0||s.length()==1) return Integer.parseInt(s);
	        int ans=0;
	        
	     boolean allNumbers=true;
	        int num=0;
	        for(int i=0;i<s.length();i++){
	            
	            if(Character.isDigit(s.charAt(i))) {
	            	
	               num= num*10+Integer.parseInt(String.valueOf(s.charAt(i)));
	            
	            }
	            else{
	            	allNumbers=false;
	                st.push(Integer.toString(num));
	                 st.push(Character.toString(s.charAt(i)));
	                    num=0;
	            }
	        }
	        if(allNumbers) return Integer.parseInt(s);

	        st.push(Integer.toString(num));
	       
	        int befOp=0;
	        int afOp=0;
	        boolean opSet=false;
	        String op="";
	        while(st.size()>0){
	            
	            String str= st.pop();
	            
	            //String someString = "123123";
	boolean isNumeric = str.chars().allMatch( Character::isDigit );
	            if(isNumeric&&!opSet){
	                befOp=Integer.parseInt(str);
	            }
	            
	            else if(!isNumeric){
	                if(str.equals("/")) op="/";
	                else if(str.equals("*")) op="*";
	                else if(str.equals("+")) op="+";
	                else op="-";
	                opSet=true;
	            }
	            else{
	                afOp=Integer.parseInt(str);
	                opSet=false;
	                    if(op=="/") ans=afOp/befOp;
	                else if(op=="*") ans=afOp*befOp;
	                else if(op=="+") ans=afOp+befOp;
	                else ans=afOp-befOp;

	                if(st.size()==0) return ans;
	               else st.push(Integer.toString(ans));
	  
	            }

	        }
	        
	        return Integer.parseInt(String.valueOf(st.pop()));
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String s="3+2*2";
calculate(s);
	}

}
