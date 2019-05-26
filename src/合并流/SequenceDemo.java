package 合并流;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/*
 *@author 王炳烈
 *2019/5/26  16:13
 */
public class SequenceDemo {
    public static void main(String[] args) throws IOException {
        //只有vector集合可以获取枚举类型，创建Vector对象
        Vector<FileInputStream> v = new Vector<>();

        //在Vector内增加读取流对象，分别绑定多个文件
        v.add(new FileInputStream("D:\\1.txt"));
        v.add(new FileInputStream("D:\\2.txt"));
        v.add(new FileInputStream("D:\\3.txt"));

        //枚举类型，由Vector.elements()获取Vector内所有数据
        Enumeration<FileInputStream> en = v.elements();

        //将所有输入流，汇成一股大流（针对多个源，一个目的的情况）
        SequenceInputStream sis = new SequenceInputStream(en);

        //创建输出流对象
        FileOutputStream fos = new FileOutputStream("C:\\Users\\xqq\\Desktop\\4.txt");

        //字节流使用字节数组
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = sis.read(buf)) != -1) {

            //向文件中下入流中的数据
            fos.write(buf, 0, len);
        }

        //刷新并关闭流对象
        sis.close();
        fos.close();
    }
}
