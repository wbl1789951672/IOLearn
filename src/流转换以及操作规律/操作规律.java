package 流转换以及操作规律;

import java.io.*;

/*
 *@author 王炳烈
 *2019/5/22  15:52
 */
public class 操作规律 {
    /*
    * 通过三个明确来确定：
    * 1.明确源和目的
    *   源：输入流，InputStream   Reader
    *   目的：输出流，OutputStream  Writer
    * 2.操作的数据是否是纯文本
    *   是：字符流
    *   不是：字节流
    * 3.当体系明确后，再明确要使用哪个具体的对象
    *   通过设备来进行区分
    *   原设备：内存，硬盘，键盘
    *   目的设备：内存，硬盘，控制台
    *
    *
    *
    *
    *
    * 需求1.将一个文本文件中的数据存储到另一个文件中，文件复制。
    *   源：因为是源，所以使用读取流，InputStream   Reader
    * 是不是文本文件
    *   是，这时就可以选择Reader
    *   这样体系就明确了
    * 接下来明确要使用该体系中的哪个对象
    * 明确设备：硬盘上的一个文件
    * Reader体系中可以操作文件的对象是FileReader
    *
    * 是否需要提高效率:是，加入Reader中的缓冲区BufferedReader
    *
    * FileReader fr = new FileReader("a.txt");
    *BufferedReader bufr = new BufferedReader(fr);
    * 目的：OutputStream  Writer
    *
    * 是否是纯文本
    * 是  Writer
    * 设备：硬盘，一个文件
    *
    * Writer体系中可以操作文件的对象FileWriter
    *
    * 是否需要提高效率：是，BufferedWriter
    * FileWriter fw = new FileWrite("b.txt");
    * BufferedWriter bufw = new BufferedWriter(fw);
    *
    *
    *
    *
    *
    * 需求2：将键盘录入的数据保存到一个文件中
    *       这个需求中有源和目的都存在
    *       那么分别分析
    *      源：InputStream    Reader
    *     是不是纯文本？是，Reader
    *       设备：键盘，对应的System.in
    *      不是选择Reader吗？System.in对应的不是字节流吗？
    * 为了操作键盘的文本数据方便，转成字符流，按照字符串操作是最方便的
    * 所以，既然明确了Reader那么就将System.in。转换成字符流Reader，
    * 用了Reader体系中的转换流，InputStreamReader
    *
    * InputStraemReader isr = new InputStreamReader(System.in);
    * 需要提高效率吗？需要，BufferedReader
    * BufferedReader bufr = new BufferedReader(isr);
    *
    *   目的：OutputStream   writer
    * 是否是纯文本？是   Writer
    * 设备：硬盘，一个文件   FileWriter
    * FileWriter fw = new FileWriter("a.txt");
    * 需要提高效率吗？
    **********************************************
    *扩展：想要把录入的数据按照指定的编码表（utf-8）,将数据存到文件中
    *
    * 目的：OutputStream   writer
     * 是否是纯文本？是   Writer
     * 设备：硬盘，一个文件   FileWriter
     * 但是，存储时需要加入指定的编码表，而指定的编码表只有转换流可以指定
     * 所以要使用的对象是OutputStreamWrite
     * 而该转换流对象需要接受一个字节输出流，而且还可以操作文件的字节输出流，FileOutputStream
     * OutputStreamWriter osw = new OutputStreamWrite(new FileOutputStream("a.txt","UTF-8"))
     * 需要提高效率吗？
     * BufferedWriter bufw = new BufferedWriter(osw);
     *
     * 所以，记住，转换流什么时候使用，字符和字节之间的桥梁，通常，设计到字符编码转换时需要用到转换流
    *

    *
    * */
    public static void main(String[] args) throws IOException{
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\copy_01.txt")));

        String line = null;
        while ((line = bufr.readLine()) != null){
            if ("over".equals(line)){
                break;
            }
            bufw.write(line);
            bufw.newLine();
            bufw.flush();

        }
        bufw.close();
    }
}
