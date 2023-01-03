## Joseph Corey's Java Badge for FamilySearch

This project is to demonstrate the abilities and knowledge of Joseph Corey in Java, based off of the framework in [[This Confluence Page](https://fhconfluence.churchofjesuschrist.org/display/~pattonjm/Core+Skills+-+Java%3A+Apprentice+Badge)]

1. Describe the lifecycle of an object instance in Java and how garbage collection works: 
   1. When you instantiate an object (e.g. with the "new" key word) the jvm allocates heap memory for that object and sets up a reference so the runtime can track it, and it's instance variables are initialized do their default values.
   2. When the object is used (e.g. a method is called on it), the reference to the object is followed and the object on the heap is accessed.
   3. When the object is no longer in scope, or otherwise unreachable (e.g. declared to be null), it will eventually be cleaned up by the java garbage collector, which frees up the memory and resources that object used. Or, you can manually call the garbage collector with Runtime.getRuntime().gc();
      1. The overridable function finalize may be called when the garbage collector is ready to delete it, but it's not guaranteed to do so.
      2. The java garbage collector periodically checks all objects in memory to see if they are eligible for garbage collection
   4. Sources: ([This Video](https://www.youtube.com/watch?v=ksflpaDy-qA), [This Confluence Page](https://fhconfluence.churchofjesuschrist.org/display/~pattonjm/Core+Skills+-+Java%3A+Apprentice+Badge), [This Confluence Page](https://fhconfluence.churchofjesuschrist.org/display/~nufferpq/Perry+Nuffer%3A+Java+Apprentice+Badge))

2. Describe how the basic data types are represented in memory (Sources: [This article](https://www.tutorialspoint.com/java/java_basic_datatypes.htm) and [this article](https://www.guru99.com/java-stack-heap.html))
   1. Primitives:
      1. byte - 8-bit (1 byte) signed int (-128 to 127)        (All primitives outside of a class (ie. instance variables) are stored in the stack.  Objects and their fields are stored in the heap.) boolean: 1 bit (theoretically, probably actually a bit more), int: 32 bits, long: 64 bits, String: varies in size, but is placed in a special part of memory called the String pool (unless new String is specifically called, which is generally a no-no), array of ints: a specific number of side-by-side integers in memory, array of Objects: a specific number of references (essentially pointers) to objects side-by-side, class with fields: both the class and its instance variables (fields) are stored in the heap.)
      2. short - 16-bit (2 byte) signed int (-32,768 to 32,767)
      3. int - 32-bit (4 byte) signed int (-2,147,483,648 to 2,147,483,647)
      4. long - 64-bit (8 byte) signed int (-9,223,372,036,854,775,808 to 9,223,372,036,854,775,807)
      5. float - 32-bit single-precision floating point number
      6. double - 64-bit double-precision floating point number
      7. boolean - 1 bit, though it looks like in actuality they may take about a byte of memory, though this can depend on the  (Source: [Stack Overflow](https://stackoverflow.com/questions/383551/what-is-the-size-of-a-boolean-variable-in-java))
   2. Objects & stack vs. heap:
      1. Local variables (e.g. within a function) are located on the stack, as are methods and references to the objects stored in the heap
      2. Objects are represented with their instance variables in the heap, with a reference to them stored on the stack
   3. Arrays: (Source: [This Confluence Page](https://fhconfluence.churchofjesuschrist.org/display/~nufferpq/Perry+Nuffer%3A+Java+Apprentice+Badge), [This Stack Overflow](https://stackoverflow.com/questions/45893192/is-memory-to-array-allocated-on-stack-or-heap-in-java), and conflicting information from [This Article](https://www.geeksforgeeks.org/where-is-the-memory-allocated-for-arrays-in-java/))
      1. Arrays are stored on the heap, with references to the arrays on the stack.
   4. Strings: (Source: [This article](https://iq.opengenus.org/string-pool-in-java))
      1. When you put a String Literal in code, it's stored in a special place in the heap called the String Pool.
      2. The String pool is there to save storage space - if you use the same string multiple times in code, every time you use it is references the same place in memory. (e.g. `a = "Hi"; b = "Hi";` - a and b point to the same memory location in the String Pool, and `a == b`)
      3. If you use `new String("Hello World")`, the string is saved in the heap but not in the String Pool, and it's reference points to a different memory location (e.g.`a = "Hi"; b = new String("Hi");` - a and b point to different memory locations, and `a != b`)
      4. Because of this nuance with String storage, you should always compare Strings with `.equals()`, which compares the value of the strings, instead of `==`, which compares the memory location (e.g. `"Hi" == "Hi"`, but `"Hi" != new String("Hi")`. However, `"Hi".equals(new String("Hi"))`)
      5. See also `misc/StringBuilderStringBufferTest`

3. Write an application to find out how many total characters can be held in a list of strings before you run out of memory:
   1. See `q2_stringlist/StringListMemoryExperiment` - short answer: Overflowed a Long trying to figure it out

4. Compare and contrast StringBuffer and StringBuilder and when to use each (Source: [This article](https://www.geeksforgeeks.org/difference-between-stringbuffer-and-stringbuilder-in-java/))
   1. The API for both classes are practically the same, the main difference is threadsafeness/synchronization:
      1. StringBuffer is synchronized, meaning only one thread can call its methods at a time. This means it's threadsafe, but it's slower on account of these checks.
      2. StringBuilder is asynchronized, so multiple threads can call it at once. It is faster, but not threadsafe.

5. Compare/contrast use of ArrayList / LinkedList / HashMap / HashSet / TreeSet (Sources: [This Confluence Page](https://fhconfluence.churchofjesuschrist.org/display/~pattonjm/Core+Skills+-+Java%3A+Apprentice+Badge), [this article](https://www.golinuxcloud.com/arraylist-vs-linkedlist-in-java/), [this article](https://www.baeldung.com/java-arraylist-vs-linkedlist-vs-hashmap), [this documentation page](https://www.javatpoint.com/java-hashmap), and [this article](https://www.java67.com/2012/08/difference-between-hashset-and-treeset-java.html))
   1. ArrayList:
      1. Good for ordered lists of items, Best for if you just want to store and access data. Slower than a built-in array, but dynamically handles size.
      2. Implements List interface, stores items with a dynamic array
      3. Adding items to the end is fast, but adding to a specific index and removing items can be kind of slow because of working with the memory of the array. Accessing items is fast.
      4. Can't store more than 2^32 items, no memory overhead
   2. LinkedList
      1. Good for ordered lists of items if you're doing lots of manipulation to the list
      2. Implements both List and Dequeue interface, stores items with doubly-linked list
      3. Adding and removing items is pretty fast, but accessing items is a bit slower than an ArrayList
      4. No limitation on number of items, but some memory overhead from the pointers in the linked list
   3. HashMap
      1. Good for key-value pairs
      2. Implements Map interface, stores items with hash map. Only unique keys can be used, and order is not maintained. It's not synchronized.
      3. Adding items and retrieving items based on the key is fast, but finding an item without the key is slower.
   4. HashSet
      1. Good for fast unique unordered collections of items
      2. Implements the Set interface, stores items in hash order. Only unique items can go in (when compared with `.equals()`), and order is not maintained. It's not synchronized.
      3. Operations with HashSet are faster than with TreeSet, but order isn't maintained.
   5. TreeSet
      1. Good for unique ordered collections of items.
      2. Implements the Set interface, stores items in a tree to maintain order. Only unique items can go in (when compared with `.compareTo()`). It's not synchronized.
      3. Operations aren't quite as fast as with a HashSet, but order is maintained.

         1. ArrayList acts like an array: it has a list of objects that are (at least as far as we can see) one after the other in memory.
         ArrayList is great for random access.
         LinkedList uses the linked list data structure, which uses pointers to point from one object to the next and previous objects in a list.
         LinkedList is great for applications where you do a lot of insertions and removals.
         HashMap maps keys to values within a hash map data structure, which stores them in different buckets based on their hash code
         in order to improve performance.  The keys must be unique, the values don't have to be unique.

         2. HashMaps are great when you need unordered maps of keys and values.  
         HashSet is similar to a List, but only keeps unique values.  In Java a HashSet actually encapsulates a HashMap, and simply
         stores keys with empty values.
         TreeSet is similar to HashSet, but with ordered values.  TreeSet is advantageous over HashSet when you need things to be ordered for some reason, such as for iteration.

6. Write an application to read a file with 10k lines of text, and output another file with the lines in sorted order (sample file)
   1. See `q6_sortfile/SortFile.java`, setting `boolean sortReverse = false;`
7. Write an application to read a file with 10k lines of text, and output another file with the lines in reverse sorted order
   1. See `q6_sortfile/SortFile.java`, setting `boolean sortReverse = true;`
8. Write code to show exception handling including examples of checked, unchecked, and Error exceptions
   1. See `q8_exceptions/ExceptionHandler.java`
9. Write your own enum type.
   1. See `q9_enum/LicenceTypeEnum.java`
##Working with Methods, Encapsulation and Inheritance
10. Show how to use a common piece of logic from two different classes, in three different ways: 1) by composition, 2) by inheritance, and 3) by static method calls, discuss the tradeoffs - 
    My examples are pretty simple, and not the most practical for use, but they illustrate the point. 
    1. The first one uses an Engine class with a method for figuring out range, and the Car class calls that. This is good for putting things that conceptually belong in one class only in that class, in a way you can access in that class. This is also used for "has-a" relationships - a car has an engine. Unlike static methods, this would be something a bit more involved, or accessing instance variables. See `q10_logic_sharing/composition`.
    2. Inheritance is good when you have an "is-a" relationship - e.g. a truck is a car. It lets you only put the differences between the new class and the old class in your code. It's best when different classes have different logic from each other.See `q10_logic_sharing/inheritance`.
    3. Static methods are good for accessing variables or methods specific to a class, but not an object. In the example I made, using static methods likely wasn't the best design choice, but I wanted to be consistent across my examples. This could be used if all you wanted to know was abstract information about cars (e.g. the class), and not information about specific cars (objects). Static methods are also good for helper classes. See `q10_logic_sharing/static_method`.

11. Create and overload constructors -- Create a class that has 4 fields and construct the class with variations of one required field and the others are optional.  Use constructor chaining as an example. 
    1. See `q11_constructors/Account.java` - this is a hypothetical bank account with an id, and an option to make it a kid's/vip account, and start with a certain amount of money. 

12. Apply encapsulation principles to a class -- (Sources: [this article](https://www.geeksforgeeks.org/encapsulation-in-java/), [this article](https://www.w3schools.in/java/encapsulation), [this article](https://www.geeksforgeeks.org/access-modifiers-java/))
    1. Show an example of good encapsulation.  
       1. See `q12_encapsulation/Rectangle.java` - This encapsulation has checks for setters, and a getter for area as well as width and height. Good encapsulation can also include removing getters or setters if you want to control access, e.g. to make some items read-only or write-only.
    2. Show a bad example of encapsulation and explain why.  
       1. See `q12_encapsulation/Account.java` - This is an example of bad encapsulation for a few reasons. Even though the class variables are private, they are all accessible through getters and setters. Especially concerning is the ability to just change the ID, and the ability to read and write the secretAccessKey, which should be at least write protected, and probably read-protected as well (Likely the architecture would be very different if you were doing this as a whole project, but if I had to do it as close to this way as possible, I'd probably have a method for checking if a given secretAccountKey is equal to the object's key. 
    3. Additionally explain access modifiers and how they can be used as part of the class encapsulation. 
       1. Default - if there's no specific access modifier, you can access those methods/data from within the same package.
       2. Private - you can only access that variable/method within that class (and not within subclasses). Good for variables and methods that you don't want other classes to have access to, (e.g. the secretAccessKey I mentioned above)
       3. Protected - you can only access that variable/method within that package and within subclasses in other packages. 
       4. Public - you can access that variable/method anywhere
       5. Package-Protected - Same thing as default, only accessible within the same package.
    Generally it's best to try to keep things as private as you can. Things that don't need to be public shouldn't be.

13. Determine the effect upon object references and primitive values when they are passed  into methods that change the values -- Create a method 3 parameters, one parameter passed by value, one passed by reference and one with the keyword final.  Explain each and what the effects in side the method that changes each one. 
    1. See `q13_references/ReferenceTest.java`:
       1. When you pass an item by value, any change to the value in the method doesn't change the value of that variable outside that method
       2. When you pass an item by reference, any change to the item's value in the method "leaks" out of the method. (I think one of the paradigms of functional programming is to avoid this entirely)
       3. When you try to alter a final variable after it has first been set, it won't succeed and will throw an error (though you can pass the value of the final variable in, and it works as a pass-by-value)

14. Write code to show how access modifiers work: private, protected, and public, talk about why you would use each of these. 
    1. See `q14_access_modifiers` and all the code in there for examples.
    2. When to use (see also the discussion in 12.2):
       1. Private: default if you can, only accessable within the same class.
       2. Protected: Use if you want it to be accessable within the package, but don't need access outside the package.
       3. Public: Only use if you need access outside of the package. Generally only methods should be public, you should really try to just access fields in a class through getters and setters.

15. Write code to show how virtual method invocation lets one implementation be swapped for another.

16. Write code that uses the instanceof operator and show how casting works.

17. Show how to override a method in a subclass, talk about plusses and minuses in doing so. See VirtualMethod. Plusses: You can have generic logic in the super class, and more specific logic in the subclasses.  You can also call the super class in the overridden method and use the logic already there.  Cons: It's generally not a good idea to override code that has already been written, because it may end up doing something either you or the client doesn't expect. It's better to use something like the Template Method Pattern.
Show how to overload constructors and methods, talk about plusses and minuses in doing so. See overloading. Plusses: Allows you to use a number of different arguments to either create an object or use a method, making them more versatile.  Minuses: You have to be very careful how you implement them, as they can often be confusing: you should never rearrange the order of variables as you add more arguments.  It also may not be very clear what the method or constructor is doing, and it may be more clear if you just have a method with a different name.  You should also consider using the Builder pattern instead, if doing constructors (Especially if you end up with more than 3-4 constructors).
Library
18. Write an application that uses the slf4j logging library directly (can also choose log4j if you want) See VirtualMethod.
    1. Do the following:
       1. configure the logging using an accepted department log statement format (see Application Logging)
       log at different logging levels (error, warn, info, debug), to see the effect of the default logging level setting
       2. turn on DEBUG in the logging config to show DEBUG output
       3. configure logging to go to both the console and a log file
