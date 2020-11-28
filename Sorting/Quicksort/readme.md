# Quick Sort
Quicksort is an efficient recursive algorithm for sorting arrays or lists of values. The algorithm is a comparison sort, where values are ordered by a comparison operation such as **> or <**.

Quicksort uses a **divide and conquer strategy**, breaking the problem into smaller sub-problems until the solution is so clear there’s nothing to solve.

We choose a single pivot element from the list. Every other element is compared with the pivot, which partitions the array into three groups.

1. A sub-array of elements smaller than the pivot.
2. The pivot itself.
3. A sub-array of elements greater than the pivot.

The process is repeated on the sub-arrays until they contain zero or one element. 

Elements in the “smaller than” group are never compared with elements in the “greater than” group. 

If the smaller and greater groupings are roughly equal, this cuts the problem in half with each partition step.

Depending on the implementation, the sub-arrays of one element each are recombined into a new array with sorted ordering, or values within the original array are swapped in-place, producing a sorted mutation of the original array.

## Quick Sort Runtime
The key to Quicksort’s runtime efficiency is the division of the array.

The **worst case** occurs when we have an **_imbalanced partition_** like when the first element is continually chosen in a sorted data-set.

One popular strategy is to select a random element as the pivot for each step. The benefit is that no particular data set can be chosen ahead of time to make the algorithm perform poorly.

Another popular strategy is to take the first, middle, and last elements of the array and choose the median element as the pivot. 

The benefit is that the division of the array tends to be more uniform.

Quicksort is an unusual algorithm in that the **worst case runtime is O(N^2)**, but the **average case is O(N * logN)**.

## Code
1. We established a base case where the algorithm will complete when the start and end pointers indicate a list with one or zero elements.

2. If we haven’t hit the base case, we randomly selected an element as the pivot and swapped it to the end of the list

3. We then iterate through that list and track all the “lesser than” elements by swapping them with the iteration index and incrementing a lesser_than_pointer.

4. Once we’ve iterated through the list, we swap the pivot element with the element located at lesser_than_pointer.

5. With the list partitioned into two sub-lists, we repeat the process on both halves until base cases are met.