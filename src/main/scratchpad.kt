package main

class myClass {
    // property (data member)
    private var name: String = "Tutorials.point"

    // member function
    fun printMe() {
        print("You are at the best Learning website Named-" + name)
    }
}

class Outer {
    class Nested {
        fun foo() = " => Welcome to The TutorialsPoint.com"
    }
}


fun main(args: Array<String>) {
    val obj = myClass() // create obj object of myClass class
    obj.printMe()

    val demo = Outer.Nested().foo() // calling nested class method
    print(demo)
}



sealed class Operation {
    class Add(val value: Int) : Operation()
    class Substract(val value: Int) : Operation()
    class Multiply(val value: Int) : Operation()
    class Divide(val value: Int) : Operation()
    object Increment : Operation()
    object Decrement : Operation()
}

fun execute(x: Int, op: Operation) = when (op) {
    is Operation.Add -> x + op.value
    is Operation.Substract -> x - op.value
    is Operation.Multiply -> x * op.value
    is Operation.Divide -> x / op.value
    Operation.Increment -> x + 1 //no need for is as object - not keeping state
    Operation.Decrement -> x - 1
}
