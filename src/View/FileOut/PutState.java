package View.FileOut;

import java.io.FileWriter;
import java.io.IOException;
public class PutState {
    public void PutAns(FileWriter fw,int labNum,String CatCode,String word) throws IOException{
        // TODO Auto-generated method stub
        fw.append(CatCode);
        fw.append(" ");
        fw.append(word);
        fw.append("\n");
        //必须要加fw.flush()，代表刷新，不加这个语句不能写入到文件中
        fw.flush();
    }
}
