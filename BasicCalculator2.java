
public class BasicCalculator2 {

	 public static int calculate(String s) {
	        
	        
	       java.util. Stack<Integer> stack=new java.util.Stack<>();
	        int i=0;
	        while(i<s.length()){
	            

	           
	            if(i<s.length()&&s.charAt(i)=='-'){
	                
	                i++;
	                int num=0;
	                while(i<s.length()&&Character.isDigit(s.charAt(i))){
	                    num=(num*10)+(s.charAt(i)-'0');
	                    i++;
	                }
	                stack.add(-1*num);
	            }
	            if(i<s.length()&&s.charAt(i)=='+'){
	                
	                i++;
	                int num=0;
	                while(i<s.length()&&Character.isDigit(s.charAt(i))){
	                    num=(num*10)+(s.charAt(i)-'0');
	                    i++;
	                }
	                stack.add(num);
	            }
	            
	            if(i<s.length()&&s.charAt(i)=='*'){
	                
	                int preMul=stack.pop();
	                i++;
	                int num=0;
	                while(i<s.length()&&Character.isDigit(s.charAt(i))){
	                    num=(num*10)+(s.charAt(i)-'0');
	                    i++;
	                }
	                stack.add(preMul*num);
	            }
	             if(i<s.length()&&s.charAt(i)=='/'){
	                
	                int preDiv=stack.pop();
	                i++;
	                int num=0;
	                while(i<s.length()&&Character.isDigit(s.charAt(i))){
	                    num=(num*10)+(s.charAt(i)-'0');
	                    i++;
	                }
	                stack.add(preDiv/num);
	            }
	           else{
	               int num=0;
	                while(i<s.length()&&Character.isDigit(s.charAt(i))){
	                    num=(num*10)+(s.charAt(i)-'0');
	                    i++;
	                }
	            
	            stack.add(num);
	        }
	    }
	        int res=0;
	        while(!stack.isEmpty()){
	            res+=stack.pop();
	        }
	        return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		calculate("3/2");
	}

}
