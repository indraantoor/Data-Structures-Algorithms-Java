# Hash Maps

Hashing is a Data Structure which is designed to use a special function called the Hash function which is used to map
a given value with a particular key for faster access of elements.

## Tables

A data structure’s main utility is allowing for data to be represented in a way that
resembles the way people will use that data.

In some cases, the primary function of that data is that it will be
sequenced through like a list and so we use a data structure that allows for easier iteration, like a linked list. In others, the usefulness comes from specifying interrelationships within the data.

In the case of tabular data there is a relationship between the elements
of a row. Each column corresponds to a different feature of the row.

**Maps**: Being a map means relating two pieces of information.

## Methodology

In the case of a map between two things, we don’t really care about the exact sequence of the data.

We only care that a given input, when fed into the map, gives the accurate output.

Developing a data structure that performs this is tricky because computers care much more about values than relationships.

A computer doesn’t really care to memorize the astrological signs of all of our friends, so we need to trick the computer into caring.

We perform this trick using a structure that our computer is already familiar with, an array. An array uses indices to keep track of values in memory, so we’ll need a way of turning each key in our map to an index in our array.

We use a special function that turns data like the string “Hello” into a number. This function is called a **hashing function**, or a **hash function**.

## Hash Functions

A hash function takes a string (or other type of data) as input and returns an array index as output.

In order for it to return an array index, our hash map implementation needs to _know the size of our array_.

In order for our hash map implementation to guarantee that it returns an index that fits into the underlying array, the hash function will first compute a value using some scoring metric: this is the hash value, hash code, or just the hash.

Our hash map implementation then takes that hash value mod the size of the array.

This guarantees that the value returned by the hash function can be used as an index into the array we’re using.

Hash functions greatly reduce any possible inputs (any string you can imagine) into a much smaller range of potential outputs (an integer smaller than the size of our array).

For this reason _hash functions_ are also known as **compression functions**.

Hashing is a _irreversible process_ which means that with just a hash value, it is _impossible_ to know for sure the key that was plugged into the hashing function.

## Writing A Hash Function

Hash function needs to be _simple by design_.

Performing complex mathematical calculations that our hash table needs to compute every time it wants to assign or retrieve a value for a key will significantly damage a hash table’s performance.

Hash functions also need to be able to take whatever types of data we want to use as a key.

A very common hash function for integers, for example, is to perform the modular operation on it to make sure it’s less than the size of the underlying array.

If the integer is already small enough to be an index into the array, there’s nothing to be done.

Many hash functions implementations for strings take advantage of the fact that strings are represented internally as numerical data.

Frequently a hash function will perform a shift of the data bitwise, which is computationally simple for a computer to do but also can predictably assign numbers to strings.

## Collisions

Hash functions are designed to _compress data_ from a large number of possible keys to a much smaller range.

Because of this compression, it’s likely that our hash function might produce the same hash for two different keys. This is known as a **hash collision**.

## Strategies To Avoid Collision

We can avoid collision in Hash Maps using these commonly used techniques.

## Separate Chaining

The user wants to assign a value to a key in the map. The hash map takes the key and transforms it into a hash code.

The hash code is then converted into an index to an array using the modulus operation. If the value of the array at the hash function’s returned index is empty, a new linked list is created with the value as the first element of the linked list.

If a linked list already exists at the address, append the value to the linked list given.

This is effective for hash functions that are particularly good at giving unique indices, so the linked lists never get very long.

But in the worst-case scenario, where the hash function gives all keys the same index, lookup performance is only as good as it would be on a linked list.

Hash maps are frequently employed because looking up a value (for a given key) is quick.

Looking up a value in a linked list is much slower than a perfect, collision-free hash map of the same size.

A hash map that uses separate chaining with linked lists but experiences frequent collisions loses one of its most essential features.

## Saving Keys

A hash collision resolution strategy like _separate chaining_ involves assigning two keys with the same hash to different parts of the underlying data structure.

How do we know which values relate back to which keys?

If the linked list at the array index given by the hash has multiple elements, they would be indistinguishable to someone with just the key.

If we save both the key and the value, then we will be able to check against the saved key when we’re accessing data in a hash map.

By saving the key with the value, we can avoid situations in which two keys have the same hash code where we might not be able to distinguish which value goes with a given key.

Now, when we go to read or write a value for a key we do the following: calculate the hash for the key, find the appropriate index for that hash, and begin iterating through our linked list.

For each element, if the saved key is the same as our key, return the value.

Otherwise, continue iterating through the list comparing the keys saved in that list with our key.

## Open Addressing - Linear Probing

In open addressing we stick to the array as our underlying data structure, but we continue looking for a new index to save our data if the first result of our hash function has a different key’s data.

A common open method of open addressing is called **probing**.

Probing means continuing to find new array indices in a fixed sequence until an empty index is found.

## Other Open Addressing Techniques

There are more sophisticated ways to find the next address after a hash collision, although anything too calculation-intensive would negatively affect a hash table’s performance.

**Linear probing systems**, for instance, could jump by five steps instead of one step.

In a **Quadratic Probing** open addressing system, we add increasingly large numbers to the hash code.

At the first collision we just add 1, but if the hash collides there too we add 4 ,and the third time we add 9.

Having a probe sequence change over time like this avoids clustering.

**Clustering** is what happens when a _single hash collision causes additional hash_ _collisions_.

As a result the new key needs to be assigned to the next, next bucket over.

This propagates the problem because now there are two hash buckets taken up by key-value pairs that were assigned as a result of a hash collision, displacing further pairs of information we might want to save to the table.

## Overview

1. **Hash map**: A key-value store that uses an array and a hashing function to save and retrieve values.
2. **Key**: The identifier given to a value for later retrieval.
3. **Hash function**: A function that takes some input and returns a number.
4. **Compression function**: A function that transforms its inputs into some smaller range of possible outputs.

**Recipe for saving to a hash table:**

- Take the key and plug it into the hash function, getting the hash code.
- Modulo that hash code by the length of the underlying array, getting an array index.
- Check if the array at that index is empty, if so, save the value (and the key) there.
- If the array is full at that index continue to the next possible position depending on your collision strategy.

**Recipe for retrieving from a hash table:**

- Take the key and plug it into the hash function, getting the hash code.
- Modulo that hash code by the length of the underlying array, getting an array index.
- Check if the array at that index has contents, if so, check the key saved there.
- If the key matches the one you're looking for, return the value.
- If the keys don't match, continue to the next position depending on your collision strategy.
