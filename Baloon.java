
public class Baloon {
	 public static int maxNumberOfBalloons(String text) {
	        
	        int[] chars=new int[26];
	        
	        for(char c:text.toCharArray()){
	            chars[c-'a']++;
	        }
	        
	        String str="balloon";
	        int ans=0;
	        for(char c:str.toCharArray()){
	            if(chars[c-'a']==0){
	                return 0;
	            }
	            ans=Math.min(ans,chars[c-'a']);
	            chars[c-'a']--;
	        }
	        
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
maxNumberOfBalloons("nlaebolko");
System.out.println ((char)(45+'a'));
	}

}
