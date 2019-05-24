package 字符流.FileWriter;

import java.io.FileWriter;
import java.io.IOException;

//文件写数据
public class FileWriterDemo {

    public static void main(String[] args) throws IOException {
	// write your code here
        //创建一个FileWriter对象，该对象一被初始化就必须要明确被操作的文件。
        //而且该文件会被创建到指定的目录下，如果目录中有同名的文件，那么将被覆盖
        //其实该步就是在明确数据要存放的目的地
        FileWriter fw = new FileWriter("C:\\Users\\xqq\\Desktop\\Demo.txt");

        //调用write方法，将字符串写入到流中
        fw.write("abcde");

        //刷新流对象中的缓冲中的数据
        //将数据刷新到目的文件中
        fw.flush();

        //关闭流资源，但是关闭之前会刷新一次内部的缓冲中的数据
        //将数据刷到目的地中
        //和flush的区别。flush刷新后，流可以继续使用，close刷新后，会将流关闭
        fw.close();
    }
}
