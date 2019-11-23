package calculator.calculations;

import java.util.List;
import java.util.stream.IntStream;

import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;

/**
 * MVC Model does calculations and returns value to Controller.
 * 
 * @author Jakub Ficek
 * @version 1.0
 */
public class Model {
	/**
	 * Calculates value from expression using jshell API.
	 * 
	 * @exception IllegalArgumentException thrown when wrong input
	 * @param expression input from Controller
	 * @return value output to Controller after calculations
	 */
	public String calculate(String expression) {
		JShell jshell = JShell.create();
		try (jshell) {
			List<SnippetEvent> events = jshell.eval(expression);
			for (SnippetEvent e : events) {
				if (e.causeSnippet() == null) {
					switch (e.status()) {
					case VALID:
						if (e.value() != null) {
							return e.value();
						}
						break;
					default:
						throw new IllegalArgumentException("Illegal expression");
					}
				}
			}
		}
		return "";
	}

	/**
	 * Calculates factorial of integer.
	 * 
	 * @param value factorial argument
	 * @return value factorial of value
	 */
	public String factorial(String value) throws IllegalArgumentException {
		int number = Integer.parseInt(calculate(value));
		if (number < 0)
			throw new IllegalArgumentException("negative argument");
		return String.valueOf(IntStream.rangeClosed(2, number).reduce(1, (x, y) -> Math.multiplyExact(x, y)));
	}

	/**
	 * Calculates square root.
	 * 
	 * @param value square root argument
	 * @return value square root of value
	 */
	public String squareRoot(String value) {
		return String.valueOf(Math.sqrt(Double.parseDouble(calculate(value))));
	}

}
