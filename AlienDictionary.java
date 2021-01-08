import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AlienDictionary {
	
	public static String order(String[] words) {
		Map<Character,Character> map=new HashMap<>();
		
		for(int i=1;i<words.length;i++) {
			
			buildMap(words[i-1],words[i],map);
		}
		
		Set<Character> explored=new HashSet<>();
		Set<Character> visited=new HashSet<>();
		
		List<Character> list=new ArrayList<>();
		boolean isCycle=dfs(map,list,explored,visited,words[0].charAt(0));
		StringBuilder sb=new StringBuilder();

		if(isCycle) return sb.toString();
		
		for(char c:list) {
			sb.append(c);
		}
		
		return sb.toString();
		
	}





	private static boolean dfs(Map<Character, Character> map,List<Character> arrayList, Set<Character> explored,
			Set<Character> visited, char src) {
		if(!visited.contains(src)) {
			visited.add(src);
			
			if(map.get(src)!=null) {
			if(dfs(map,arrayList,explored,visited,map.get(src))) {
				return true;
			}
			}
		}
		
		else if(!explored.contains(src)) {
			return true;
		}
		
		explored.add(src);
		arrayList.add(0,src);
		return false;
		
		
	}





	private static void buildMap(String s1, String s2, Map<Character, Character> map) {
		int i=0;
		int j=0;
		
		while(i<s1.length()&&j<s2.length()) {
			if(s1.charAt(i)==s2.charAt(j)) {
				i++;j++;
			}
			else {
				map.put(s1.charAt(i), s2.charAt(j));
				break;
			}
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] words={
		  "abc",
		  
		  "ab",
		  
		  
	};
		
		System.out.println(order(words));

	}

}
