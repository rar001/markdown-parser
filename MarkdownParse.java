//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            if (markdown.contains("[")) {
                int openBracket = markdown.indexOf("[", currentIndex);
                int closeBracket = markdown.indexOf("]", openBracket);
                int openParen = markdown.indexOf("(", closeBracket);
                int closeParen = markdown.indexOf(")", openParen);
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;

                if (markdown.charAt(openBracket-1) == '!') {
                    toReturn.remove(toReturn.size()-1);
                }

                if (markdown.indexOf("]", currentIndex) == -1) {
                    break;
                }
            }

            else {
                
                return toReturn;
            }
        }

        /*for (int i = 0; i < toReturn.size(); i++) {
            if (toReturn.get(i).contains(".") == false) {
                toReturn.remove(i);
            }
        }*/

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
	if (args.length == 0) {
		System.out.println("No!");
	}
	else {
		Path fileName = Path.of(args[0]);
		String content = Files.readString(fileName);
		ArrayList<String> links = getLinks(content);
		System.out.println(links);
	}
    }
}
