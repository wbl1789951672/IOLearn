package 字节流;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.*;

/*
 *@author 王炳烈
 *2019/5/21  18:56
 */
public class FileStream {

    //字节流读一个
    public static void readFile_1() throws IOException{
        FileInputStream fis = new FileInputStream("Demo.txt");

        int ch = 0;
        while((ch = fis.read()) != -1 ){
            System.out.println((char) ch);
        }

        fis.close();
    }
    //字节流读一个数组
    public static void readFile_2() throws IOException{
        FileInputStream fis = new FileInputStream("Demo.txt");

        byte[] buf = new byte[1024];

        int len = 0;
        while((len = fis.read(buf)) != -1){
            System.out.println(new String(buf, 0, len));
        }

        fis.close();
    }
    //字节流特有的读数据(不太建议用)
    public static void readFile_3() throws IOException{
        FileInputStream fis = new FileInputStream("Demo.txt");

        int num = fis.available();

        byte[] buf = new byte[num];
        fis.read(buf);
        System.out.println(new String(buf));
        fis.close();
    }
    public static void writeFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("Demo.txt");

        fos.write("abcde".getBytes());


        fos.close();

    }
    public static void main(String[] args) throws IOException{
        readFile_3();

    }
}
