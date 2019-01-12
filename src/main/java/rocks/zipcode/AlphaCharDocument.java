package rocks.zipcode;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author leon on 16/11/2018.
 */
public class AlphaCharDocument extends Document {
    public AlphaCharDocument(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void write(String contentToBeWritten) throws IllegalArgumentException
    {
        if (this.isAlpha(contentToBeWritten) == true)
        {
            throw new IllegalArgumentException("Illegal");
        }
        else
            super.write(contentToBeWritten);
    }

    private Boolean isAlpha(String s)
    {
        Pattern p = Pattern.compile("[^ a-z ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(s);
        boolean b = m.find();
        return b;
    }
}
