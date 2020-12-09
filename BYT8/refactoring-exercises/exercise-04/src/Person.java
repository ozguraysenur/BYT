import java.io.IOException;
import java.io.Writer;

//Bad Smell: Lazy Class
//Refactoring Technique: Inline class
//client classes are not doing enough to pay so I moved their methods to
//person class and delete them
public class Person {
	public String last;

	public String first;

	public String middle;

	public Person(String last, String first, String middle) {
		this.last = last;
		this.first = first;
		this.middle = middle;
	}
	public void printPerson(Writer out) throws IOException {
		out.write(first);
		out.write(" ");
		if (middle != null) {
			out.write(middle);
			out.write(" ");
		}
		out.write(last);
	}
	public String formatPerson() {
		String result = last + ", " + first;
		if (middle != null)
			result += " " +middle;
		return result;
	}
	public void display(Writer out) throws IOException {
		out.write(last);
		out.write(", ");
		out.write(first);
		if (middle != null) {
			out.write(" ");
			out.write(middle);
		}
	}
	public String toString() {
		return last + ", " + first
				+ ((middle == null) ? "" : " " + middle);
	}
}