public class CsvWriter {

	//Bad Smell: Divergent Change
	//Refactoring Technique : Extract Class
	//also instead of printing to console every time ,I've used StringBuilder and append characters and string
	//empty constructor deleted

	private LineWriter lineWriter;

	public CsvWriter() {
		lineWriter = new LineWriter(new FieldAndQuoteWriter());
	}

	public void write(String[][] lines) {
		for (int i = 0; i < lines.length; i++)
			System.out.print(lineWriter.writeLine(lines[i]));
	}




}