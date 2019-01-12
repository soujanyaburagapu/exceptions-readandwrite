package rocks.zipcode;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author leon on 16/11/2018.
 */
public class Document implements DocumentInterface {

    private final FileWriter fileWriter;
    private final File file;

    public Document(String fileName) throws IOException {
        this(new File(fileName));
    }

    public Document(File file) throws IOException {
        this.file = file;
        this.fileWriter = new FileWriter(file);
    }

    @Override
    public void write(String contentToBeWritten) {
        try {
            fileWriter.write(contentToBeWritten);
            fileWriter.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

    @Override
    public void write(Integer lineNumber, String valueToBeWritten)
    {
        try {
            List<String> list = toList();
            list.set(lineNumber, valueToBeWritten);
            String s = String.join("\n", list);
            Files.write(Paths.get(file.getAbsolutePath()), s.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String read(Integer lineNumber)
    {
        String line = null;
        try {
            line = Files.readAllLines(Paths.get(String.valueOf(file))).get(lineNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }

    @Override
    public String read()
    {
        try
        {
            //System.out.println(Paths.get(file.getName()));
            return new String(Files.readAllBytes(Paths.get(file.getPath())));
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void replaceAll(String stringToReplace, String replacementString)
    {
      Path p = Paths.get(file.getAbsolutePath());
        String fileContent;
        try {
            fileContent = new String(Files.readAllBytes(p));
            fileContent = fileContent.replaceAll(stringToReplace, replacementString);
            Files.write(p, fileContent.getBytes());
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void overWrite(String content)
    {
        try {
            FileWriter fileOverWriter = new FileWriter(file, false);
            BufferedWriter b = new BufferedWriter(fileOverWriter);
            b.write(content);
            b.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> toList()
    {
        Scanner s = null;
        try {
            s = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();
        return list;
    }

    @Override
    public File getFile() {
        return this.file;
    }

    @Override
    public String toString() {
        return file.toString()+ "{"+ this.read()+ "}";
    }
}
