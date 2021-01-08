
public class DiffBst {
	   public int minDiffInBST(TreeNode root) {
	        int[] res=new int[1];
	        
	        findMinDiff(root,res);
	        res[0]=Integer.MAX_VALUE;
	        return res[0];
	    }
	    
	    int findMinDiff(TreeNode root,int[] res){
	        
	        if(root==null) return Integer.MAX_VALUE;
	        
	        
	        int left=findMinDiff(root.left,res);
	        int right=findMinDiff(root.right,res);
	        
	        if(left==Integer.MAX_VALUE&&right==Integer.MAX_VALUE) return root.val;

	        res[0]=Math.min(res[0],Math.min(Math.abs(left-root.val),Math.abs(right-root.val)));
	        

	        if(right!=Integer.MAX_VALUE) return right;
	        
	        
	        return root.val;
	        
	    }
}
