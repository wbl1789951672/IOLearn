package Buffered;

import java.io.FileReader;
import java.io.IOException;

/*
 *@author 王炳烈
 *2019/5/21  9:17
 */
class myBufferedReader{
    private FileReader fr = null;

    public myBufferedReader(FileReader fr){
        this.fr = fr;
    }
    public String myReadLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        int ch = 0;
        while ((ch=fr.read()) != -1){
            if (ch == '\r'){
                continue;
            }
            if(ch == '\n'){
                return sb.toString();
            }
            else{
                sb.append((char)ch);
            }
        }
        if (sb.length() != 0)
            return sb.toString();
        return null;
    }
    public void muClose() throws IOException{
        fr.close();
    }
}
public class myBufferedReaderDemo {
    public static void main(String[] args) throws IOException{
        FileReader fr = new FileReader("C:\\Users\\xqq\\Desktop\\Demo.txt");

        myBufferedReader myBufferedReader = new myBufferedReader(fr);

        String myLine = null;
        while ((myLine = myBufferedReader.myReadLine()) != null){
            System.out.println(myLine);
        }

        myBufferedReader.muClose();
    }
}
