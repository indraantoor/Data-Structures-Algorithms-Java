import java.util.ArrayList;
import java.util.*;

public class Dijkstra {
    // VERTEX
    public static class Vertex {

        private String data;
        private ArrayList<Edge> edges;

        public Vertex(String inputData) {
            this.data = inputData;
            this.edges = new ArrayList<Edge>();
        }

        public String getData() {
            return this.data;
        }

        public ArrayList<Edge> getEdges(){
            return this.edges;
        }

        public void addEdge(Vertex v, int weight) {
            this.edges.add(new Edge(this, v, weight));
        }

        public void removeEdge(Vertex v) {
            //I don't love this solution, we don't teach removeIf
            this.edges.removeIf(e -> e.getEnd().equals(v));
        }

        public void print() {
            String message = "";

            if(this.edges.size() == 0) {
                System.out.println(this.data + " -->");
                return;
            }

            for(int i = 0; i < this.edges.size(); i++) {
                if(i == 0) {
                    message += this.edges.get(i).getStart().data + " -->  ";
                }
                message += this.edges.get(i).getEnd().data + " (" + this.edges.get(i).getWeight() + ")";
                if (i != this.edges.size() - 1) {
                    message += ", ";
                }
            }
            System.out.println(message);
        }
    }

    // EDGE
    public static class Edge {
        private Vertex start;
        private Vertex end;
        private int weight;

        public Edge(Vertex startV, Vertex endV, int inputWeight) {
            this.start = startV;
            this.end = endV;
            this.weight = inputWeight;
        }

        public Vertex getStart() {
            return this.start;
        }

        public Vertex getEnd() {
            return this.end;
        }

        public int getWeight() {
            return this.weight;
        }

    }

    // GRAPH
    public static class Graph {
        private ArrayList<Vertex> vertices;
        private boolean isDirected;
        private boolean isWeighted;

        public Graph(boolean inputIsWeighted, boolean inputIsDirected) {
            this.vertices = new ArrayList<Vertex>();
            this.isWeighted = inputIsWeighted;
            this.isDirected = inputIsDirected;
        }

        public ArrayList<Vertex> getVertices(){
            return this.vertices;
        }

        public Vertex addVertex(String data) {
            Vertex newVertex = new Vertex(data);
            this.vertices.add(newVertex);
            return newVertex;
        }

        public void removeVertex(Vertex v){
            this.vertices.remove(v);
        }

        public void addEdge(Vertex v1, Vertex v2, int weight) {
            if (!isWeighted) {
                weight = 0;
            }
            v1.addEdge(v2, weight);
            if(!this.isDirected) {
                v2.addEdge(v1, weight);
            }
        }

        public void removeEdge(Vertex v1, Vertex v2) {
            v1.removeEdge(v2);
            if(!this.isDirected) {
                v2.removeEdge(v1);
            }
        }

        public Vertex getVertexByValue(String value) {
            //This is weird as well. Not sure what we should do if the vertex doesn't exist in the graph
            for(Vertex v: this.vertices) {
                if (v.getData() == value) {
                    return v;
                }
            }
            return new Vertex("");
        }

        public void print() {
            for(Vertex v: this.vertices) {
                v.print();
            }
        }
    }

    // QUEUE OBJECT
    public static class QueueObject implements Comparable<QueueObject> {
        public Vertex vertex;
        public int priority;

        public QueueObject(Vertex v, int p){
            this.vertex = v;
            this.priority = p;
        }

        @Override
        public int compareTo(QueueObject o) {
            if (this.priority == o.priority){
                return 0;
            }
            else if (this.priority > o.priority){
                return 1;
            }
            else{
                return -1;
            }
        }
    }

    // DIJKSTRA IMPLEMENTATION
    public static Dictionary[] dijkstra (Graph g, Vertex startingVertex){
        Dictionary<String, Integer> distances = new Hashtable<>();
        Dictionary<String, Vertex> previous = new Hashtable<>();
        PriorityQueue<QueueObject> queue = new PriorityQueue<QueueObject>();

        queue.add(new QueueObject(startingVertex, 0));

        for (Vertex v: g.getVertices()) {
            if(v != startingVertex){
                distances.put(v.getData(), Integer.MAX_VALUE);
            }
            previous.put(v.getData(), new Vertex("Null"));
        }

        distances.put(startingVertex.getData(), 0);


        while(queue.size() != 0){
            Vertex current = queue.poll().vertex;
            for (Edge e: current.getEdges()) {
                Integer alternate = distances.get(current.getData()) + e.getWeight();
                String neighborValue = e.getEnd().getData();
                if (alternate < distances.get(neighborValue)){
                    distances.put(neighborValue, alternate);
                    previous.put(neighborValue, current);
                    queue.add(new QueueObject(e.getEnd(), distances.get(neighborValue)));
                }
            }
        }

        return new Dictionary[]{distances, previous};
    }

    public static void shortestPathBetween(Graph g, Vertex startingVertex, Vertex targetVertex){
        Dictionary[] dijkstraDicts = dijkstra(g, startingVertex);
        Dictionary distances = dijkstraDicts[0];
        Dictionary previous = dijkstraDicts[1];
        Integer distance = (Integer) distances.get(targetVertex.getData());
        System.out.println("Shortest Distance between " + startingVertex.getData() + " and " + targetVertex.getData());
        System.out.println(distance);

        ArrayList<Vertex> path = new ArrayList<>();
        Vertex v = targetVertex;
        while(v.getData() != "Null"){
            path.add(0,v);
            v = (Vertex) previous.get(v.getData());
        }
        System.out.println("Shortest Path");
        for (Vertex pathVertex: path){
            System.out.println(pathVertex.getData());
        }
    }

    public static void dijkstraResultPrinter(Dictionary[] d){
        System.out.println("Distances:\n");
        for (Enumeration keys = d[0].keys(); keys.hasMoreElements();){
            String nextKey = keys.nextElement().toString();
            System.out.println(nextKey + ": " + d[0].get(nextKey));
        }
        System.out.println("\nPrevious:\n");
        for (Enumeration keys = d[1].keys(); keys.hasMoreElements();) {
            String nextKey = keys.nextElement().toString();
            Vertex nextVertex = (Vertex) d[1].get(nextKey);
            System.out.println(nextKey + ": " + nextVertex.getData());
        }
    }

    public static void main(String[] args){
        Graph testGraph = new Graph(true, true);
        Vertex a = testGraph.addVertex("A");
        Vertex b = testGraph.addVertex("B");
        Vertex c = testGraph.addVertex("C");
        Vertex d = testGraph.addVertex("D");
        Vertex e = testGraph.addVertex("E");
        Vertex f = testGraph.addVertex("F");
        Vertex g = testGraph.addVertex("G");

        testGraph.addEdge(a, c, 100);
        testGraph.addEdge(a, b, 3);
        testGraph.addEdge(a, d, 4);
        testGraph.addEdge(d, c, 3);
        testGraph.addEdge(d, e, 8);
        testGraph.addEdge(e, b, -2);
        testGraph.addEdge(e, f, 10);
        testGraph.addEdge(b, g, 9);
        testGraph.addEdge(e, g, -50);

        dijkstraResultPrinter(dijkstra(testGraph, a));
        shortestPathBetween(testGraph, a, g);
    }
}
