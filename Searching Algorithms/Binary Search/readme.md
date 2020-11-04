# Searching Algorithm's In Python

This is a repository made to help people who want to get started with data structures and algorithm's.

It is ideal for people who have just got started with learning about searching algorithm's.

## Binary Search

With a sorted data-set, we can take advantage of the ordering to make a sort which is more efficient than going element by element.

Binary search requires a sorted data-set. We then take the following steps:

1. Check the middle value of the dataset.
2. If this value matches our target we can return the index.
3. If the middle value is less than our target
4. Start at step 1 using the right half of the list.
5. If the middle value is greater than our target
6. Start at step 1 using the left half of the list.

We eventually run out of values in the list, or find the target value.

### Time Complexity of Binary Search

How efficient is binary search?

In each iteration, we are cutting the list in half. The time complexity is O(log N).

A sorted list of 64 elements will take at most log2(64) = 6 comparisons.

In the worst case:

Comparison 1: We look at the middle of all 64 elements

Comparison 2: If the middle is not equal to our search value, we would look at 32 elements

Comparison 3: If the new middle is not equal to our search value, we would look at 16 elements

Comparison 4: If the new middle is not equal to our search value, we would look at 8 elements

Comparison 5: If the new middle is not equal to our search value, we would look at 4 elements

Comparison 6: If the new middle is not equal to our search value, we would look at 2 elements

When there’s 2 elements, the search value is either one or the other, and thus, there is at most 6 comparisons in a sorted list of size 64.

- By Indraan S. Toor
