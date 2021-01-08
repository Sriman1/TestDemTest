
public class BagOfTokens {
	  public int bagOfTokensScore(int[] tokens, int P) {
	        
	        return maxScore(tokens,P,0,0);
	        
	        
	    }
	    
	    
	    int maxScore(int[] tokens,int P,int idx,int score){
	        if(P<0||idx>tokens.length-1) return score;
	        
	        int max=0;
	        if(P>=tokens[idx]){
	            
	            int faceUp=maxScore(tokens,P-tokens[idx],idx+1,score+1);
	            int skip=maxScore(tokens,P,idx+1,score);
	            max=Math.max(max,Math.max(faceUp,skip));
	        }
	        
	        if(score>=1){
	            int faceDown=maxScore(tokens,P+tokens[idx],idx+1,score-1);
	                        int skip=maxScore(tokens,P,idx+1,score);
	                        max=Math.max(max,Math.max(faceDown,skip));


	        }
	        
	        return max;
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tokens= {100,200,300,400};
		int P=200;
		BagOfTokens b=new BagOfTokens();
		b.bagOfTokensScore(tokens, P);

	}

}
