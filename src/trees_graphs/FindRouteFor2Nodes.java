/**
 * CTCI 4.2
 */
package trees_graphs;

import java.util.LinkedList;

import util.Graph;
import util.Graph.Vertex;

public class FindRouteFor2Nodes {

    public static boolean detectRouteInGraph(Graph graph, Vertex src, Vertex target) {
        LinkedList<Vertex> queue = new LinkedList<Vertex>();
        int[] visitFlag = new int[graph.vertices.size()];
        //initialize
        queue.add(src);
        while (!queue.isEmpty()) {
            Vertex temp = queue.pollFirst();
            if (temp != target) {
                for (int i = 0; i < temp.neighbors.size(); i++) {
                    if (visitFlag[temp.neighbors.get(i).id] != 1) {
                        visitFlag[temp.neighbors.get(i).id] = 1;
                        queue.add(temp.neighbors.get(i));
                    }
                }
            }
            else
                return true;
        }
        return false;
    }

}
