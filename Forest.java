import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Forest {
    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
        Set<Integer> set=new HashSet<>();
        
        for(int i:to_delete){
            set.add(i);
        }
        List<TreeNode> res=new ArrayList<>();
         TreeNode nRoot=del(root,set,res);
         res.add(nRoot);
        return res;
    }
    
   static  TreeNode del(TreeNode root, Set<Integer> set,List<TreeNode> res){
        
        if(root==null){
            return null;
            
        }
        
        if(set.contains(root.val)&&root.left==null&&root.right==null){
            return null;
        }
        
        if(set.contains(root.val)){
            
            res.add(root.left);
            res.add(root.right);
        }
        
        root.left=del(root.left,set,res);
        root.right=del(root.right,set,res);
        
        if(set.contains(root.val)){
            return null;
        }
        
        return root;
        
        
        
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] to_delete=new int[] {3,5};
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		root.right=new TreeNode(3);
		root.right.left=new TreeNode(6);
		root.right.right=new TreeNode(7);
		
		delNodes(root, to_delete);
		
		
	}

}
