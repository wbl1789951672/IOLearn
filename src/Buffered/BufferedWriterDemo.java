package Buffered;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 *@author 王炳烈
 *2019/5/19  16:50
 */
public class BufferedWriterDemo {
    public static void main(String[] args) throws IOException {
        //创建一个流对象
        FileWriter fw = new FileWriter("C:\\Users\\xqq\\Desktop\\Demo.txt");

        //为了提高字符写入流的效率，加入了缓冲技术
        //只需要将被加速的流对象作为参数传递给缓冲区的构造函数即可
        BufferedWriter bufw = new BufferedWriter(fw);

        bufw.write("abc\nde");

        //只要用到缓冲区，就要记得刷新
        bufw.flush();

        //其实关闭缓冲区，就是关闭缓冲区的流对象
        fw.close();
    }
}
