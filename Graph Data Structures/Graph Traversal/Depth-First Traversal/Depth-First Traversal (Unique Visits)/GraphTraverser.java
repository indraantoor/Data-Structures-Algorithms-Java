/*
 If there was a cycle, like if there was a path from one
 vertex to itself, we would be stuck in an infinite loop, continuously
 iterating over the same neighbors. To account for this, we can use an
 ArrayList to keep track of all the vertices that we have visited.
 */

// USE GRAPH FILE FROM GRAPH FOLDER

import java.util.ArrayList;

class GraphTraverser {
    public static void depthFirstTraversal(Vertex start, ArrayList<Vertex> visitedVertices) {
        System.out.println(start.getData());

        if (start.getEdges().size() > 0) {
            Vertex neighbor = start.getEdges().get(0).getEnd();

            if (!visitedVertices.contains(neighbor)) {
                visitedVertices.add(neighbor);
                GraphTraverser.depthFirstTraversal(neighbor, visitedVertices);
            }
        }
    }

    // USE TO TEST THE GRAPH
    class TestGraph {
        private Graph testGraph;

        public TestGraph() {
            this.testGraph = new Graph(false, true);
            Vertex startNode = testGraph.addVertex("v0.0.0");
            Vertex v1 = this.testGraph.addVertex("v1.0.0");
            Vertex v2 = this.testGraph.addVertex("v2.0.0");

            Vertex v11 = this.testGraph.addVertex("v1.1.0");
            Vertex v12 = this.testGraph.addVertex("v1.2.0");
            Vertex v21 = this.testGraph.addVertex("v2.1.0");

            Vertex v111 = this.testGraph.addVertex("v1.1.1");
            Vertex v112 = this.testGraph.addVertex("v1.1.2");
            Vertex v121 = this.testGraph.addVertex("v1.2.1");
            Vertex v211 = this.testGraph.addVertex("v2.1.1");

            this.testGraph.addEdge(startNode, v1, null);
            this.testGraph.addEdge(startNode, v2, null);

            this.testGraph.addEdge(v1, v11, null);
            this.testGraph.addEdge(v1, v12, null);
            this.testGraph.addEdge(v2, v21, null);

            this.testGraph.addEdge(v11, v111, null);
            this.testGraph.addEdge(v11, v112, null);
            this.testGraph.addEdge(v12, v121, null);
            this.testGraph.addEdge(v21, v211, null);

            // create a cycle
            this.testGraph.addEdge(v211, v2, null);
        }

        public Vertex getStartingVertex() {
            return this.testGraph.getVertices().get(0);
        }
    }

    // MAIN METHOD
    public static void main(String[] args) {
        TestGraph test = new TestGraph();
        Vertex startingVertex = test.getStartingVertex();
        ArrayList<Vertex> visitedVertices = new ArrayList<Vertex>();
        visitedVertices.add(startingVertex);

        GraphTraverser.depthFirstTraversal(startingVertex, visitedVertices);
    }
}