import utils.XMLparser;
import utils.FileHandler;

/**
 * @Author Alexander Olsson
 */

public class Main {

    public static void main(String[] args) {

        String fileName = "files/output.txt";

        XMLparser parser = new XMLparser();
        FileHandler handler = new FileHandler();
        String text = parser.parse("files/sma_gentext.xml", 42007);
        handler.writer(fileName, text);
        handler.reader(fileName);


    }
}
