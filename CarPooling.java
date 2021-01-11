import java.util.Arrays;
import java.util.Comparator;

public class CarPooling {
	public static boolean carPooling(int[][] trips, int capacity) {
	      
        Arrays.sort(trips,  new Comparator<int[]>() { 
            
          @Override              
         
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            if (entry1[1] > entry2[1]) 
                return 1; 
            else
                return 0; 
          } 
        });
        //Add comments
    
    
    	        int start=trips[0][1];
        int end=trips[0][2];
        int people=trips[0][0];
        if(people>capacity) return false;
        for(int i=1;i<trips.length;i++){
            if(people>capacity) return false;
            if(trips[i][1]>=end){
                people=trips[i][0];
	            if(people>capacity) return false;

                
            }
            if(trips[i][1]<end&&trips[i][1]>start){
                people+=trips[i][0];
	            if(people>capacity) return false;

            }
            
            if(end<=trips[i][2]){
                people-=trips[i-1][0];
                end=trips[i][2];
            }
            if(end>trips[i][2]){
                people-=trips[i][0];
            }
            if(end==trips[i][2]) {
            	people=0;
            }
      
            
            
        }
                    
                                                                                    
        return true;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] trips=new int[][]{{3,2,7},{3,7,9},{8,3,9}};
		carPooling(trips, 11);
	}

}
