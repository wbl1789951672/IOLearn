package File;

/*
 *@author 王炳烈
 *2019/5/24  19:59
 */

/*
* 删除一个带内容的目录
*删除原理
* 在windows中，删除目录从里面往外删除的
*
* 既然是从里往外删除，就要用到递归
*
*
* */

import java.io.File;

public class removeDir {
    public static void main(String[] args) {
        File f = new File("D:\\FileTest");
        removeDir_01(f);
    }

    public static void removeDir_01(File dir){
        File[] files = dir.listFiles();
        for(int i = 0; i < files.length;i ++){
            if(files[i].isDirectory())
            {
                removeDir_01(files[i]);
            }
            else{
                System.out.println("file："+ files[i].toString()+"\n删除结果："+files[i].delete());
            }
        }
        System.out.println("file :"+dir.toString()+dir.delete());
    }
}
