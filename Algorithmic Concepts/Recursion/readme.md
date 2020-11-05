# Recursion
Recursion has _two_ fundamental aspects: 
1. **Base Case** 
2. **Recursive Step**

When using iteration, we rely on a counting variable and a boolean condition. 

For example, when iterating through the values in a list, we would increment the counting variable until it exceeded the length of the dataset.

Recursive functions have a similar concept, which we call the **base case**. 

The _base case_ dictates whether the function will recurse, or call itself. Without a base case, it’s the iterative equivalent to writing an _infinite loop_.

Because we’re using a **call stack** to track the function calls, your computer will throw an error due to a _stack overflow_ if the base case is not sufficient.

The other fundamental aspect of a recursive function is the recursive step. 

This portion of the function is the step that moves us closer to the base case.

In an iterative function, this is handled by a loop construct that decrements or increments the counting variable which moves the counter closer to a boolean condition, terminating the loop.

In a recursive function, the “counting variable” equivalent is the argument to the recursive call. 

If we’re counting down to 0, for example, our base case would be the function call that receives 0 as an argument. 

We might design a recursive step that takes the argument passed in, decrements it by one, and calls the function again with the decremented argument. 

In this way, we would be moving towards 0 as our base case.

Analyzing the Big O runtime of a recursive function is very similar to analyzing an iterative function. Substitute iterations of a loop with recursive calls.

Also learn about _Call Stacks and Execution Frames_, it will help understand recursion even better.