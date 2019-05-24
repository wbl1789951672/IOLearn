package Buffered;/*
 *@author 王炳烈
 *2019/5/19  17:03
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//字符读取缓冲区(对"行"的高校读取)
public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        //创建一个读取流对象和文件相关联
        FileReader fr = new FileReader("C:\\Users\\xqq\\Desktop\\Demo.txt");

        //为了提高效率，加入缓冲技术，将字符读取对象最为参数传递给告诉缓冲对象的构造函数
        BufferedReader bufr = new BufferedReader(fr);

        String line;

        //readLine()方法(只返回有效数据，不返回换行符)，当返回空时，表示读到文件末尾
        while ((line = bufr.readLine()) != null)
        {
            System.out.println(line);
        }

        bufr.close();
    }
}
