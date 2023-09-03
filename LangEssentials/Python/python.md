## Global, protected and private attributes ##

`Global` variables are public variables that are defined in the global scope. To use the variable in the global scope inside a function, we use the global keyword.
`Protected` attributes are attributes defined with an underscore prefixed to their identifier eg. _sara. They can still be accessed and modified from outside the class they are defined in but a responsible developer should refrain from doing so.
`Private` attributes are attributes with double underscore prefixed to their identifier eg. __ansh. **They cannot be accessed or modified from the outside directly and will result in an AttributeError if such an attempt is made**.



16. What is slicing in Python?
    As the name suggests, ‘slicing’ is taking parts of.
    Syntax for slicing is [start : stop : step]
    start is the starting index from where to slice a list or tuple
    stop is the ending index or where to sop.
    step is the number of steps to jump.
    Default value for start is 0, stop is number of items, step is 1.
    Slicing can be done on strings, arrays, lists, and tuples.
    ```
    numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    print(numbers[1 : : 2])  #output : [2, 4, 6, 8, 10]
    ```


### What is the difference between Python Arrays and lists?
Arrays in python can only contain elements of same data types i.e., data type of array should be homogeneous. It is a thin wrapper around C language arrays and consumes far less memory than lists.
Lists in python can contain elements of different data types i.e., data type of lists can be heterogeneous. It has the disadvantage of consuming large memory.
```python
import array
a = array.array('i', [1, 2, 3])
for i in a:
print(i, end=' ')    #OUTPUT: 1 2 3
a = array.array('i', [1, 2, 'string'])    #OUTPUT: TypeError: an integer is required (got type str)
a = [1, 2, 'string']
for i in a:
print(i, end=' ')    #OUTPUT: 1 2 string
```

## Memory management in python (Read in detail)
Memory management in Python is handled by the Python Memory Manager. The memory allocated by the manager is in form of a private heap space dedicated to Python. All Python objects are stored in this heap and being private, it is inaccessible to the programmer. Though, python does provide some core API functions to work upon the private heap space.
Additionally, Python has an in-built garbage collection to recycle the unused memory for the private heap space.

## What are decorators in Python 

What are decorators in Python?
Decorators in Python are essentially functions that add functionality to an existing function in Python without changing the structure of the function itself. They are represented the @decorator_name in Python and are called in a bottom-up fashion. For example:
```python
# decorator function to convert to lowercase
def lowercase_decorator(function):
def wrapper():
func = function()
string_lowercase = func.lower()
return string_lowercase
return wrapper
# decorator function to split words
def splitter_decorator(function):
def wrapper():
func = function()
string_split = func.split()
return string_split
return wrapper
@splitter_decorator # this is executed next
@lowercase_decorator # this is executed first
def hello():
return 'Hello World'
hello()   # output => [ 'hello' , 'world' ]
```
The beauty of the decorators lies in the fact that besides adding functionality to the output of the method, they can even accept arguments for functions and can further modify those arguments before passing it to the function itself. The inner nested function, i.e. 'wrapper' function, plays a significant role here. It is implemented to enforce encapsulation and thus, keep itself hidden from the global scope.

```python
# decorator function to capitalize names
def names_decorator(function):
def wrapper(arg1, arg2):
arg1 = arg1.capitalize()
arg2 = arg2.capitalize()
string_hello = function(arg1, arg2)
return string_hello
return wrapper
@names_decorator
def say_hello(name1, name2):
return 'Hello ' + name1 + '! Hello ' + name2 + '!'
say_hello('sara', 'ansh')   # output => 'Hello Sara! Hello Ansh!'
```


### What are Dict and List comprehensions?
Python comprehensions, like decorators, are syntactic sugar constructs that help build altered and filtered lists, dictionaries, or sets from a given list, dictionary, or set. Using comprehensions saves a lot of time and code that might be considerably more verbose (containing more lines of code). Let's check out some examples, where comprehensions can be truly beneficial:
```
Performing mathematical operations on the entire list
my_list = [2, 3, 5, 7, 11]
squared_list = [x**2 for x in my_list]    # list comprehension
# output => [4 , 9 , 25 , 49 , 121]
squared_dict = {x:x**2 for x in my_list}    # dict comprehension
# output => {11: 121, 2: 4 , 3: 9 , 5: 25 , 7: 49}
Performing conditional filtering operations on the entire list
my_list = [2, 3, 5, 7, 11]
squared_list = [x**2 for x in my_list if x%2 != 0]    # list comprehension
# output => [9 , 25 , 49 , 121]
squared_dict = {x:x**2 for x in my_list if x%2 != 0}    # dict comprehension
# output => {11: 121, 3: 9 , 5: 25 , 7: 49}
Combining multiple lists into one
Comprehensions allow for multiple iterators and hence, can be used to combine multiple lists into one.

a = [1, 2, 3]
b = [7, 8, 9]
[(x + y) for (x,y) in zip(a,b)]  # parallel iterators
# output => [8, 10, 12]
[(x,y) for x in a for y in b]    # nested iterators
# output => [(1, 7), (1, 8), (1, 9), (2, 7), (2, 8), (2, 9), (3, 7), (3, 8), (3, 9)]
Flattening a multi-dimensional list
A similar approach of nested iterators (as above) can be applied to flatten a multi-dimensional list or work upon its inner elements.

my_list = [[10,20,30],[40,50,60],[70,80,90]]
flattened = [x for temp in my_list for x in temp]
# output => [10, 20, 30, 40, 50, 60, 70, 80, 90]
```
Note: List comprehensions have the same effect as the map method in other languages. They follow the mathematical set builder notation rather than map and filter functions in Python.

## Lambda
Lambda is an anonymous function in Python, that can accept any number of arguments, but can only have a single expression. It is generally used in situations requiring an anonymous function for a short time period. Lambda functions can be used in either of the two ways:
```python
#Assigning lambda functions to a variable:
mul = lambda a, b : a * b
print(mul(2, 5))    # output => 10
#Wrapping lambda functions inside another function:
def myWrapper(n):
return lambda a : a * n
mulFive = myWrapper(5)
print(mulFive(2))    # output => 10
```

## Copy
Deep and Shallow
```python
from copy import copy, deepcopy
list_1 = [1, 2, [3, 5], 4]
## shallow copy
list_2 = copy(list_1) 
list_2[3] = 7
list_2[2].append(6)
list_2    # output => [1, 2, [3, 5, 6], 7]
list_1    # output => [1, 2, [3, 5, 6], 4]
## deep copy
list_3 = deepcopy(list_1)
list_3[3] = 8
list_3[2].append(7)
list_3    # output => [1, 2, [3, 5, 6, 7], 8]
list_1    # output => [1, 2, [3, 5, 6], 4]

```

## What is the difference between xrange and range in Python? 
    
xrange() and range() are quite similar in terms of functionality. They both generate a sequence of integers, with the only difference that range() returns a Python list, whereas, xrange() returns an xrange object.

So how does that make a difference? It sure does, because unlike range(), xrange() doesn't generate a static list, it creates the value on the go. This technique is commonly used with an object-type generator and has been termed as "yielding".

Yielding is crucial in applications where memory is a constraint. Creating a static list as in range() can lead to a Memory Error in such conditions, while, xrange() can handle it optimally by using just enough memory for the generator (significantly less in comparison).

```python
for i in xrange(10):    # numbers from o to 9
   print i       # output => 0 1 2 3 4 5 6 7 8 9
for i in xrange(1,10):    # numbers from 1 to 9
   print i       # output => 1 2 3 4 5 6 7 8 9
for i in xrange(1, 10, 2):    # skip by two for next
   print i       # output => 1 3 5 7 9

```

##What is pickling and unpickling?
Python library offers a feature - serialization out of the box. Serializing an object refers to transforming it into a format that can be stored, so as to be able to deserialize it, later on, to obtain the original object. Here, the pickle module comes into play.

Pickling:

Pickling is the name of the serialization process in Python. Any object in Python can be serialized into a byte stream and dumped as a file in the memory. The process of pickling is compact but pickle objects can be compressed further. Moreover, pickle keeps track of the objects it has serialized and the serialization is portable across versions.
The function used for the above process is pickle.dump().
Unpickling:

Unpickling is the complete inverse of pickling. It deserializes the byte stream to recreate the objects stored in the file and loads the object to memory.
The function used for the above process is pickle.load().
Note: Python has another, more primitive, serialization module called marshall, which exists primarily to support .pyc files in Python and

## Generator

Generators are functions that return an iterable collection of items, one at a time, in a set manner. Generators, in general, are used to create iterators with a different approach. They employ the use of yield keyword rather than return to return a generator object.
Let's try and build a generator for fibonacci numbers 