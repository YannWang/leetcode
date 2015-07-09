package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        // rList: return list
        List<Integer> rList = new ArrayList<Integer>();
        //if it's a null tree
        if (root == null) {
            return rList;
        }
        // use a list to act as a queue for Breadth First Search
        List<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        // we use the root node to act as a sentinel
        queue.add(root);

        int index = 0;

        while (index < queue.size()) {
            TreeNode current = queue.get(index);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }

            // This can be delete, 'cause there will be a sentinel to protect at
            // the end.
            // if (queue.get(index + 1) == null) {
            // rList.add(current.val);
            // return rList;
            // }

            // else get next node
            TreeNode next = queue.get(index + 1);
            // judge if it's next level
            if (next == root) {
                rList.add(current.val);
                //if it has arrived at the end, then break
                if (queue.size() == index + 2) {
                    break;
                }
                //else go on
                queue.add(root);
                index += 2;
            } else {
                index += 1;
            }
        }

        return rList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        List<Integer> rList;
        rList = new BinaryTreeRightSideView().rightSideView(root);
        System.out.println(rList);
        System.out.println("Say something!");
    }
}
