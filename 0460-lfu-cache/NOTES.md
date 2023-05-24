# LFUCache

The LFUCache class implements a Least Frequently Used (LFU) cache. An LFU cache is a data structure that stores elements in a linked list based on their frequency of use. The least frequently used elements are stored at the head of the linked list, and the most frequently used elements are stored at the tail of the linked list. When the cache reaches its capacity, the least frequently used element is removed.

The LFUCache class has the following members:

* `cap`: The capacity of the cache.
* `min`: The minimum frequency of use.
* `keyValueMap`: A map that stores the key-value pairs in the cache.
* `keyFrequencyMap`: A map that stores the frequency of use for each key in the cache.
* `freqKeysMap`: A map that stores the keys in the cache, grouped by their frequency of use.

The LFUCache class has the following methods:

* `LFUCache(int capacity)`: Constructs a new `LFUCache` object with the specified capacity.
* `get(int key)`: Returns the value for the specified key, or -1 if the key is not in the cache.
* `put(int key, int value)`: Adds the specified key-value pair to the cache, or updates the value for the specified key if the key is already in the cache. If the cache reaches its capacity, the least frequently used element is removed.

## get()

The `get()` method works as follows:

1. If the key is not in the cache, return -1.
2. Get the frequency of use for the key.
3. Remove the key from the linked list for its current frequency of use.
4. If the frequency of use is equal to the minimum frequency of use and the linked list for that frequency of use is empty, increment the minimum frequency of use.
5. If there is no linked list for the next frequency of use, create a new linked list.
6. Add the key to the linked list for the next frequency of use.
7. Return the value for the key.

## put()

The `put()` method works as follows:

1. If the capacity is <= 0, return.
2. If the key is already in the cache, update the value for the key and then call `get()`.
3. If the cache is at capacity, remove the least frequently used element.
4. Add the key-value pair to the cache.

