package 流转换以及操作规律;

import java.io.*;

/*
 *@author 王炳烈
 *2019/5/22  11:53
 */

/*
*1.键盘输入，控制台输出
* 2.键盘输入，输出到文件
* 3文件读入，输出到控制台
*
*
*
* */
public class TransStreamDemo {
    public static void main(String[] args) throws IOException {
        request_03();

    }
    //键盘输入，控制台输出
    public static void request_01() throws IOException{
        /*//获取键盘录入对象
        InputStream in = System.in;

        //将字节流对象转换成字符流对象，使用转换流，InputStreamReader
        InputStreamReader isr = new InputStreamReader(in);

        //为了提高效率，将字符串进行缓冲区技术高校操作，使用BufferedReader
        BufferedReader bufr = new BufferedReader(isr);*/

        //三句合成一句(字节转成字符流（读取）键盘读入)最常用的标准输入
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));


        //（字符转成字节流（写入）控制台输出）
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = null;
        while((line = bufr.readLine()) != null){
            if ("over".equals(line))
                break;
            bufw.write(line.toUpperCase());

            //由于缓冲区的原因，必须刷新缓冲区调用flush（）方法！
            bufw.newLine();
            bufw.flush();

        }
        bufr.close();
    }
    //键盘输入，输出到文件
    public static void request_02() throws IOException{
        //键盘读入
        BufferedReader bufr  = new BufferedReader(new InputStreamReader(System.in));

        //输出到文件
        BufferedWriter bufw = new BufferedWriter(new FileWriter("D:\\copy_01.txt",true));

        String line = null;
        while ((line = bufr.readLine()) != null){
            if ("over".equals(line))
                break;
            bufw.write(line);
            bufw.newLine();
            System.out.println(line.toUpperCase());
        }
        bufr.close();
        bufw.close();
    }

    //文件读入，控制台输出
    public static void request_03() throws IOException{
        //文件读入
        BufferedReader bufr = new BufferedReader(new FileReader("D:\\copy_01.txt"));

        //将数据写入控制台
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = null;
        while((line = bufr.readLine()) != null){
            bufw.write(line);
            bufw.newLine();
        }
        bufr.close();
        bufw.close();
    }
}
