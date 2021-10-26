package View.FileIn;

import Services.BaseCatCodeServ;
import Services.Impl.CatCodeServImpl;
import View.FileOut.PutState;

import java.io.*;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

public class GetSym {
    BaseCatCodeServ CatCodeSer = new CatCodeServImpl();
    PutState putState = new PutState();
    Boolean lab2 = true;

    /**
     * 从原始文件中获取 程序内容 并存储在
     * @param file
     * @throws IOException
     */
    public void GetSymByFile(File file) throws IOException {
        //定义输出的文件
        FileWriter fileWriter = new FileWriter("output.txt");
        Reader reader = null;
        //每次读取到的字符
        char ch ;
        //将字母 或者 数字 拼接成的字符串
        StringBuffer str = new StringBuffer("");
        //判断是哪种类别码
        String CatCode;
        //第一个字符，用于判断是否 = -1 （即文本结束）
        int first;

        try {

            System.out.println("以字符为单位读取文件内容，一次读一个字符：");
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file));

            //只要有文字 就继续读
            while ((first = reader.read()) != -1) {
                //将第一个字符读进来
                ch = (char) first;


                // 对于windows下，跳过 \r:换行 \n：换行   \t：tab
                while (ch == '\r' || ch == '\t' || ch == '\n') {
                    ch = (char) reader.read();
                }

                //判断是否是数字 或 单词, 如果是则 拼接成字符串
                while(isDigit(ch) || isLetter(ch)){
                    str.append(ch);
                    ch = (char) reader.read();
                }

                if(str.length() > 0) {
                    CatCode = CatCodeSer.isCatCodeServ(str);
                    System.out.println(str);
                    if (CatCode.equals("IDENFR")) {
                        if(lab2)    putState.PutAns(CatCode,fileWriter);
                        System.out.println(CatCode);
                    }else {
                        if(lab2)    putState.PutAns(CatCode,fileWriter);
                        System.out.println(CatCode);
                    }

                    //清空 str 读取下一个
                    str.delete(0,str.length());
                }

                CatCode = CatCodeSer.isCatCodeServ(new StringBuffer().append(ch));
                System.out.println(ch);
                System.out.println(CatCode);
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            fileWriter.close();
        }
    }
}
