/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int preIndex=0;
    Map<Integer,Integer> mp=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        return helper(preorder,0,inorder.length-1);
    }

    public TreeNode helper(int[] preorder,int left,int right){
        if(left>right) return null;
        int val=preorder[preIndex++];
        TreeNode root=new TreeNode(val);
        int inIndex=mp.get(val);
        root.left=helper(preorder,left,inIndex-1);
        root.right=helper(preorder,inIndex+1,right);
        return root;
    }
}
