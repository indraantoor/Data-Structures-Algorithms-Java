# Binary Search Trees
A binary tree is a type of tree where each parent can have no more than two children, known as the left child and right child.

Further constraints make a binary search tree:

* Left child values must be lesser than their parent.
* Right child values must be greater than their parent.

Binary Search Tree is an efficient value structure for fast (**O(log N)**) data storage and retrieval. 

It is a specialized tree data structure that is made up of a root node, and at most two child branches or subtrees. 

## Inserting Value
When inserting a new value into a Binary Search Tree, we compare it with the root node’s value.

If a new value is _less_ than the current (root) node’s value, we want to insert it as a descendant on the _left side_.

* If a left child to the current node doesn’t already exist, we create a new BinarySearchTree node with that value as this node’s left child.
* If a left child already exists, we would call insert() recursively on the current node’s left child to insert further down.

If the new value is greater than the current (root) node’s value, we’ll want to insert it as a descendant on the right side and apply
same logic but this time for right side.

## Traversing 
There are two main ways of traversing a binary tree: 
1. Breadth First
2. Depth First

With **breadth first** traversal, we begin traversing at the top of the tree’s root node, displaying its value and continuing the process with the left child node and the right child node. 

Descend a level and repeat this step until we finish displaying all the child nodes at the deepest level from left to right. 

With **depth first** traversal, we always traverse down each left-side branch of a tree fully before proceeding down the right branch. 

There are _three_ traversal options:

1. **Preorder**: Is when we perform an action on the current node first, followed by its left child node and its right child node
2. **Inorder**: Is when we perform an action on the left child node first, followed by the current node and the right child node
3. **Postorder**: Is when we perform an action on the left child node first, followed by the right child node and then the current node
