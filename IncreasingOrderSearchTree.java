import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree {
	 public TreeNode increasingBST(TreeNode root) {
         
	        List<Integer> list=new ArrayList<>();
	        build(list,root);
	        TreeNode newRoot=null;
	        for(int i:list){
	            if(newRoot==null) {
	                newRoot=new TreeNode(i);
	            }
	            else{
	                newRoot.right=new TreeNode(i);
	            }
	        }
	        return newRoot;
	    }
	        
	    
	     void build(List<Integer> list,TreeNode root){
	        
	        if(root!=null){
	            
	            build(list,root.left);
	            
	            
	            list.add(root.val);
	            
	            
	            
	            build(list,root.right);
	        }
	        
	        
	        
	        
	        
	    }
}
/*

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \ 
1        7   9




*/