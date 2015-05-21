//Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//Initially, all next pointers are set to NULL.
//Note:
//You may only use constant extra space.
//You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
//For example,
//Given the following perfect binary tree,
//         1
//       /  \
//      2    3
//     / \  / \
//    4  5  6  7
//After calling your function, the tree should look like:
//         1 -> NULL
//       /  \
//      2 -> 3 -> NULL
//     / \  / \
//    4->5->6->7 -> NULL
 /**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {      
        if(root == null) return;    
            
        if(root.left != null) root.left.next = root.right;  

        if(root.right!=null && root.next!=null){  //we know the tree is perfect binary tree
            root.right.next = root.next.left;  
        }  
          
        connect(root.left);  
        connect(root.right);
    }
}

//another solution without recursion
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode ptr = root;
        TreeLinkNode scanner = root;
        
        while(ptr != null && ptr.left != null){	//perfect binary tree, if ptr.left is null, then there is no next level
            while(scanner != null && scanner.next != null){
                scanner.left.next = scanner.right;
                scanner.right.next = scanner.next.left;
                scanner = scanner.next;
            }
            scanner.left.next = scanner.right;	//scanner is now at the rightmost node of current level
            
            ptr=ptr.left; //move to next level
            scanner = ptr;
        }
    }
}
