package 字符流.FileReader;

import java.io.FileReader;
import java.io.IOException;

/*
 *@author 王炳烈
 *2019/5/19  11:16
 */
//读取文件（通过字符数组）
public class FileReaderDemo2 {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("C:\\Users\\xqq\\Desktop\\Demo.txt");
            //定义一个字符数组，用于存储读到的字符。
            //该read（char[]）返回的是独到的字符个数
            char[] buf = new char[3];

            /*//返回从文件中取到的字符的个数
            int read = fr.read(buf);

            //将字符数组，转换成字符串，进行输出
            System.out.println("字符个数:"+read +"....."+ new String(buf));

            //过程是循环覆盖，
            int num2 = fr.read(buf);
            System.out.println(num2+"   "+new String(buf));

            int num3 = fr.read(buf);
            System.out.println(num3+"   "+new String(buf,0,num3));
        */
            int num = 0;
            while ((num = fr.read(buf)) != -1){
                System.out.println(new String(buf,0,num));
            }
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
