# IntMap
This project is an attempt at making optimized Maps that uses Integers as keys.

## ⚠️ 
This project is far from being finished. Currently, IntMaps should be used in production as some of the Map's features are not optimized / implemented.

## How does it works
The IntMap works by creating an array with the specified capacity *(max key + 1)*. A more advanced IntMap class will maybe be implemented in the future.

## Example
Lets for example,  create an IntMap called **myIntMap** that has a capacity of 10 elements and contains Strings:
```java
// 10 = the max key index, not the capacity
IntMap<String> myIntMap = new IntMap(10);
myIntMap.put(1, "hello world!");
myIntMap.put(5, "my very good string.");
myIntMap.put(11, "why not me?"); // Causes IndexOutOfBoundsException

String myString = myIntMap.get(5);
```

## Use cases
For example, you could use IntMaps in Minecraft GUIs to support gui slots without any items while still storing the items efficiently.