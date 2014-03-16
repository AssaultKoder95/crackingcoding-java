package trees_graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private ArrayList<Vertex> vertices;

    public static class Vertex {
        private int id;
        ArrayList<Vertex> neighbors;
        
        public Vertex(int id) {
            this.id = id;
            neighbors = new ArrayList<Vertex>();
        }
        
        public List<Vertex> getNeighbors(){
            return neighbors;
        }
        
        public int getId(){
            return this.id;
        }
    }
    
    public Graph(){
        vertices = new ArrayList<Vertex>();
    }
    public List<Vertex> getAllVertices(){
        return vertices;
    }
}
