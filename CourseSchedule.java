import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseSchedule {
	 public static boolean canFinish(int numCourses, int[][] prerequisites) {
	        List<List<Integer>> adjList=new ArrayList<>();
	        
	        for(int i=0;i<numCourses;i++){
	            adjList.add(i,new ArrayList<>());
	        }
	        for(int i=0;i<prerequisites.length;i++){
	            
	            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
	        }
	        
	        Set<Integer> set=new HashSet<>();
	        Set<Integer> visited=new HashSet<>();
	        for(int i=0;i<numCourses;i++){
	            
	            if(!set.contains(i)){
	                        if(cyclicDirected(adjList,set,i)) {
								return false;
							}
	            }
	        }
	        
	        
	        
	        return true;
	    }
	    
	   static  boolean cyclicDirected(List<List<Integer>> adjList,Set<Integer> set,int src){
	        set.add(src);
		   for(int u:adjList.get(src)) {
			   
			   if(!set.contains(u)) {
				   if(cyclicDirected(adjList, set, u)) return true;
			   }
		   }
		   
		   System.out.println(src);
		   return false;
	        
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] prereqs= {{1,0},{2,0},{1,2}};
		int courses=3;
		canFinish(courses, prereqs);
	}

}
