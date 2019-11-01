package test

import main.Operation
import main.execute
import org.junit.Test
import kotlin.test.assertEquals

class scratchpadTest {

    @Test
    fun `should do Operation correctly`() {

        assertEquals(execute(5, Operation.Add(3)), 8)
        assertEquals(execute(5, Operation.Substract(3)), 2)
        assertEquals(execute(5, Operation.Multiply(3)), 15)
        assertEquals(execute(15, Operation.Divide(3)), 5)

        val div3 = Operation.Divide(3) //keeps state
        assertEquals(execute(15, div3), 5)

        assertEquals(execute(15, Operation.Increment), 16)
        assertEquals(execute(15, Operation.Decrement), 14)

        val inc = Operation.Increment //does not keep state
        assertEquals(execute(10, inc), 11)
    }


}