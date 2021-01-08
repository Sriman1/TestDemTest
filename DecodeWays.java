import java.util.Arrays;

public class DecodeWays {
public static int numDecodings(String s) {
        
    int [] dp=new int[s.length()];
    
    Arrays.fill(dp,-1);
    
    int result=numWays(s,0,dp);
        return result;
    }
    
  static  int numWays(String s,int index,int[]dp){
        
        
	   if(index==s.length()){
           return 1;
       }
        if(s.charAt(index)=='0') return 0;
       
       if(index==s.length()-1) return 1;
          if(dp[index]!=-1){
           return dp[index];
       }
       
       int pick1=numWays(s,index+1,dp);
  
       
       int pick2=0;
       if(Integer.parseInt(s.substring(index,index+2))<=26){
           pick2=numWays(s,index+2,dp);
       }
       dp[index]=pick1+pick2;
       return pick1+pick2;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String s="226";
System.out.println(numDecodings(s));
	}

}
