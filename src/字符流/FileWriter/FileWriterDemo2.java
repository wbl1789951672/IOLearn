package 字符流.FileWriter;

import java.io.FileWriter;
import java.io.IOException;

/*
 *@author 王炳烈
 *2019/5/19  10:23
 */
//标准的IO异常处理
public class FileWriterDemo2 {
    public static void main(String[] args) {
        FileWriter fw = null;//外部初始化
        try {
            //内部实例化
            fw = new FileWriter("C:\\Users\\xqq\\Desktop\\Demo.txt");
            //写数据
            fw.write("aaaaaa");

        //对异常进行处理
        }catch (IOException e){
            System.out.println(e.toString());
        }
        //最终关闭资源
        finally{
            try {
                //要判断是否为空，为空的话就不进行资源关闭
                if(fw != null)
                fw.close();
            }catch (IOException e){
                System.out.println(e.toString());
            }

        }

    }
}
