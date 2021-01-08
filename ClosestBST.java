
public class ClosestBST {
	public int closestValue(TreeNode root, double target) {
        // write your code here
       return closest(root,target,root);
    }
    
    int closest(TreeNode root,double target, TreeNode ans){
        
        if(root==null){
            return ans.val;
        }
        
     
     if(Math.abs(target-ans.val)>Math.abs(target-root.val)){
         ans=root;
     }
        
        if(target>root.val){
            return closest(root.right,target,ans);
        }
        else{
            return closest(root.left,target,ans);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
