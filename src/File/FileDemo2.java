package File;

/*
 *@author 王炳烈
 *2019/5/24  9:00
 */

import java.io.File;
import java.io.FilenameFilter;

/*
* 文件列表
* */
public class FileDemo2 {
    public static void main(String[] args) {
        listDemo2();

    }
    public static void listDemo2(){
        File f = new File("D:\\");

//        FilenameFilter文件过滤器，FilenameFilter是一个接口，并且只有一个方法，所以采用内部类的方式去实现
        //单纯的文件名
        String[] names = f.list(new FilenameFilter() {

            //当accept方法返回true时，文件不过滤，否则，过滤
            @Override
            public boolean accept(File f, String name) {

                //传入的FIle对象，是跟文件夹或目录绑定的，
                //name就是在此文件夹或目录内的文件名，name只代表一个文件夹名

                //String.endsWith(“”)就是判断字符串末尾是不是跟着字符串".png"
                return name.endsWith(".png");
            }
        });
        for (String s: names){
            System.out.println(s);
        }
    }
    public static void listDemo(){

        //list方法，列出目录内的所有文件或者文件夹(单纯的目录内的文件名)
        // string[] list();
        File f = new File("C:\\");
        String[] names = f.list();

        for(String s : names){
            System.out.println(s);
        }
    }
    public static void listRootDemo(){
        //文件对象数组，获得盘符
        //file[] listRoots();返回File[]
        File[] files = File.listRoots();

        //增强for循环
        for (File f: files) {
            System.out.println(f);
        }

        /*
        结果：
        C:\
        D:\*/
    }

    public static void ListFilesDemo(){
        //f  绑定目录
        File f = new File("D:\\");

//        返回绑定目录中的文件或者文件夹所绑定的FIle对象
        File[] files = f.listFiles();

        //遍历
        for (File file : files){

            //输出文件名和其大小

            //System.out.println(file.getName() + "::" +file.length());
        }
        //缺点：目录中的文件夹中的内容不能列出

    }
}
