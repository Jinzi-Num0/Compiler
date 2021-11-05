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
    int labNum = 2;

    /**
     * 从原始文件中获取 程序逐个字符 并判断其类别码
     * @param file
     * @throws IOException
     */
    public void GetSymByFile(File file) throws IOException {
        //定义可回退的reader
        FileWriter fw = new FileWriter("output.txt");
        PushbackReader reader = null;

        //将字母 或者 数字 拼接成的字符串
        StringBuffer str = new StringBuffer("");

        //判断是哪种类别码
        String CatCode;

        //每次读取到的字符
        char ch ;
        //进行类别码判断的 第一个字符，用于判断是否 = -1 （即文本结束）
        int first;

        try {

            System.out.println("以字符为单位读取文件内容，一次读一个字符：");
            // 一次读一个字符
            reader = new PushbackReader(new InputStreamReader(new FileInputStream(file)));
            //只要有文字 就继续读
            while (true) {
                //将第一个字符读进来 并准备好下一个字符
                first = reader.read();
                ch = (char) first;

                // 对于windows下，跳过 \r:换行 \n：换行   \t：tab
                while (ch == '\r' || ch == '\t' || ch == '\n') {
                    ch = (char) reader.read();
                }
                if(first == -1) break;
                //判断是否是数字 或 单词, 如果是则 拼接成字符串
                else if(isDigit(ch)){
                    Reader temp = null;
                    while(isDigit(ch)){
                        str.append(ch);
                        ch = (char) reader.read();
                    }
                    reader.unread(ch);

                    //判断是否是 单字符 或 多字母、数字组成 的类别码
                    if(str.length() > 0) {
                        CatCode = CatCodeSer.isCatCodeServ(str);

                        if(lab2)    {putState.PutAns(fw,labNum,CatCode,str.toString());
                        System.out.println(CatCode);
                        System.out.println(str);}
                        //清空 str 读取下一个
                        str.delete(0,str.length());
                    }

                }
                //判断是否是数字 或 单词, 如果是则 拼接成字符串
                else if(isLetter(ch)){
                    while(isLetter(ch)){
                        str.append(ch);
                        ch = (char) reader.read();
                    }
                    reader.unread(ch);

                    //判断是否是 单字符 或 多字母、数字组成 的类别码
                    if(str.length() > 0) {
                        CatCode = CatCodeSer.isCatCodeServ(str);
                        if(lab2)    {
                            putState.PutAns(fw,labNum,CatCode,str.toString());
                            str.delete(0,str.length());
                            System.out.println(CatCode);
                            System.out.println(str);
                        }
                        //清空 str 读取下一个
                        str.delete(0,str.length());
                    }

                }

                //判断是否是 多字符 组成的类别码：
                else if (ch == '&' && reader.read() == '&') {
                    CatCode = "AND";
                    str.append("&&");
                    if(lab2)    {
                        putState.PutAns(fw,labNum,CatCode,str.toString());
                        str.delete(0,str.length());
                        System.out.println(CatCode);
                        System.out.println("&&");}
                    //跳过已经成功判断的字符
                }
                else if (ch == '|' && reader.read() == '|') {
                    CatCode = "OR";
                    str.append("||");
                    if(lab2)    {
                        putState.PutAns(fw,labNum,CatCode,str.toString());
                        str.delete(0,str.length());
                        System.out.println(CatCode);
                        System.out.println("||");
                    }
                    //跳过已经成功判断的字符
                }
                else if(ch == '>' && reader.read() =='='){
                    CatCode = "GEQ";
                    str.append(">=");
                    if(lab2) {
                        putState.PutAns(fw,labNum,CatCode,str.toString());
                        str.delete(0,str.length());
                        System.out.println(CatCode);
                        System.out.println(">=");
                    }
                    //跳过已经成功判断的字符
                }
                else if(ch == '<' && reader.read() =='='){
                    CatCode = "LEQ";
                    str.append("<=");
                    if(lab2){
                        putState.PutAns(fw,labNum,CatCode,str.toString());
                        str.delete(0,str.length());
                        System.out.println(CatCode);
                        System.out.println("<=");
                    }
                    //跳过已经成功判断的字符
                }
                else if(ch == '=' && reader.read() =='='){
                    CatCode = "EQL";
                    str.append("==");
                    if(lab2)    {
                        putState.PutAns(fw,labNum,CatCode,str.toString());
                        str.delete(0,str.length());
                        System.out.println(CatCode);
                        System.out.println("==");
                    }
                    //跳过已经成功判断的字符
                }
                else if(ch == '!' && reader.read() =='='){
                    CatCode = "NEQ";
                    str.append("!=");
                    if(lab2)    {putState.PutAns(fw,labNum,CatCode,str.toString());
                    str.delete(0,str.length());
                    System.out.println(CatCode);
                    System.out.println("!=");}
                    //跳过已经成功判断的字符
                }

                //判断是否是双引号组成的字符串
                else if(ch == '"'){
                    str.append(ch);
                    ch = (char) reader.read();
                    while(ch != '"'){
                        str.append(ch);
                        ch = (char) reader.read();
                    }
                    str.append(ch);

                    CatCode = "STRCON";
                    if(lab2)    putState.PutAns(fw,labNum,CatCode,str.toString());
                    System.out.println(CatCode);
                    System.out.println(str);
                    str.delete(0,str.length());
                }
                else if(ch !=' '){
                    CatCode = CatCodeSer.isCatCodeServ(new StringBuffer().append(ch));
                    if(lab2){
                        System.out.println(new StringBuffer().append(ch).toString());
                        putState.PutAns(fw,labNum,CatCode,new StringBuffer().append(ch).toString());
                    System.out.println(CatCode);
                    System.out.println(ch);}
                }
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        }
    }
}
