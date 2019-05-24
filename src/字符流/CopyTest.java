package 字符流;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 *@author 王炳烈
 *2019/5/19  16:11
 */
//将C盘一个文本文件复制到D盘
/*
* 原理：将C盘下的数据存储到一个文件夹中
*
* 步骤：1.在D盘创建一个文件，用于存储C盘文件中的数据
*       2.定义读取流和C盘文件关联
*       3.通过不断地读写完成数据交换
*       4.关闭资源
* */
public class CopyTest {
    public static void main(String[] args) throws IOException{
        copy_02();
    }
    //从C盘读取一个字符，就往D盘写一个字符
    public static void copy_01() throws IOException {
        //创建目的地
        FileWriter fw = new FileWriter("D:\\copy_01.txt");

        //与已有文件关联
        FileReader fr = new FileReader("C:\\Users\\xqq\\Desktop\\Demo.txt");

        int ch = 0;

        //读取文件
        while ((ch = fr.read()) != -1){
            fw.write(ch);
        }

        //刷新并关闭资源
        fr.close();
        fw.close();
    }

    public static void copy_02() throws IOException{
        FileWriter fw = new FileWriter("D:\\copy_01.txt");

        FileReader fr = new FileReader("C:\\Users\\xqq\\Desktop\\Demo.txt");

        char[] buf = new char[1024];

        int num = 0;

        while ((num = fr.read(buf)) != -1){
            //读几条数据，写几条数据
            fw.write(buf,0,num);
        }
        //刷新并关闭资源
        fr.close();
        fw.close();
    }
}
