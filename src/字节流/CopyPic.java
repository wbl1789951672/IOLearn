package 字节流;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 *@author 王炳烈
 *2019/5/21  20:12
 */
//复制一个图片
public class CopyPic {
    public static void main(String[] args) throws IOException {
        //FileOutputStream fos = new FileOutputStream("C:\\Users\\xqq\\Desktop\\a.tiff");

        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fos = new FileOutputStream("C:\\Users\\xqq\\Desktop\\b.tiff");
            fis = new FileInputStream("C:\\Users\\xqq\\Desktop\\a.tiff");

            byte[] buf = new byte[1024];

            int len = 0;

            while((len = fis.read(buf)) != -1){
                fos.write(buf,0,len);
            }


        }catch (IOException e){
            throw new RuntimeException("复制文件失败！");

        }finally {
            try{
                if (fis != null)
                {
                   fis.close();
                }
            }catch (IOException e){
                throw new RuntimeException("读取关闭失败！");
            }

            try{
                if (fos != null)
                {
                    fos.close();
                }
            }catch (IOException e){
                throw new RuntimeException("写入关闭失败！");
            }
        }

    }
}
