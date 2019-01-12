package rocks.zipcode.alphadocument;

import org.junit.Assert;
import org.junit.Test;
import rocks.zipcode.AlphaCharDocument;
import rocks.zipcode.Document;

import java.io.IOException;

/**
 * @author leon on 16/11/2018.
 */
public class AlphaDocumentWriteTest {

    @Test(expected = IllegalArgumentException.class)
    public void writeNumericValuesToFile() throws IOException {
        // given
        String fileName = "target/file.txt";
        String contentToBeWritten = "123";
        Document documentWriter = new AlphaCharDocument(fileName);

        // when
        documentWriter.write(contentToBeWritten);
    }

    @Test(expected = IllegalArgumentException.class)
    public void writeSpecialCharacter() throws IOException {
        // given
        String fileName = "target/file.txt";
        String contentToBeWritten = "()";
        Document documentWriter = new AlphaCharDocument(fileName);

        // when
        documentWriter.write(contentToBeWritten);
    }


    @Test
    public void writeAlphaValuesTest() throws IOException {
        // given
        String fileName = "target/file.txt";
        String expected = "The quick brown foxy";
        Document documentWriter = new AlphaCharDocument(fileName);

        // when
        documentWriter.write(expected);
        String actual = documentWriter.read();

        // then
        Assert.assertEquals(expected, actual);
    }
}
