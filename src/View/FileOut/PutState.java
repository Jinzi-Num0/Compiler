package View.FileOut;

import java.io.FileWriter;
import java.io.IOException;
public class PutState {

    public void PutAns(String ans, FileWriter fw) throws IOException{
        // TODO Auto-generated method stub
        fw.append(ans);
        fw.append("\n");
        //必须要加fw.flush()，代表刷新，不加这个语句不能写入到文件中
        fw.flush();
    }
}
