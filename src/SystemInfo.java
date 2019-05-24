import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/*
 *@author 王炳烈
 *2019/5/23  9:14
 */
public class SystemInfo {
    public static void main(String[] args) throws IOException {

        System.setOut(new PrintStream("C:\\Users\\xqq\\Desktop\\Demo.txt"));
        //系统加载信息（返回的是一个集合）
        Properties properties = System.getProperties();

        //调用输出方法
        properties.list(System.out);

        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String s = sdf.format(date);
        System.out.println("s = " + s);
    }
}
