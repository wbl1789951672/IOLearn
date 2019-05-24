package Buffered;

import java.io.*;

/*
 *@author 王炳烈
 *2019/5/19  17:40
 */
//通过缓冲区复制文件
public class CopyTestByBuf {
    public static void main(String[] args) {
        BufferedReader bufr = null;
        BufferedWriter bufw = null;
        try {
            bufr = new BufferedReader(new FileReader("C:\\Users\\xqq\\Desktop\\Demo.txt"));
            bufw = new BufferedWriter(new FileWriter("D:\\copy_01.txt"));

            String line = null;

            while ((line = bufr.readLine()) != null){
                bufw.write(line);
                bufw.newLine();
                bufw.flush();
            }

        }catch (IOException e){
            System.out.println(e.toString());
            throw new RuntimeException("读写失败！");
        }
        finally {
            try {
                if (bufr != null)
                    bufr.close();
            }catch (IOException e) {
                throw new RuntimeException("读取关闭失败！");
            }
            try {
                if (bufw != null)
                    bufw.close();
            }catch (IOException e) {
                throw new RuntimeException("写入关闭失败！");
            }
        }
    }
}
