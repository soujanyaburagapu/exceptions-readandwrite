package rocks.zipcode;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author leon on 18/11/2018.
 */
public class SpecialCharDocument extends Document
{
    public SpecialCharDocument(String fileName) throws IOException
    {
        super(fileName);
    }

    @Override
    public void write(String contentToBeWritten) throws IllegalArgumentException
    {
        if (this.isSpecialCharacters(contentToBeWritten) == false)
        {
            throw new IllegalArgumentException("Illegal");
        }
        else
            super.write(contentToBeWritten);
    }

    private Boolean isSpecialCharacters(String s)
    {
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(s);
        boolean b = m.find();
        return b;
    }
}
