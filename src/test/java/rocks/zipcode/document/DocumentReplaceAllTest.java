package rocks.zipcode.document;

import org.junit.Assert;
import org.junit.Test;
import rocks.zipcode.Document;

import java.io.IOException;

/**
 * @author leon on 16/11/2018.
 */
public class DocumentReplaceAllTest {
    @Test
    public void testReplace_e_withUnderscore() throws IOException {
        // given
        String fileName = "target/file.txt";
        Document documentWriter = new Document(fileName);
        String contentToBeWritten = "Lorem ipsum dolor sit amet,\nconsectetur adipiscing elit,\nsed do eiusmod tempor incididunt\nut labore et dolore\nmagna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris\nnisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate\nvelit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat\nnon proident, sunt in culpa qui officia deserunt mollit anim id est laborum";
        String valueToReplace = "e";
        String replacementValue = "_";
        String expected = contentToBeWritten.replaceAll(valueToReplace, replacementValue);
        documentWriter.write(contentToBeWritten);

        // when
        documentWriter.replaceAll(valueToReplace, replacementValue);

        // then
        String actual = documentWriter.read();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReplace_newLine_withEmptyString() throws IOException {
        // given
        String fileName = "target/file.txt";
        Document documentWriter = new Document(fileName);
        String contentToBeWritten = "Lorem ipsum dolor sit amet,\nconsectetur adipiscing elit,\nsed do eiusmod tempor incididunt\nut labore et dolore\nmagna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris\nnisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate\nvelit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat\nnon proident, sunt in culpa qui officia deserunt mollit anim id est laborum";
        String valueToReplace = "\n";
        String replacementValue = "";
        String expected = contentToBeWritten.replaceAll(valueToReplace, replacementValue);
        documentWriter.write(contentToBeWritten);

        // when
        documentWriter.replaceAll(valueToReplace, replacementValue);

        // then
        String actual = documentWriter.read();
        Assert.assertEquals(expected, actual);
    }
}
