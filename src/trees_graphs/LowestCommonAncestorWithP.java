package trees_graphs;

import util.TreeNodeP;

public class LowestCommonAncestorWithP {

    public static int pathLen(TreeNodeP cur) {
        int pathLen = 0;
        while (cur.parent != null) {
            cur = cur.parent;
            pathLen++;
        }
        return pathLen;
    }

    public static TreeNodeP search(TreeNodeP n1, TreeNodeP n2) {
        int n1PathLen = pathLen(n1), n2PathLen = pathLen(n2);
        TreeNodeP deeper, shallower;
        if(n1PathLen > n2PathLen){
            deeper = n1;
            shallower = n2;
        }else{
            deeper = n2;
            shallower = n1;
        }
        int diff = Math.abs(n1PathLen - n2PathLen);
        for (int i = 0; i < diff; i++){
            deeper = deeper.parent;
        }
        while (deeper != shallower) {
            deeper = deeper.parent;
            shallower = shallower.parent;
        }
        return deeper;
    }

}
