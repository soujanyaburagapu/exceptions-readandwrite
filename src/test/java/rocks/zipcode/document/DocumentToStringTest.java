package rocks.zipcode.document;

import org.junit.Assert;
import org.junit.Test;
import rocks.zipcode.Document;

import java.io.IOException;

/**
 * @author leon on 16/11/2018.
 */
public class DocumentToStringTest {
    @Test
    public void toStringTest1() throws IOException {
        // given
        String fileName = "target/file.txt";
        String contentToBeWritten = "The quick brown fox";
        Document documentWriter = new Document(fileName);
        String expected = new StringBuilder(fileName)
                .append("{")
                .append(contentToBeWritten)
                .append("}")
                .toString();

        // when
        documentWriter.write(contentToBeWritten);
        String actual = documentWriter.toString();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest2() throws IOException {
        // given
        String fileName = "target/file.txt";
        String contentToBeWritten = "The quicker browner fox";
        Document documentWriter = new Document(fileName);
        String expected = new StringBuilder(fileName)
                .append("{")
                .append(contentToBeWritten)
                .append("}")
                .toString();

        // when
        documentWriter.write(contentToBeWritten);
        String actual = documentWriter.toString();

        // then
        Assert.assertEquals(expected, actual);
    }
}
