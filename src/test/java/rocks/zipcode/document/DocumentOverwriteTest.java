package rocks.zipcode.document;

import org.junit.Assert;
import org.junit.Test;
import rocks.zipcode.Document;

import java.io.IOException;

/**
 * @author leon on 16/11/2018.
 */
public class DocumentOverwriteTest {
    @Test
    public void writeTest1() throws IOException {
        // given
        String fileName = "target/file.txt";
        String contentToBeOverwritten = "The quick brown fox";
        String expected = "The quick browner fox";
        Document documentWriter = new Document(fileName);
        documentWriter.write(contentToBeOverwritten);

        // when
        documentWriter.overWrite(expected);
        String actual = documentWriter.read();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void writeTest2() throws IOException {
        // given
        String fileName = "target/file.txt";
        String contentToBeOverwritten = "The quick brown fox";
        String expected = "The quick brownest fox";
        Document documentWriter = new Document(fileName);
        documentWriter.write(contentToBeOverwritten);

        // when
        documentWriter.overWrite(expected);
        String actual = documentWriter.read();

        // then
        Assert.assertEquals(expected, actual);
    }
}