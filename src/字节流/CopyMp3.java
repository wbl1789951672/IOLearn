package 字节流;

import java.io.*;

/*
 *@author 王炳烈
 *2019/5/21  20:23
 */
//演示Mp3的复制，通过缓冲区
//BufferedOutputStream
//BufferedInputStream
public class CopyMp3 {
    public static void main(String[] args) throws IOException{
        copy_1();
    }
    public static void copy_1() throws IOException{
        BufferedInputStream bufis = new BufferedInputStream(new FileInputStream("C:\\Users\\xqq\\Desktop\\a.tiff"));
        BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\xqq\\Desktop\\c.tiff"));

        int by = 0;

        while((by = bufis.read()) != -1){
            bufos.write(by);
        }

        bufis.close();
        bufos.close();

    }
}
