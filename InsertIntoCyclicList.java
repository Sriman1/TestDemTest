import java.util.HashSet;
import java.util.Set;

public class InsertIntoCyclicList {

	
	  public static ListNode insert(ListNode node, int x) {
	        // write your code here
	        ListNode curr=node;
	       Set<ListNode> set=new HashSet<>();
	        while(curr!=null){
	            
	            
	            if(set.contains(curr)) break;
	            if(curr.val<x&&curr.next.val>=x){
	                
	                ListNode n=new ListNode(x);
	                n.next=curr.next;
	                curr.next=n;
	                
	                return n;
	            }
	            set.add(curr);
	            curr=curr.next;
	            
	        }
	        
	           
	 ListNode n= new ListNode(x);
	     n.next=node;
	     return n;
	            
	        
	     
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(2);
		head.next=new ListNode(2);
		head.next.next=new ListNode(2);  
		head.next.next.next=head;
		insert(head, 3);
	}

}
