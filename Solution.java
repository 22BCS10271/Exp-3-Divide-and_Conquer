
//Exp-1 (Problem #106: Construct Binary Tree from Inorder and Postorder Traversal)
import java.util.HashMap;

class Solution {
    private HashMap<Integer, Integer> inorderMap;
    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();
        postIndex = postorder.length - 1;

       
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeHelper(postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] postorder, int left, int right) {
        if (left > right) return null;


        int rootValue = postorder[postIndex--];
        TreeNode root = new TreeNode(rootValue);

      
        int inorderIndex = inorderMap.get(rootValue);

        
        root.right = buildTreeHelper(postorder, inorderIndex + 1, right);
        root.left = buildTreeHelper(postorder, left, inorderIndex - 1);

        return root;
    }
}





 //Exp-2 (Problem #104: Maximum Depth of Binary Tree)
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return depth;
    }
}



//Exp-3 (Problem #108: Convert Sorted Array to Binary Search Tree)
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) return null; 

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]); 

        root.left = buildBST(nums, left, mid - 1); 
        root.right = buildBST(nums, mid + 1, right); 

        return root;
    }
}
