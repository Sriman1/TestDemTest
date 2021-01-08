import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

 
public class DeepestLeaves {
    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        
        int depth= findMaxDepth(root);
        Stack<Integer> stack=new Stack<>();
        
        fillSetLeaves(stack,root,depth);
        TreeNode lca=root;
        while(!stack.isEmpty()){
            
            lca=ancestor(root,stack.pop(),stack.pop());
            
            if(!stack.isEmpty()){
                stack.push(lca.val);
            }
            
                
                
           
        }
        return lca;
    }
    
    static TreeNode ancestor(TreeNode root,int p, int q){
        
        if(root==null) return null;
        
        if(root.val==p||root.val==q) return root;
        
        
        TreeNode left=ancestor(root.left,p,q);
        TreeNode right=ancestor(root.right,p,q);
        
        if(left!=null&&right!=null) {
        	return root;
        };
        
        if(left!=null) {
        	return left;
        }
        
        return right;
        
        
        
    }
    
   static int findMaxDepth(TreeNode root){
        
        if(root==null) return 0;
        
        
        return Math.max(findMaxDepth(root.left),findMaxDepth(root.right))+1;
        
    }
    
   static void fillSetLeaves(Stack<Integer> stack,TreeNode root,int depth){
        
        if(root==null||depth==0) return;
        
        if(depth-1==0) stack.push(root.val);
        
        
        fillSetLeaves(stack,root.left,depth-1);
        fillSetLeaves(stack,root.right,depth-1);
        
        
    }
   
   public static boolean hasPathSum(TreeNode root, int sum) {
       
       if(root==null) return false;
       
       if(sum==0&&root.left==null&&root.right==null) return true;
       
       boolean left=hasPathSum(root.left,sum-root.val);
       
       boolean right=hasPathSum(root.right,sum-root.val);
       
       
       return left||right;
   }
   public static List<String> binaryTreePaths(TreeNode root) {
       List<String> res=new ArrayList<>();
       
       findPaths(res,root,"");
       
       return res;
   }
   
   
  static void findPaths(List<String> res, TreeNode root,String str){
       
       if(root==null) return;

       if(root.left==null&&root.right==null){
           
           res.add(str+root.val);
           return;
       }
       
       String re=root.val+"->";
       findPaths(res,root.left,re);
       findPaths(res,root.right,re);

   }
  
  public static TreeNode sortedArrayToBST(int[] nums) {
      
      
	    return bst(nums,0,nums.length-1);
	        
	        
	        
	    }
	    
	    
	  static  TreeNode bst(int[] nums,int start,int end){
	        
	        
	        if(start<end) return null;
	        
	        
	        int mid=start+end/2;
	        
	        
	        TreeNode root=new TreeNode(nums[mid]);
	        
	        
	        root.left=bst(nums,start,mid-1);
	        
	        root.right=bst(nums,mid+1,end);
	        
	        
	        
	        
	        return root;
	        
	        
	        
	        
	        
	    }
	  
	  public static TreeNode recoverTree(TreeNode root) {
	        
	        
	        List<Integer> list=new ArrayList<>();
	        
	        int swapsReq=0;
	        
	        fillList(list,root);
	        
	        for(int i=1;i<list.size();i++){
	            
	            if(list.get(i)<list.get(i-1)){
	                swapsReq++;
	            }
	        }
	        
	        Integer swapIndex1=null;
	        Integer swapIndex2=null;
	        
	        for(int i=1;i<list.size();i++){
	            
	            if(list.get(i)<list.get(i-1)){
	                
	                if(swapsReq==1){
	                    int temp=list.get(i-1);
	                    list.set(i-1,list.get(i));
	                    list.set(i,temp);
	                    break;
	                }
	                
	                else{
	                    
	                    if(swapIndex1==null){
	                        swapIndex1=i-1;
	                    }
	                    else{
	                        swapIndex2=i;
	                    }
	                    if(swapIndex1!=null&&swapIndex2!=null){
	                        int temp=list.get(swapIndex1);
	                        list.set(swapIndex1,list.get(swapIndex2));
	                        list.set(swapIndex2,temp);
	                        break;
	                        
	                    }
	                    
	                }
	                
	            }
	            
	        
	            
	            
	            
	        }
	        return createBST(list,0,list.size()-1);
	    }
	    
	    static TreeNode createBST(List<Integer> list,int start, int end){
	        
	        if(start>end) return null;
	        
	        int mid= (start+end)/2;
	        
	        TreeNode root=new TreeNode(list.get(mid));
	        
	        root.left=createBST(list,start,mid-1);
	        root.right=createBST(list,mid+1,end);
	        
	        return root;
	    }
	    
	    
	    static void fillList(List<Integer> list,TreeNode root){
	        
	        if(root!=null){
	            
	            fillList(list,root.left);
	            list.add(root.val);
	            fillList(list,root.right);
	        }
	        
	    }
	    static TreeNode prev=null;
	    public static TreeNode increasingBST(TreeNode root) {
	        
	        
	        return inc(root);
	        
	    }
	    
	   static  TreeNode inc(TreeNode root){
	        
	        
	        if(root==null) return null;
	        
	        
	        inc(root.left);
	        
	        if(prev!=null){
	            
	            root.right=new TreeNode(prev.val);
	            root.left=null;
	        }
	        
	        prev=root;
	        
	        
	        inc(root.right);
	        
	        
	        
	        return root;
	        
	        
	        
	    }
	   
	   public static String serialize(TreeNode root) {

	        return getString(root,"");
	    }

	    // Decodes your encoded data to tree.
	    public static TreeNode deserialize(String data) {
	    
	        Queue<Character> q=new ArrayDeque<>();
	        for(char c:data.toCharArray()){
	           q.add(c);
	        }
	        
	        return getTree(q,null);
	    }
	    
	    
	    private static TreeNode getTree(Queue<Character> q, TreeNode root) {
			
	    	if(q.peek()=='*') {
	    		q.poll();
	    		return null;
	    	
	    	}
	    	
	    	root=new TreeNode(q.poll()-'0');
	    	root.left=getTree(q, root.left);
	    	root.right=getTree(q, root.right);
	    	
	    	return root;
	    	
	    	
	    	
		}

		static String getString(TreeNode root,String str){
	        
	   if(root==null) return "*";
	        
	    String left=getString(root.left,str);

	    String right=getString(root.right,str);
	        
	        
	        return root.val+""+left+right;
	        
	        
	    }
    
    public static void main(String[] args) {
    	
    	
    	TreeNode root=new TreeNode(5);
    	root.right=new TreeNode(6);
     	root.right.right=new TreeNode(8);
     	root.right.right.left=new TreeNode(7);
     	root.right.right.right=new TreeNode(9);

    	root.left=new TreeNode(3);
    	root.left.right=new TreeNode(4);
//    	root.right.left=new TreeNode(13);

//    	root.right.right=new TreeNode(4);
    	//root.right.right.right=new TreeNode(1);


    	
    	
    	root.left.left=new TreeNode(2);
    	root.left.left.left=new TreeNode(1);
//    	root.left.left=new TreeNode(11);
//    	root.left.left.right=new TreeNode(2);
    	
    	
//    	root.left.right.left=new TreeNode(7);
//    	root.left.right.right=new TreeNode(4);



//    	root.left.left=new TreeNode(6);
    	//lcaDeepestLeaves(root);
    	
    	//hasPathSum(root, 22);
//    	binaryTreePaths(root);
//    	sortedArrayToBST(new int[] {10,-3,0,5,9});
//    	recoverTree(root);
//    	increasingBST(root);
    	
    	deserialize(serialize(root));
    	
    	
    	
    }
}