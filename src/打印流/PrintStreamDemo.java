package 打印流;

import java.io.*;

/*
 *@author 王炳烈
 *2019/5/26  13:19
 */
/*
* 打印流
*
* 该流提供了打印方法，可以将各种数据类型的数据都原样打印
*
* 字节打印流：
* PrintStream
* 构造函数可以接受的参数类型
* 1.file对象
* 2.字符串路径
* 3.字节输出流：outputStream
*
*
* 字符打印流：
* PrintWriter
* 构造函数可以接收的参数类型
* 1.file对象，File
* 2.字符串路径
* 3.字节输出流OutputStream
* 4.字符输出流Writer
*
*
* */
public class PrintStreamDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\xqq\\Desktop\\copy_02.txt",true),true);

        String line = null;

        while((line = bufr.readLine()) != null){
            if ("over".equals(line))
                break;
            out.println(line.toUpperCase());
        }

        bufr.close();
        out.close();
    }
}
