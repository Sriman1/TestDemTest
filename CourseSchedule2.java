import java.util.ArrayList;
import java.util.List;

public class CourseSchedule2 {
	   static List<List<Integer>> adjList;
	    static boolean[] visited;
	    static boolean[] explored;
	   static int [] result;
	   static int idx=0;
	    public static int[] findOrder(int numCourses, int[][] prerequisites) {
	        result=new int[numCourses];
	        adjList=new ArrayList<>();
	        
	        visited=new boolean[numCourses];
	        explored=new boolean[numCourses];
	        
	        for(int i=0;i<numCourses;i++){
	            
	            adjList.add(i,new ArrayList<>());
	        }
	        
	        for(int i=0;i<prerequisites.length;i++){
	            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
	        }
	        
	        for(int i=0;i<numCourses;i++){
	            if(!visited[i]){
	                
	                if(dfs(i)){
	                        int arr[] = {};
	            return arr;
	                    
	                }
	            }
	        }
	    
	        return result;
	     
	    }
	    
	    
	    static boolean dfs(int src){
	       if(!visited[src]){
	           
	           visited[src]=true;
	           
	           for(int u:adjList.get(src)){
	               
	               if(dfs(u)){
	                   
	                   return true;
	               }
	               
	           }
	           
	       }
	        else {
	            
	            return true;
	        }
	        
	       
	        result[idx]=src;
	        idx++;
	        
	        return false;
	        }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int numCourse=2;
int[][] prereq= {{1,0}};
findOrder(numCourse, prereq);
	}

}
