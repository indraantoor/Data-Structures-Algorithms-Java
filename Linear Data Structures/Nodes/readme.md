# Nodes
Nodes are the fundamental building blocks of many computer science data structures. 

They form the basis for linked lists, stacks, queues, trees, and more.

An individual node contains data and links to other nodes. 

Each data structure adds additional constraints or behavior to these features to create the desired structure.

## Nodes Data
The data contained within a node can be a variety of types (depending on the language being used). 

The link or links within the node are sometimes referred to as _pointers_. This is because they “_point_” to another node.

Typically, data structures implement nodes with one or more links. If these links are _null_, it denotes that you have reached the _end of the particular node_ or link path you were previously following.

## Linking

It is very important to consider how you implement, modify or removing nodes from a data structure.

If you _inadvertently_ remove the single link to a node, that node’s data and any linked nodes could be “**lost**” to your application. When this happens to a node, it is called an **orphaned node**.
 