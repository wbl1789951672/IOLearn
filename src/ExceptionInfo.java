
import java.io.IOException;
import java.io.PrintStream;

/*
 *@author 王炳烈
 *2019/5/22  21:07
 */
public class ExceptionInfo {
    public static void main(String[] args) {
        try{
            int[] arr = new int[2];
            System.out.println("arr = " + arr[3]);
        }catch(Exception e){
            try{
                System.setOut(new PrintStream("C:\\Users\\xqq\\Desktop\\Demo.txt"));
                e.printStackTrace(System.out);
            }catch(IOException e1){

                e.printStackTrace();
            }
        }
    }
}
