package rocks.zipcode.specialdocument;

import org.junit.Assert;
import org.junit.Test;
import rocks.zipcode.Document;
import rocks.zipcode.SpecialCharDocument;

import java.io.IOException;

/**
 * @author leon on 18/11/2018.
 */
public class SpecialCharDocumentTest {

    @Test(expected = IllegalArgumentException.class)
    public void writeNumericValuesToFile() throws IOException {
        // given
        String fileName = "target/file.txt";
        String contentToBeWritten = "123";
        Document documentWriter = new SpecialCharDocument(fileName);

        // when
        documentWriter.write(contentToBeWritten);
    }

    @Test
    public void writeSpecialCharacter1() throws IOException {
        // given
        String fileName = "target/file.txt";
        String contentToBeWritten = "()";
        Document documentWriter = new SpecialCharDocument(fileName);

        // when
        documentWriter.write(contentToBeWritten);
    }


    @Test
    public void writeSpecialCharacter2() throws IOException {
        // given
        String fileName = "target/file.txt";
        String contentToBeWritten = "()_*";
        Document documentWriter = new SpecialCharDocument(fileName);

        // when
        documentWriter.write(contentToBeWritten);
    }


    @Test(expected = IllegalArgumentException.class)
    public void writeAlphaValuesTest() throws IOException {
        // given
        String fileName = "target/file.txt";
        String expected = "The quick brown foxy";
        Document documentWriter = new SpecialCharDocument(fileName);

        // when
        documentWriter.write(expected);
        String actual = documentWriter.read();

        // then
        Assert.assertEquals(expected, actual);
    }
}
