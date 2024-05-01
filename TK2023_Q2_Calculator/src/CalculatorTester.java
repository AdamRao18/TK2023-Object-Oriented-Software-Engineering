import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTester {

	private Calculator calc = new Calculator();

	@Test
	public void testAddTwoInteger() {
		assertEquals(12, calc.addTwoInteger(10,2));
	}

	@Test
	public void testSubtractTwoInteger() {
		assertEquals(10-2, calc.subtractTwoInteger(10,2));
	}

	@Test
	public void testMultiplyTwoInteger() {
		assertEquals(10*2, calc.multiplyTwoInteger(10,2));
	}

	@Test
	public void testDivideTwoInteger() {
		assertEquals(10/2, calc.divideTwoInteger(10,2));
	}
}