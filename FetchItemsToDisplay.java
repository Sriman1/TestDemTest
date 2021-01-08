import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Item {
	
	String name;
	int relevance;
	int price;
	public Item(String name,int relevance, int price) {
		this.name=name;
		this.relevance=relevance;
		this.price=price;
	}
}

public class FetchItemsToDisplay {
	public static List<String> fetchItemsToDisplay(int numOfItems, Map<String, List<Integer>> items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber){
		
		Item[] arr=new Item[numOfItems];
		int idx=0;
		for(String s:items.keySet()) {
			arr[idx]=new Item(s,items.get(s).get(0),items.get(s).get(1));
			idx++;
		}
		Arrays.sort(arr,new Comparator<>() {

			@Override
			public int compare(Item arg0, Item arg1) {
				if(sortOrder==0) {
					if(sortParameter==1) {
						return arg0.relevance-arg1.relevance;
					}
					else
						return arg0.price-arg1.price;

				}
				else {
					if(sortParameter==1) {
						return arg1.relevance-arg0.relevance;
					}
					else
						return arg1.price-arg0.relevance;
				}
			}
			
		});
		int page=0;
		int i=0;
		List<String> list=new ArrayList<>();
		while(i<arr.length) {
			
			int itp=itemsPerPage;
			while(itp-->0&&i<arr.length) {
				
				if(page==pageNumber) {
					list.add(arr[i].name);
				}
				i++;
			}
			
			page++;
			
			
		}
		
		
		return list;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numOfItems = 3;

				//int[] items = {{"item1", 10,15], ["item2",3,4]. ["item3", 17, 8]]
						Map<String,List<Integer>> map=new HashMap<>();
						map.put("item1", new ArrayList<>());
						map.get("item1").add(0,10);
						map.get("item1").add(1,15);
						map.put("item2", new ArrayList<>());
						map.get("item2").add(0,3);
						map.get("item2").add(1,4);
						map.put("item3", new ArrayList<>());
						map.get("item3").add(0,17);
						map.get("item3").add(1,8);

				

				int sortParameter=1;

				int sortOrder = 0;

				int itemsPerPage=2;

				int pageNumber=1;
				fetchItemsToDisplay(numOfItems, map, sortParameter, sortOrder, itemsPerPage, pageNumber);
	}

}
