package rocks.zipcode.document;

import org.junit.Assert;
import org.junit.Test;
import rocks.zipcode.Document;

import java.io.IOException;

/**
 * @author leon on 16/11/2018.
 */
public class DocumentReadTest {
    @Test
    public void testRead1() throws IOException {
        // given
        String fileName = "target/file.txt";
        Document documentWriter = new Document(fileName);
        String expected = "The\nquick\nbrown\nfox";
        documentWriter.write(expected);

        // when
        String actual = documentWriter.read();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRead2() throws IOException {
        // given
        String fileName = "target/file.txt";
        Document documentWriter = new Document(fileName);
        String expected = "The\nquicker\nbrown\nfox";
        documentWriter.write(expected);

        // when
        String actual = documentWriter.read();

        // then
        Assert.assertEquals(expected, actual);
    }

}