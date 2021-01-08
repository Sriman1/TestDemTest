import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        // write your code here
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        list.add(root.val);
        if(root.left!=null)
            leftBound(root.left,list);
        children(root,list);
        if(root.right!=null)
            rightBound(root.right,list);
        return list;
    }
    
    void leftBound(TreeNode root,List<Integer> list){
    	 if(root==null) {
         	return;
         }
        if(root.left!=null||root.right!=null){
            
            list.add(root.val);
            
            leftBound(root.left,list);
        }
        
    }
    
        void rightBound(TreeNode root,List<Integer> list){
        
        if(root==null) {
        	return;
        }
        if(root.left!=null||root.right!=null){
            
        	 list.add(root.val);
            rightBound(root.right,list);
           
            
           
        }
        
    }
    void children(TreeNode root,List<Integer> list){
        
        if(root!=null){
            
            
            children(root.left,list);
            
            
            if(root.left==null&&root.right==null){
                list.add(root.val);
            }
            children(root.right,list);
            
            
        }
        
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.left.left=new TreeNode(4);
		root.left.left.left=new TreeNode(7);
		root.left.left.right=new TreeNode(8);

		root.left.right=new TreeNode(5);
		root.left.right.left=new TreeNode(9);
		root.left.right.right=new TreeNode(10);

		
		root.right=new TreeNode(3);
		root.right.left=new TreeNode(6);
		BoundaryTraversal b=new BoundaryTraversal();
		b.boundaryOfBinaryTree(root);
	}

}
