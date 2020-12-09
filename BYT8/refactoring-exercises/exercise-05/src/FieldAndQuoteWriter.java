public class FieldAndQuoteWriter {

    private final char quote = '\"';

    public String writeFieldandQuoted(String field) {

        if (field.indexOf(',') != -1 || field.indexOf('\"') != -1) {

            StringBuilder builder = new StringBuilder();
            builder.append(quote);

            for (int i = 0; i < field.length(); i++) {
                char c = field.charAt(i);
                if (c == quote) {
                    builder.append(quote).append(quote);
                } else {
                    builder.append(c);
                }
            }
            builder.append(quote);
            return builder.toString();
        }

        else {
            return field;
        }
    }
}
