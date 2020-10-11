# Linked List

The list is comprised of a series of nodes. The **head node** is the node at the beginning of the list. 

Each node contains data and a _link/pointer_ to the _next node_ in the list. The list is terminated when a node’s link is null. This is called the **tail node**.

The nodes use links to denote the next node in the sequence, the nodes are not required to be sequentially located in memory. These links also allow for quick insertion and removal of nodes.

Common operations on a linked list:
1. Adding Nodes
2. Removing Nodes
3. Finding Node
4. Traversing 

## Adding A Node
We can add a node at the: 
1. Beginning
2. Middle
3. End

We can add a new node to the beginning of the list by linking your new node to the current head node. 

This way, the connection with the following nodes in the list will also be maintained.

## Removing A Node
If we accidentally remove a single link to a node, that node’s data and any following nodes could be lost and we will 
have to deal with _orphaned nodes_.

To properly maintain the list when removing a node from the middle of a linked list, we need to adjust the 
previous node so that it points to the following node.

Depending on the language, nodes which are not referenced are removed automatically. 

“Removing” a node is equivalent to removing all references to the node.
