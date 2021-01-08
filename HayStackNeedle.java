import java.util.ArrayList;
import java.util.List;

public class HayStackNeedle {

	
	public static List<Integer> haystack(String haystack, String needle) {
		
		List<Integer> list=new ArrayList<>();
		int i=0;
		while(i<=haystack.length()-needle.length()) {
			if(haystack.charAt(i)==needle.charAt(0))
			{
				if(haystack.substring(i, i+needle.length()).equals(needle)) {
				
				list.add(i);
			}
			}
			i++;
		}
		
		return list;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String haystack="aaabcdddbbddddabcdefghi";
		String needle="abc";
		haystack(haystack, needle);
	}

}
