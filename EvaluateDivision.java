import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
	 static class Node{
	        
	        String dest;
	        double d;
	        
	        Node(String dest,double d){
	            
	            this.dest=dest;
	            this.d=d;
	            
	        }
	    }
	    
	    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
	        
	        Map<String,List<Node>> map=new HashMap<>();
	        
	        
	        for(int i=0;i<equations.size();i++){
	            
	            if(!map.containsKey(equations.get(i).get(0)))
	            {
	            map.put(equations.get(i).get(0),new ArrayList<>());
	            map.get(equations.get(i).get(0)).add(new Node(equations.get(i).get(1),values[i]));
	            map.put(equations.get(i).get(1),new ArrayList<>());
	            map.get(equations.get(i).get(1)).add(new Node(equations.get(i).get(0),1.0/values[i]));

	            }
	            else{
	                 map.get(equations.get(i).get(0)).add(new Node(equations.get(i).get(1),values[i]));
	                 map.put(equations.get(i).get(1),new ArrayList<>());
	                 map.get(equations.get(i).get(1)).add(new Node(equations.get(i).get(0),1.0/values[i]));

	            }
	            }
	        double[] res=new double[queries.size()];
	        
	        for(int i=0;i<queries.size();i++){
	            
	            if(map.containsKey(queries.get(i).get(0))&&map.containsKey(queries.get(i).get(1))){
	                
	                
	                res[i]=dfs(queries.get(i).get(0),map,queries.get(i).get(1),new HashSet<>(),"",1.0);
	                
	                
	            }
	          //  else if(queries.get(i).get(0).equals(queries.get(i).get(1))) res[i]=1.0;
	            else{
	                res[i]=-1.0;
	            }
	            
	        }
	        
	        return res;
	    }
	
	private static double dfs(String src, Map<String, List<EvaluateDivision.Node>> map, String dest,
				Set<String> visited, String parent,double product) {
		if(!src.equals(dest)) {	
		if(!visited.contains(src)) {
			
			visited.add(src);
			
			
			for(Node u:map.get(src)) {
				if(u.dest.equals(parent)) continue;
				return dfs(u.dest, map, dest, visited, src, product*u.d);
			}
			
		}
			
			
		}
		
		return product;
		
		
		
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> equations=new ArrayList<>();
		equations.add(0,new ArrayList<>());
		equations.get(0).add("a");
		equations.get(0).add("b");
		equations.add(1,new ArrayList<>());
		equations.get(1).add("b");
		equations.get(1).add("c");
		equations.add(2,new ArrayList<>());
		equations.get(2).add("bc");
		equations.get(2).add("cd");
		double[] values = {1.5,2.5,5.0}; 
		
		List<List<String>> queries=new ArrayList<>();
		queries.add(0,new ArrayList<>());
		queries.get(0).add("a");
		queries.get(0).add("c");
		queries.add(1,new ArrayList<>());
		queries.get(1).add("c");
		queries.get(1).add("b");
		queries.add(2,new ArrayList<>());
		queries.get(2).add("bc");
		queries.get(2).add("cd");
		queries.add(3,new ArrayList<>());
		queries.get(3).add("cd");
		queries.get(3).add("bc");
//		queries.add(4,new ArrayList<>());
//		queries.get(4).add("x");
//		queries.get(4).add("x");
		calcEquation(equations, values, queries);
		
	}

}
