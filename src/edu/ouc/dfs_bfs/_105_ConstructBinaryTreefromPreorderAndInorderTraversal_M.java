package edu.ouc.dfs_bfs;

/**
 * 
 * @author wqx
 * 
 * preorder  :  [s1,s1+1,....,s1+(pos-s2),s1+(pos-s2)+1,....e1]
 * inorder   :  [s2..........pos-1,pos,pos+1,...............e2]
 *  
 * pos-s2:number of node in left tree.
 *  
 */
public class _105_ConstructBinaryTreefromPreorderAndInorderTraversal_M {
    public TreeNode buildTree(int[] preorder,int[] inorder) {
        return createTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    private TreeNode createTree(int[] preorder,int s1,int e1,int[] inorder,int s2,int e2){
    	if(s1 <= e1){
    		int rootValue = preorder[s1];
    		int pos = s2;
    		//find rootNode position in inorder array
    		for(int i = s2; i <= e2; i++){
    			if(preorder[s1] == inorder[i]){
    				pos = i;
    				break;
    			}
    		}
    		TreeNode rootNode = new TreeNode(rootValue);
    		rootNode.left = createTree(preorder,s1+1,s1+(pos-s2),inorder,s2,pos-1);
    		rootNode.right = createTree(preorder,s1+(pos-s2)+1,e1,inorder,pos+1,e2);
    		return rootNode;
    	}else{
    		return null;
    	}
    }
}
