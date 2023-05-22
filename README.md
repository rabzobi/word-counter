# Word Counter
Word counter tech challenge

##  Principles and patterns used:
### Encapsulation
Internal implementation is hidden, there is no direct access to the internal wordCount map.  
### Test Driven Development
Code is 100% cover by junit tests.
### SOLID Principles
The design follows the Single Responsibility Principle (SRP) 
by separating concerns into different methods. 
Each method has a clear and specific responsibility.
###  Optimization
The word counts are stored in a HashMap for efficient lookups and updates.
### Thread safety
HashMap is not a thread-safe implementation of a Map, so the addWord method is synchronized 
to only allow one thread to update it at a time.
### Translator
The Translator class should be replaced with an implementation,
this was beyond the scope of this test.



