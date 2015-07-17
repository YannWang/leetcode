package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tech4 on 2015/7/16.
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == q) return p;
        List<TreeNode> ancestorP = new ArrayList<>();
        List<TreeNode> ancestorQ = new ArrayList<>();
        TreeNode cursor = root;
        while (cursor.val != p.val) {
            ancestorP.add(cursor);
            if (cursor.val < p.val) {
                cursor = cursor.right;
            } else {
                cursor = cursor.left;
            }
        }
        ancestorP.add(cursor);
        cursor = root;
        while (cursor.val != q.val) {
            ancestorQ.add(cursor);
            if (cursor.val < q.val) {
                cursor = cursor.right;
            } else {
                cursor = cursor.left;
            }
        }
        ancestorQ.add(cursor);
        for (int i = 0; i < Math.min(ancestorP.size(), ancestorQ.size()); i++) {
            if (i == ancestorP.size() - 1 || i == ancestorQ.size() || ancestorP.get(i + 1) != ancestorQ.get(i + 1)) {
                return ancestorP.get(i);
            }
        }
        return null;
    }
}
