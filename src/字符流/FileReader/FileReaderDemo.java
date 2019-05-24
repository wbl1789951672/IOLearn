package 字符流.FileReader;

import java.io.FileReader;
import java.io.IOException;

/*
 *@author 王炳烈
 *2019/5/19  10:53
 */
//读取文件(读取一个字符)
public class FileReaderDemo {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            //创建一个文件读取流对象，和指定名称的文件相关联
            //要保证该文件已经存在，如果不存在，会发生文件找不到异常
            fr = new FileReader("C:\\Users\\xqq\\Desktop\\Demo.txt");

            //调用读取流对象的read方法（返回值为int）,读到末尾时返回-1
            int ch = 0;
            while ((ch = fr.read()) != -1){
                System.out.println((char) ch);
            }
            /*while (true){
                int ch = fr.read();
                if (ch != -1){
                    System.out.println((char) ch);
                }else{
                    return;
                }
            }*/



        }catch (IOException e){
            System.out.println(e.toString());
        }
        finally {
            try{
                if (fr != null)
                    fr.close();
            }catch (IOException e)
            {
                System.out.println(e.toString());
            }
        }
    }
}
