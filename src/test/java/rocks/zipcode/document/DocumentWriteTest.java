package rocks.zipcode.document;

import org.junit.Assert;
import org.junit.Test;
import rocks.zipcode.Document;

import java.io.IOException;

/**
 * @author leon on 16/11/2018.
 */
public class DocumentWriteTest {

    @Test
    public void writeAlphaValuesTest() throws IOException {
        // given
        String fileName = "target/file.txt";
        String expected = "The quick brown fox";
        Document documentWriter = new Document(fileName);

        // when
        documentWriter.write(expected);
        String actual = documentWriter.read();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void writeSpecialCharactersTest() throws IOException {
        // given
        String fileName = "target/file.txt";
        String expected = "()";
        Document documentWriter = new Document(fileName);

        // when
        documentWriter.write(expected);
        String actual = documentWriter.read();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void writeNumericValuesTest() throws IOException {
        // given
        String fileName = "target/file.txt";
        String expected = "123";
        Document documentWriter = new Document(fileName);

        // when
        documentWriter.write(expected);
        String actual = documentWriter.read();

        // then
        Assert.assertEquals(expected, actual);
    }
}
