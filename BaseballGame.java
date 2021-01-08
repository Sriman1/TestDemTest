
public class BaseballGame {
    public static int calPoints(String[] ops) {

	java.util.Stack<Integer> stack=new java.util.Stack<>();
    int score=0;
    for(int i=0;i<ops.length;i++){
        
        try{
            int num=Integer.parseInt(ops[i]) ;
            stack.add(num);
        }
        
        catch(Exception e){
            
            if(ops[i].equals("+")){
                
                int num1=stack.pop();
                int num2=stack.pop();
                stack.push(num2);
                stack.push(num1);
                stack.push(num1+num2);
                
             
            }
            else if(ops[i].equals("D")){
                
                int num1=stack.peek();
                stack.add(num1*2);
                
            }
            
            else{
                
                
                stack.pop();
                
            }
            
        }
        
    }
    
    while(!stack.isEmpty()){
        score+=stack.pop();
    }
                

    return score;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] ops = {"5","-2","4","C","D","9","+","+"};
	calPoints(ops);
	}

}
