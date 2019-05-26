package properties;

/*
 *@author 王炳烈
 *2019/5/26  9:48
 */
/*
*用于记录应用程序使用次数
* 如果使用次数已到，那么给出注册提示
*
* 很容易想到的是：计数器
* 可是该计数器定义在程序中，随着程序的运行的产生在内存中，并且自增
* 可是随着该应用程序的退出，该计数器也在内存中小时了
*
* 下次在启动该应用程序，又重新开始从零计数
* 这样不是我们想要的。
*
* 程序即使结束，该计数器的值也存在
* 下次程序启动会先加载计数器的值并加1后在重新存储起来
*
* 所以要建立一个配置文件，用于记录该软件的使用次数
*
* 该配置文件使用键值对的形式
* 数据是以文件形式存储，使用IO技术
* 那么 map + io  -->properties
*
* 配置文件可以实现应用程序数据的共享
*
*
*
*
* */

import javax.swing.*;
import java.io.*;
import java.util.Properties;

public class RunCount {
    static int count_1 = 0;
    public static void main(String[] args) throws IOException

    {
        //程序开始，首先计数
        RunC();
        JFrame frame = new JFrame("Test");
        frame.setLocation(600,300);
        frame.setSize(400,400);
        JLabel label = new JLabel("                                能打开6次算我输！第"+count_1+"次打开！");
        frame.add(label);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void RunC() throws IOException{

        //获取properties集合（map + IO）
        Properties prop = new Properties();

        //将文件与File对象绑定
        File file = new File("count.ini");

        //如果文件不存在
        if (!file.exists()){

            //创建文件
            file.createNewFile();
        }

        //创建一个字节流对象，绑定前面创建的文件
        InputStreamReader isr = new InputStreamReader(new FileInputStream("count.ini"),"GBK");
        //FileInputStream fis = new FileInputStream("count.ini");


        //读取流中的数据，放在properties集合中
        prop.load(isr);

        //创建计数器
        int count = 0;

        //从properties集合中读取键为“time”的数据
        String value = prop.getProperty("time");

        //如果数据不为Null
        if (value != null){
            //将获取到的数据转换为int类型
            count = Integer.parseInt(value);

            //给类变量赋值
            count_1 = count+1;

            //如果使用次数大于等于5
            if (count >= 5){

                //告诉用户次数已用完
                System.out.println("使用次数已到，请注册购买！");
                JOptionPane.showMessageDialog(null,"请花钱购买注册正版！");

                //退出程序
                System.exit(0);
            }
        }

        //计数器累加
        count ++;

        //将改变了的计数器写入到内存中（修改properties集合内的键值对）
        prop.setProperty("time",count+"");

        //创建输出流对象
        FileOutputStream fos = new FileOutputStream(file);


        //将properties中的数据输出到之前绑定的文件中
        prop.store(fos,"");

        //关闭输入输出流
        fos.close();
        isr.close();
    }
}
