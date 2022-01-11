public class Solution 
{
    int sum = 0;
    public int SumRootToLeaf(TreeNode root) 
    {
        SumRootToLeaf(root, new List<int>{ });
        return sum;
    }
    
    public void SumRootToLeaf(TreeNode root, List<int> curr) 
    {
        if (root == null)
            return;
        
         curr.Add(root.val);
        
        if (root.left == null && root.right == null) 
        {
            var val = string.Join("", curr);
            sum += Convert.ToInt32(val, 2);
            // Console.WriteLine(val);
            curr.RemoveAt(curr.Count - 1);
            return;
        } 

        SumRootToLeaf(root.left, curr);
        SumRootToLeaf(root.right, curr); 
        curr.RemoveAt(curr.Count - 1);

    }
}
