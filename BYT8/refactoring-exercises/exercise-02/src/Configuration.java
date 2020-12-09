import java.util.*;

public class Configuration {
	public int interval;

	public int duration;

	public int departure;


	//Bad Smell: long method and code duplication
	//Refactoring Techniques : Extract Method
	//code splitted into smaller parts so load method is shorter than before

	public void load(Properties props) throws ConfigurationException {
		interval = ExtractInterval(props);
		duration = ExtractDuration(props);
		departure = ExtractDeparture(props);
	}

	private int ExtractInterval(Properties props) throws ConfigurationException {
		return getValue(props, "interval");
	}

	private int ExtractDuration(Properties props) throws ConfigurationException {
		int duration = getValue(props, "duration");
		checkReminder(duration,"duration");
		return duration;
	}

	private int ExtractDeparture(Properties props) throws ConfigurationException {
		int departure = getValue(props, "departure");
		checkReminder(departure,"departure");
		return departure;
	}

	public void checkReminder(int value, String property) throws ConfigurationException {
		if ((value % interval) != 0) {
			throw new ConfigurationException(property+" % interval");
		}
	}

	private int getValue(Properties props, String property) throws ConfigurationException {
		String valueString;
		int value;

		valueString = props.getProperty(property);
		if (valueString == null) {
			throw new ConfigurationException(property + "is Null");
		}
		value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new ConfigurationException( property + " > 0");
		}
		return value;
	}

}
