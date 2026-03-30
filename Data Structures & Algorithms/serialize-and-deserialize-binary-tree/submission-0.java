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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res=new ArrayList<>();
        dfsSerialize(root,res);
        return String.join(",",res);
    }

    private void dfsSerialize(TreeNode root,List<String> res){
        if(root==null) {
            res.add("N");
            return;
        }
        String val=Integer.toString(root.val);
        res.add(val);
        dfsSerialize(root.left,res);
        dfsSerialize(root.right,res);
    }
    int index=0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals=data.split(",");
        return dfsDeserialize(vals);
    }

    private TreeNode dfsDeserialize(String[] vals){
        if(vals[index].equals("N")){
            index++;
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(vals[index++]));
        root.left=dfsDeserialize(vals);
        root.right=dfsDeserialize(vals);
        return root;
    }
}
