package rocks.zipcode.document;

import org.junit.Assert;
import org.junit.Test;
import rocks.zipcode.Document;

import java.io.IOException;

/**
 * @author leon on 16/11/2018.
 */
public class DocumentReadLineTest {
    @Test
    public void testReadFirstLine() throws IOException {
        // given
        String expected = "The";
        String fileName = "target/file.txt";
        Document documentWriter = new Document(fileName);
        String contentToBeWritten = "The\nquick\nbrown\nfox";
        documentWriter.write(contentToBeWritten);

        // when
        String actual = documentWriter.read(0);

        // then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testReadSecondLine() throws IOException {
        // given
        String expected = "quick";
        String fileName = "target/file.txt";
        Document documentWriter = new Document(fileName);
        String contentToBeWritten = "The\nquick\nbrown\nfox";
        documentWriter.write(contentToBeWritten);

        // when
        String actual = documentWriter.read(1);

        // then
        Assert.assertEquals(expected, actual);
    }
}

