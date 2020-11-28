# Graphs

Graphs are the perfect data structure for modeling networks.

They’re composed of _nodes_, or _vertices_, which hold data, and _edges_, which are a connection between two vertices.

A single node is a **vertex**.

When _no path exists_ between two vertices, a graph is **disconnected**.

## Representation

We typically represent the vertex-edge relationship of a graph in two ways:

1. Adjacency List
2. Adjacency matrix.

### Adjacency List

In an adjacency list, each vertex contains a list of the vertices where an edge exists.

To find an edge, one looks through the list for the desired vertex.

### Adjacency Matrix

An adjacency matrix is a table.
Across the top, every vertex in the graph appears as a column. Down the side, every vertex appears again as a row.

Edges can be bi-directional, so each vertex is listed twice.

## Code's Overview

The two classes, _Vertex_ and _Graph_ are capable of representing the typical variations in graphs that occur in many different algorithms.

**Vertex:**

Uses a dictionary as an adjacency list to store connected vertices.
Connected vertex names are keys and the edge weights are values.
Has methods to add edges and return a list of connected vertices.

**Graph:**

Can be initialized as a directed graph, where edges are set in one direction.
Stores every vertex inside a dictionary
Vertex data is the key and the vertex instance is the value.
Has methods to add vertices, edges between vertices, and determine if a path exists between two vertices.

## Traversal

There are many ways to traverse a graph, but you will focus on three methods: depth-first search (DFS), breadth-first search (BFS), and Dijkstra’s algorithm. These traversal methods are core algorithms for searching a graph.

**Depth-First Search**
Simply put, a depth-first graph search continues down a path until it reaches the end. It is helpful for determining if a path exists between two vertices. DFS has many applications, including topological sorting and detecting cycles, but one of the more interesting real-world applications is that it can be used to solve problems that have a singular correct answer (a path between the start state and end state), such as a sudoku exercise.

**Breadth-First Search**
On the other hand, a breadth-first graph search approach checks the values of all neighboring vertices before moving into another level of depth. This is an incredibly inefficient way to find just any path between two vertices, but it’s an excellent way to identify the shortest path between them. Because of this, BFS is helpful for figuring out directions from one place to another.

## Dijkstra’s Algorithm

Dijkstra’s algorithm is a method for finding the shortest distance from a given point to every other point in a weighted graph. The algorithm works by keeping track of all the distances and updating the distances as it conducts a breadth-first search. A common application of this algorithm is to find the quickest route from one destination to another.

## Keywords You Should Know

- **Vertex**: A node in a graph.
- **Edge**: A connection between two vertices.
- **Adjacent**: When an edge exists between vertices.
- **Path**: A sequence of one or more edges between vertices.
- **Disconnected**: Graph where at least two vertices have no path connecting them.
- **Weighted**: Graph where edges have an associated cost.
- **Directed**: Graph where travel between vertices can be restricted to a single direction.
- **Cycle**: A path which begins and ends at the same vertex.
- **Adjacency Matrix**: Graph representation where vertices are both the rows and the columns. Each cell represents a possible edge.
- **Adjacency List**: Graph representation where each vertex has a list of all the vertices it shares an edge with.
