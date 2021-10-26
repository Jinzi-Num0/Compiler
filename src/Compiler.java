import View.FileIn.GetSym;

import java.io.*;

public class Compiler {
    public static void main(String[] args) throws IOException {
        GetSym getSym = new GetSym();
        File testfile = new File("src/testfiles/A/testfile4.txt");
        File file = new File("testfile.txt");
        getSym.GetSymByFile(testfile);
    }
}
