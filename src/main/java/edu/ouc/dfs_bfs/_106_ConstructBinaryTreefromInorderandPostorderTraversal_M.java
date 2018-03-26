package edu.ouc.dfs_bfs;
/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * @author wqx
 * Jan,2,2016
 * 
 * inorder    :  [s1..........pos-1,pos,pos+1,...............e1]
 * postorder  :  [s2,....,s2+(pos-s1-1),s2+(pos-s1),....e2-1,e2]
 *  
 * pos-s1:number of node in left tree.
 * 
 * find root position in inorder ,postorder[e2] = inorder[pos]
 * 
 * 
 * 
 */
public class _106_ConstructBinaryTreefromInorderandPostorderTraversal_M {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return createTree(inorder,0,inorder.length - 1,postorder,0,postorder.length - 1);
    }
    private TreeNode createTree(int[] inorder,int s1,int e1,int[] postorder,int s2,int e2){
    	if(s1 <= e1){
    		int rootValue = postorder[e2];
    		int pos = s1;
    		//find rootNode position in inorder array
    		for(int i = s1; i <= e1; i++){
    			if(rootValue == inorder[i]){
    				pos = i;
    				break;
    			}
    		}
    		TreeNode rootNode = new TreeNode(rootValue);
    		rootNode.left = createTree(inorder,s1,pos-1,postorder,s2,s2+(pos-s1-1));
    		rootNode.right = createTree(inorder,pos+1,e1,postorder,s2+(pos-s1),e2-1);
    		return rootNode;
    	}else{
    		return null;
    	}
    }
}
