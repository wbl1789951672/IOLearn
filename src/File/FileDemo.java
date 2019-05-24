package File;

import java.io.File;
import java.io.IOException;

/*
 *@author 王炳烈
 *2019/5/23  9:56
 */
/*
File对象只是跟文件绑定，
* 1.创建
* CreateNewFile（返回类型Boolean）
* 在指定位置创建文件，如果文件已存在，则不创建，返回false
* 和输出流不一样，输出流对象一建立创建文件，如果文件存在会覆盖
* boolean mkdir()只能创建一级目录
  boolean mkdirs（）可以创建多级目录


* 2.删除
* boolean delete（）；删除失败返回false
* void deleteOnExit（）；在程序退出时删除指定文件
*
* 3.判断
boolean isFile  是否是文件
boolean isDirectory  是否是目录
boolean isAbsolute  是否是绝对路径
*
* 4.获取数据
*getName();
getPath();
getParent();

getAbsolutePath();
lastModified();   获得最后一次修改时间（long）
length();    （long）获得长度

*file1.renameTo（file2）//将file1剪切到file2位置去
*
* */
public class FileDemo {
    public static void main(String[] args) throws IOException{
        Method_05();
    }
    //删除文件
    public static void Methed_01() throws IOException {
        File f = new File("tile.txt");

        sop(f.delete());
    }

    //文件判断
    public static void Method_02(){
        File f  = new File("Demo1.txt");

        //记住：在判断文件对象是否是文件或者文件夹的时候，必须要先判断该文件封装对象是否存在
        //通过exits判断。
        sop(f.exists());



        //判断是否是目录
        sop(f.isDirectory());

        //判断是否是文件
        sop(f.isFile());

        //判断能不能执行
        sop(f.canExecute());

        //是否是绝对路径
        sop(f.isAbsolute());
    }

    //目录的创建(mkdir()只能创建一级目录，mkdirs（）可以创建多级目录)
    public static void Method_03(){
        File f = new File("abc\\kkk");

        sop(f.mkdir());
    }

    //创建File对象
    public static void consMethod(){
        //将a.txt封装成File对象，可以将已有的和未出现的文件或文件夹封装成对象
        File f1 = new File("a.txt");

        //文件目录不变，变得是文件夹内的文件
        File f2 = new File("C:\\FileTest","b.txt");

        //功能跟上面形式一样
        File b = new File("C:\\FileTest");
        File f3 = new File(b,"c.txt");
        //系统默认分隔符（跨平台分隔符）
        File f4 = new File("C:"+File.separator+"abc"+File.separator+"def"+File.separator+"d.txt");
        //打印
        sop("F1" + f1);
        sop("F2" + f2);
        sop("F3" + f3);
        sop(f4);
    }

    //输出对象
    public static void sop(Object obj){
        System.out.println(obj);
    }

    //获取数据
    public static void Method_04(){
        File f = new File("D:\\copy_01.txt");

        //获得相对路径
        sop(f.getPath());

        //获得绝对路径
        sop(f.getAbsolutePath());

        //返回绝对路径下的父目录(实例化file对象时，如果没制定绝对路径，返回值为NULL)
        sop(f.getParent());
    }

    //剪切
    public static void Method_05(){
        File f1 = new File("D:\\copy_01.txt");
        File f2 = new File("C:\\Users\\xqq\\Desktop\\copy_02.txt");

        //剪切功能
        sop(f1.renameTo(f2));
    }
}
