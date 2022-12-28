##Joseph Corey's Java Badge for FamilySearch

This project is to demonstrate the abilities and knowledge of Joseph Corey in Java, based off of the framework in [[This Confluence Page][https://fhconfluence.churchofjesuschrist.org/display/~pattonjm/Core+Skills+-+Java%3A+Apprentice+Badge]]

1. Describe the lifecycle of an object instance in Java and how garbage collection works: 
   1. When you instantiate an object (e.g. with the "new" key word) the jvm allocates heap memory for that object and sets up a reference so the runtime can track it, and it's instance variables are initialized do their default values.
   2. When the object is used (e.g. a method is called on it), the reference to the object is followed and the object on the heap is accessed.
   3. When the object is no longer in scope, or otherwise unreachable (e.g. declared to be null), it will eventually be cleaned up by the java garbage collector, which frees up the memory and resources that object used. Or, you can manually call the garbage collector with Runtime.getRuntime().gc();
      1. The overridable function finalize may be called when the garbage collector is ready to delete it, but it's not guaranteed to do so.
      2. The java garbage collector periodically checks all objects in memory to see if they are eligible for garbage collection
   4. Sources: (https://www.youtube.com/watch?v=ksflpaDy-qA, https://fhconfluence.churchofjesuschrist.org/display/~pattonjm/Core+Skills+-+Java%3A+Apprentice+Badge, https://fhconfluence.churchofjesuschrist.org/display/~nufferpq/Perry+Nuffer%3A+Java+Apprentice+Badge)

2. Describe how the basic data types are represented in memory 
   1. (All primitives outside of a class (ie. isntance variables) are stored in the stack.  Objects and their fields are stored in the heap.) boolean: 1 bit (theoretically, probably actually a bit more), int: 32 bits, long: 64 bits, String: varies in size, but is placed in a special part of memory called the String pool (unless new String is specifically called, which is generally a no-no), array of ints: a specific number of side-by-side integers in memory, array of Objects: a specific number of references (essentially pointers) to objects side-by-side, class with fields: both the class and its instance variables (fields) are stored in the heap.)

3. Write an application to find out how many total characters can be held in a list of strings before you run out of memory:
   1. See <stringlist/StringListMemoryExperiment> - short answer: Overflowed a Long trying to figure it out

4. Compare and contrast StringBuffer and StringBuilder and when to use each

   1. StringBuilder and StringBuffer are almost exactly the same, except StringBuffer is thread-safe.  To be honest, I haven't yet
   seen a legitimate reason to use StringBuffer, but that may just be due to my experience.  Generally, unless you need multi-
   thread protection, StringBuilder is better to use simply because it can be more efficient (though only marginally so)

5. Compare/contrast use of ArrayList / LinkedList / HashMap / HashSet / TreeSet

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
SortFile.java 
7. Write an application to read a file with 10k lines of text, and output another file with the lines in reverse sorted order
RSortFile.java 
8. Write code to show exception handling including examples of checked, unchecked, and Error exceptions: For Error exception handling, see my TotalChar file, that's what I use to get the number of characters.
ExceptionHandling.java 
9. Write your own enum type.  Describe when you would use it: It's pretty simple, part of a program I used to practice using the Builder pattern and TestNg.  It simply is an enum of the different types of measure used for nutrition labels.  I might eventually add more to it, but there's not much need.
MeasureType.java

##Working with Methods, Encapsulation and Inheritance
10. Show how to use a common piece of logic from two different classes, in three different ways: 1) by composition, 2) by inheritance, and 3) by static method calls, discuss the tradeoffs - My examples are very very simple, but hopefully they get the point across.  Generally, it is advised to use composition over inheritance when possible.  Inheritance is very good when you have a very similar base, but a few things are different that you want to add for the children (though you should think very carefully before you use just inheritance). Ideally, you use inheritance for components within a class that have variable logic.  Static method calls can be useful if you don't want to have to create instances whenever you want to use logic, and is great especially for helper classes, but can be less advantageous if you want to be able to store some sort of state (for example, if you have to use multiple parts of logic from that class with the same data).

11. Create and overload constructors -- Create a class that has 4 fields and construct the class with variations of one required field and the others are optional.  Use constructor chaining as an example. -I don't much like constructor chaining, I think the Builder method is better, but I can see the use for very small things (ie. only 2 or 3 optional params).

12. Apply encapsulation principles to a class -- Show an example of good encapsulation.  Show a bad example of encapsulation and explain why.  Additionally explain access modifiers and how they can be used as part of the class encapsulation. For bad encapsulation: It is generally not a good idea to just use getters and setters (There are exceptions, but those are rare).  Rather, whatever you use to manipulate the data within the class should do more than just get and set.  For example, when you get the data, the user shouldn't have to worry about how the data is stored, but rather a common element that they know should be returned, such as a String, etc., or if it's something like a date, it should be returned in a standardized format, regardless of how it is actually stored (for example, it may be stored as individual integers). Again, this isn't always the case, but often is.  When you set the data, for most cases the user shouldn't be able to just change the raw data.  Rather, it should perform logic on the

13. Determine the effect upon object references and primitive values when they are passed  into methods that change the values -- Create a method 3 parameters, one parameter passed by value, one passed by reference and one with the keyword final.  Explain each and what the effects in side the method that changes each one. Not sure if there's need for actual code here:  Java in a way uses hybrid pass by reference.  If you simply assign to an object, such as String, or java number objects (Integer, Double, etc.), and cannot change a value within the object (such as Person.setName("Jason")), it will not change the object outside of the function/method.  Primitives will also never change within a method.  If the final keyword has been used, you cannot even attempt to change it, because java will give you an error.

14. Write code to show how access modifiers work: private, protected, and public, talk about why you would use each of these. Private: Only the class can access the resource.  Protected: The Class, the same package, and any subclasses can access the resource. Public: Anything can access the resource.  Also: Package local/private (Default): Anything class within the package can access the resource, but not necessarily subclasses (they have to be in the same package).
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
