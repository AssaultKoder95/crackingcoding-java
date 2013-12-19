package chpt4.practice.myself;

import java.util.LinkedList;

import chpt4.practice.myself.Graph.Vertex;

public class InterviewQuestions4_2 {

    public static boolean detectRouteInGraph(Graph graph, Vertex src, Vertex target) {
        LinkedList<Vertex> queue = new LinkedList<Vertex>();
        int[] visitFlag = new int[graph.getAllVertices().size()];
        //initialize
        queue.add(src);
        while (!queue.isEmpty()) {
            Vertex temp = queue.pollFirst();
            if (temp != target) {
                for (int i = 0; i < temp.getNeighbors().size(); i++) {
                    if (visitFlag[temp.getNeighbors().get(i).getId()] != 1) {
                        visitFlag[temp.getNeighbors().get(i).getId()] = 1;
                        queue.add(temp.getNeighbors().get(i));
                    }
                }
            }
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Graph.Vertex a = new Graph.Vertex(0);
        Graph.Vertex b = new Graph.Vertex(1);
        Graph.Vertex c = new Graph.Vertex(2);
        Graph.Vertex d = new Graph.Vertex(3);
        Graph.Vertex e = new Graph.Vertex(4);
        a.getNeighbors().add(b);
        a.getNeighbors().add(c);
        a.getNeighbors().add(d);
        c.getNeighbors().add(d);
        d.getNeighbors().add(c);
        c.getNeighbors().add(e);
        Graph graph = new Graph();
        graph.getAllVertices().add(a);
        graph.getAllVertices().add(b);
        graph.getAllVertices().add(c);
        graph.getAllVertices().add(d);
        graph.getAllVertices().add(e);
        System.out.println(InterviewQuestions4_2.detectRouteInGraph(graph, a, e));
    }
}
