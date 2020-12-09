public class Matcher {

	//Bad Smell: Comments
	//Refactoring Technique: Extract Method
	//also constructor removed bcs Java gives you a default invisible empty constructor when you don't redefine it

	public boolean match(int[] expected, int[] actual, int clipLimit, int delta) {

		clipLargeValues(actual,clipLimit);

		if(checkLengthDifferences(actual.length,expected.length)){
			return false;
		}
		return checkEntries(expected,actual,delta);

	}

	public void clipLargeValues(int[] actual, int clipLimit){
		for (int i = 0; i < actual.length; i++) {
			if (actual[i] > clipLimit) {
				actual[i] = clipLimit;
			}
		}
	}

	public boolean checkEntries(int[] expected,int[] actual ,int delta){
		for (int i = 0; i < actual.length; i++)
			if (Math.abs(expected[i] - actual[i]) > delta)
				return false;

		return true;

	}

	public boolean checkLengthDifferences(int actual, int expected){
			return actual != expected;
	}

}