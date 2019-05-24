package 字符流.FileReader;

import java.io.FileReader;
import java.io.IOException;

/*
 *@author 王炳烈
 *2019/5/19  15:51
 */
//读取某个文件测试
public class FileReaderTest {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("C:\\Users\\xqq\\Desktop\\Demo.txt");
            char[] buf = new char[1024];
            int num = 0;
            while ((num = fr.read(buf)) != -1){
                System.out.println(new String(buf, 0, num));
            }
        }catch (IOException e){
            System.out.print(e.toString());
        }finally{
            if (fr != null)
                try {
                    fr.close();
                }catch (IOException e){
                    System.out.println(e.toString());
                }
        }
    }
}
