#Scala #
Scala was born from the mind of Martin Odersky, a man who had helped introduce generics into the Java programming language.

### Case class ###
1. First, it adds a factory method with the name of the class. This means you can write say, Var("x") to construct a Var object instead of the slightly longer new Var("x"):

```
 abstract class Expr
    case class Var(name: String) extends Expr
 
 
scala> val v = Var("x")
```
2. The second syntactic convenience is that all arguments in the parameter list of a case class implicitly get a val prefix, so they are maintained as fields:
