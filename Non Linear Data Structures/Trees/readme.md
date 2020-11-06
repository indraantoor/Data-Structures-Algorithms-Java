# Trees
Trees are an essential data structure for storing hierarchical data with a directed flow.

Similar to linked lists and graphs, trees are composed of nodes which hold data. The diagram represents nodes as rectangles and data as text.

Nodes also store references to zero or more other tree nodes. Data moves down from node to node. We depict those references as lines drawn between rectangles.

Trees are often displayed with a single node at the top and connected nodes branching downwards.

## Varietals

Trees come in various shapes and sizes depending on the dataset modeled.

Some are wide, with parent nodes referencing many child nodes.

Some are deep, with many parent-child relationships.

Each time we move from a parent to a child, we’re moving down a level. 

Depending on the orientation we refer to this as the depth (counting levels down from the root node) or height (counting levels up from a leaf node).

## Structure

A tree is composed of tree nodes. There is a root tree node, and children tree nodes which may or may not be parent nodes themselves.

A tree node is a very simple data structure that contains:

* Data
* A list of children, where each child is itself a tree node
* Pointer to a parent tree node (Optional)

## Depth First Traversal
Depth-first-search (DFS) is a technique that visits the first child in the children list and that node’s children recursively before visiting all the first child’s siblings and then their children recursively.

## Breadth First Traversal
Breadth-first-search (BFS) is a technique in a tree that visits all children of a node first before visiting any further levels.

Both are implemented in the code. 