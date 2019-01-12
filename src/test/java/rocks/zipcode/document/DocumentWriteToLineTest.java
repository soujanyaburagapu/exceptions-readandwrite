package rocks.zipcode.document;

import org.junit.Assert;
import org.junit.Test;
import rocks.zipcode.Document;

import java.io.IOException;

/**
 * @author leon on 16/11/2018.
 */
public class DocumentWriteToLineTest {
    @Test
    public void writeToLineTest1() throws IOException {
        // given
        String fileName = "target/file.txt";
        String contentToBeWritten = "The\nquick\nbrown\nfox";
        String replacement = "quicker";
        String expected = contentToBeWritten.replaceAll("quick", replacement);

        Document documentWriter = new Document(fileName);
        documentWriter.write(contentToBeWritten);

        // when
        documentWriter.write(1, replacement);

        // then
        Assert.assertEquals(expected, documentWriter.read());
    }

    @Test
    public void writeToLineTest2() throws IOException {
        // given
        String fileName = "target/file.txt";
        String contentToBeWritten = "The\nquick\nbrown\nfox";
        String replacement = "quickest";
        String expected = contentToBeWritten.replaceAll("The", replacement);

        Document documentWriter = new Document(fileName);
        documentWriter.write(contentToBeWritten);

        // when
        documentWriter.write(0, replacement);

        // then
        Assert.assertEquals(expected, documentWriter.read());
    }
}