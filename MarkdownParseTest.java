import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {

    String content, content2, content3, content4, content5, content6, content7;
    Path testfile, testfile2, testfile3, testfile4, snippet1, snippet2, snippet3;

    @Before
    public void setUp() throws IOException {
        testfile = Path.of("/test-file.md");
        testfile2 = Path.of("/test1.md");
        testfile3 = Path.of("/test2.md");
        testfile4 = Path.of("/test3.md");
        content = Files.readString(testfile);
        content2 = Files.readString(testfile2);
        content3 = Files.readString(testfile3);
        content4 = Files.readString(testfile4);

        /*snippet1 = Path.of("/Users/anthonyramirez/Documents/SPRING22/CSE15L/markdown-parser/lab4/snippet1.md");
        snippet2 = Path.of("/Users/anthonyramirez/Documents/SPRING22/CSE15L/markdown-parser/lab4/snippet2.md");
        snippet3 = Path.of("/Users/anthonyramirez/Documents/SPRING22/CSE15L/markdown-parser/lab4/snippet3.md");
        content5 = Files.readString(snippet1);
        content6 = Files.readString(snippet2);
        content7 = Files.readString(snippet3);*/
    }

    /*@Test
    public void testSnippet() {
        assertEquals(List.of("https://cse.ucsd.edu/"), MarkdownParse.getLinks(content7)); 
    }*/


//javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java && java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest



    @Test
    public void addition() throws IOException {
        assertEquals(2, 1 + 1); //works
    }

    @Test
    public void testfile() {
        assertEquals(List.of("https://something.com", "some-thing.html"), MarkdownParse.getLinks(content));
        assertEquals(List.of("some-thing.html"), MarkdownParse.getLinks(content2));
        assertEquals(List.of("https://youtube.com"), MarkdownParse.getLinks(content3));
        assertEquals(List.of(), MarkdownParse.getLinks(content4));
    }
}
