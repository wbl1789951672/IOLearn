package properties;

/*
 *@author 王炳烈
 *2019/5/25  18:19
 */
/*
* properties是hashtable的子类
* 也就是说它具备map集合的特点，而且他里面存储的键值对都是字符串
*
* 是集合中和IO技术相结合的集合容器
*
* 该对象的特点：可以用于键值对形式的配置文件
*
* */

import sun.nio.cs.ext.GBK;

import java.awt.*;
import java.io.*;
import java.util.Properties;
import java.util.Set;

public class propertiesDemo {
    public static void main(String[] args) throws IOException{
        LoadDemo();
    }
    //演示，如何将流中的数据存储到集合中
    //要将copy_02.txt中键值数据存到集合中进行操作
    /*
    * 1.用一个流和文件关联
    * 2.读取一个数据，将该行数据用“=”进行切割
    * 3.等号左边作为键，右边作为值，存到properties集合中即可
    *
    * */
    public static void method_1() throws IOException {
        BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\xqq\\Desktop\\copy_02.txt"), "GBK"));
        Properties prop = new Properties();
        String line = null;
        while ((line = bufr.readLine()) != null){
            String[] arr = line.split("=");

//            for (String s : arr) {
//                System.out.println(s);
                prop.setProperty(arr[0],arr[1]);
//            }
        }
        prop.forEach((k,m)-> System.out.println("键：" + k + "  值： " + m));

    }

    //设置元素和获取元素
    public static void setAndGet(){
        Properties prop = new Properties();

        prop.setProperty("张三","30");
        prop.setProperty("李四","39");

        System.out.println(prop);
        String value = (String) prop.get("李四");

        System.out.println(value);

        Set<String> strings = prop.stringPropertyNames();

        for (String string : strings) {
            System.out.println(prop.get(string));
        }


    }

    public static void LoadDemo() throws IOException{

        //创建一个键值对集合
        Properties prop = new Properties();
        //创建流读取数据
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("C:\\Users\\xqq\\Desktop\\copy_02.txt"), "GBK");

        //加载传入流中读取的信息，加载的prop集合中（键值对信息）
        prop.load(inputStreamReader);

//        修改集合中的信息
        prop.setProperty("王五","199");

        FileOutputStream fos = new FileOutputStream("C:\\Users\\xqq\\Desktop\\copy_02.txt");

        //store(流，”注释信息“)该方法是将内存中的数据通过传入的流写入相应的文件中
        prop.store(fos,"hah");
//        System.out.println(prop);
    }

}
