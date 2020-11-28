# Heaps

Heaps are used to maintain a maximum or minimum value in a dataset.

We can manage this problem using a priority queue to ensure we are always working on the most pressing assignment and heaps are commonly used to create a priority queue.

Heaps _tracking_ the _maximum or minimum value_ are **max-heaps** or **min-heaps**.
Think of the min-heap as a binary tree with two qualities:

- The root is the minimum value of the dataset.
- Every child’s value is greater than its parent.

By maintaining these two properties, we can efficiently retrieve and update the minimum value.

## Representation

We can picture min-heaps as binary trees, where each node has at most two children.

As we add elements to the heap, they’re added from left to right until we’ve filled the entire level.

Conceptually, the tree representation is beneficial for understanding.

Practically, we implement heaps in a sequential data structure like an _array or list_ for efficiency.

The location of each child or parent derives from a _formula_ using the index.

- **Left Child**: (index \* 2) + 1
- **Right Child**: (index \* 2) + 2
- **Parent**: (index - 1) / 2 - not to be used on root

## Heapify Up - Adding Element

Sometimes we add an element to the heap that violates the heap’s essential properties.

We need to restore the fundamental heap properties.

This _restoration_ is known as **heapify** or **heapifying**.

We’re "_adding_" an element to the bottom of the tree and moving upwards, so we’re **heapifying up**.

As long as we’ve violated the heap properties, we’ll swap the offending child with its parent until we restore the properties, or until there’s no parent left.

If there is no parent left, that element becomes the new root of the tree.

## Heapify Down - Remove Element

Heapify down is used when we remove the top element from a heap.

Removal of an element is done by swapping the top element with the last element at the bottom of the tree, removing the last element, and then heapfying the new top element down to maintain the heap property.

Because this moves down the heap tree, it must perform two comparisons per iteration, with the left child and the right child elements, then swap with the smaller one.

Because of this, heapify down is usually more _complex_ to implement than heapify up.

We have implemented min-heap using python in the code because:

**Min-heaps are nearly identical to a max-heap, just with the comparisons reversed.**

The relationship between the maximum number of nodes, N, of a binary tree and its height, h, is:
N = 2^{h+1} - 1
