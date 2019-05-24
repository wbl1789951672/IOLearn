import java.io.IOException;
import java.io.InputStream;

/*
 *@author 王炳烈
 *2019/5/22  10:14
 */
/*
* 读取键盘录入
* System.out:对应的是标准输出设备：控制台
* System.in:对应的是标准输入设备：键盘
*
*需求：通过键盘录入数据，
* 当录入一行的数据是over，那么停止录入
* */
public class ReadIn {
    /*public static void main(String[] args) throws IOException {
        InputStream is = System.in;
        StringBuilder sb = new StringBuilder();
        while(true){
            int ch = is.read();
            if (ch == '\n')
            {
                String s = sb.toString();
                if (s.equals("over")){
                    break;
                }
                System.out.println(s.toUpperCase());

                //清理StringBuilder缓冲区,让每一次的字符串都是当前输入的每行的字符串。
                sb.delete(0,sb.length());
            }
            else
            sb.append((char) ch);
        }
    }*/
    public static void main(String args[]) throws IOException{

        InputStream is = System.in;
        StringBuilder sb = new StringBuilder();
        int ch = 0;
        String s = null;
        while(true){
            ch = is.read();
            if(ch == '\n'){
                s = sb.toString();
                if(s.equals("over"))
                {
                    break;
                }
                System.out.println(s.toUpperCase());
                sb.delete(0,sb.length());
            }
            else
                sb.append((char)ch);

        }
    }
}
