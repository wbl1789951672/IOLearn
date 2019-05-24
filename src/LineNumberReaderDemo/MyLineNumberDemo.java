package LineNumberReaderDemo;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/*
 *@author 王炳烈
 *2019/5/21  16:22
 */
class MyLineNumberReader{
    private Reader r;
    private int lineNumber = 0;

    public MyLineNumberReader(Reader r){
        this.r = r;
    }
    public String MyReadLine() throws IOException {
        lineNumber ++;
        StringBuilder sb = new StringBuilder();
        int ch = 0;
        while((ch = r.read()) != -1){
            if(ch == '\r')
                continue;
            if (ch == '\n')
                return sb.toString();
            else{
                sb.append((char) ch);
            }
        }
        if (sb.length() != 0)
            return sb.toString();
        return null;
    }
    public void setLineNumber(int lineNumber){
        this.lineNumber = lineNumber;
    }
    public int getLineNumber(){
        return lineNumber;
    }
    public void Myclose() throws IOException{
        r.close();
    }
}
public class MyLineNumberDemo {
    public static void main(String[] args) throws IOException{
        FileReader fr = new FileReader("C:\\Users\\xqq\\Desktop\\Demo.txt");

        MyLineNumberReader lnr = new MyLineNumberReader(fr);

        String line = null;

        lnr.setLineNumber(10);
        while((line = lnr.MyReadLine()) != null){
            System.out.println(lnr.getLineNumber() + ":  " + line);
        }
    }
}
