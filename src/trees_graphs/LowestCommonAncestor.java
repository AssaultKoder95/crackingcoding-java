package trees_graphs;

import java.util.HashSet;

import util.TreeNodeP;

public class LowestCommonAncestor {

    public static int pathLen(TreeNodeP cur) {
        int pathLen = 0;
        while (cur.parent != null) {
            cur = cur.parent;
            pathLen++;
        }
        return pathLen;
    }

    public static TreeNodeP search(TreeNodeP et1, TreeNodeP et2) {
        int et1PathLen = pathLen(et1), et2PathLen = pathLen(et2);
        TreeNodeP deeper, shallower;
        deeper = et1PathLen > et2PathLen ? et1 : et2;
        shallower = et1PathLen > et2PathLen ? et2 : et1;
        int diff = Math.abs(et1PathLen - et2PathLen);
        for (int i = 0; i < diff; i++)
            deeper = deeper.parent;
        while (deeper != shallower) {
            deeper = deeper.parent;
            shallower = shallower.parent;
        }
        return deeper;
    }

}
