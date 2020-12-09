public class LineWriter {

    private final char comma = ',';
    private final char newline = '\n';

    FieldAndQuoteWriter fnqw;

    public LineWriter(FieldAndQuoteWriter fnqw){
        this.fnqw=fnqw;
    }

    public String writeLine(String[] fields) {
        StringBuilder builder = new StringBuilder();

        if (fields.length == 0)
            builder.append(newline);
        else {
            builder.append(fnqw.writeFieldandQuoted(fields[0]));

            for (int i = 1; i < fields.length; i++) {
                builder.append(comma);
                builder.append(fnqw.writeFieldandQuoted(fields[i]));
            }
            builder.append(newline);
        }

        return builder.toString();
    }
}
