package util;

import java.util.ArrayList;

public class Graph {
    public ArrayList<Vertex> vertices;

    public static class Vertex {
        public  int id;
        public ArrayList<Vertex> neighbors;
        
        public Vertex(int id) {
            this.id = id;
            neighbors = new ArrayList<Vertex>();
        }
    }
    
    public Graph(){
        vertices = new ArrayList<Vertex>();
    }
    
}
