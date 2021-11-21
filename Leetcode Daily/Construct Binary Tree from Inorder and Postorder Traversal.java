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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0 && inorder.length == 0)
            return null;
        if (postorder.length == 1 && inorder.length == 1)
            return new TreeNode(inorder[0]);
        int len = postorder.length;
        int root = postorder[len - 1];
        int index = findIndex(inorder, root);
        
        int[] leftIn = Arrays.copyOfRange(inorder, 0, index);
        int[] rightIn = Arrays.copyOfRange(inorder, index + 1, len);
        
        int[] leftPost = Arrays.copyOfRange(postorder, 0, index);
        int[] rightPost = Arrays.copyOfRange(postorder, index, len - 1);
        
        TreeNode lroot = buildTree(leftIn, leftPost);
        TreeNode rroot = buildTree(rightIn, rightPost);
        
        return new TreeNode(root, lroot, rroot);
    }
    int findIndex(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == x)
                return i;
        return -1;
    }
}
