package 字符流.FileWriter;

import java.io.FileWriter;
import java.io.IOException;

/*
 *@author 王炳烈
 *2019/5/19  10:40
 */
//文件续写数据
public class FileWriteDemo3 {
    public static void main(String[] args) {
        //传递一个true参数，代表不覆盖已有的文件，并在已有文件的末尾进行数据续写
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("C:\\Users\\xqq\\Desktop\\Demo.txt",true);
            fileWriter.write("你好\n谢谢");
        }catch (IOException e){
            System.out.println(e.toString());
        }
        finally {
            if (fileWriter != null){
                try{
                    fileWriter.close();
                }catch(IOException e){
                    System.out.println(e.toString());
                }
            }
        }
    }
}
