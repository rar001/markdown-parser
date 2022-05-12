import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {

    String content, content2, content3, content4;
    Path testfile, testfile2, testfile3, testfile4;

    @Before
    public void setUp() throws IOException {
        testfile = Path.of("/Users/anthonyramirez/Documents/SPRING22/CSE15L/markdown-parser/test-file.md");
        testfile2 = Path.of("/Users/anthonyramirez/Documents/SPRING22/CSE15L/markdown-parser/test1.md");
        testfile3 = Path.of("/Users/anthonyramirez/Documents/SPRING22/CSE15L/markdown-parser/test2.md");
        testfile4 = Path.of("/Users/anthonyramirez/Documents/SPRING22/CSE15L/markdown-parser/test3.md");
        content = Files.readString(testfile);
        content2 = Files.readString(testfile2);
        content3 = Files.readString(testfile3);
        content4 = Files.readString(testfile4);

        
    }

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

