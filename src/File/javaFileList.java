package File;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 *@author 王炳烈
 *2019/5/25  17:01
 */
/*
* 练习
* 将一个指定目录下的java文件的绝对路径，存储到一个文本文件当中
* 建立一个java文件列表文件
*
*
* 思路：
* 1.对指定的目录进行递归
* 2.获取递归过程中所有的java文件的路径
* 3.将这些路径存储到集合中
*4.将集合中的数据写到文件中
*
* */
public class javaFileList {
    public static void main(String[] args) throws IOException{
        File dir = new File("D:\\IDEA_WorkSpace");
        List<File> list = new ArrayList<>();
        fileTolist(dir,list);


        File f = new File(dir,"javaFile.txt");
        writeToFile(list,f.toString());
    }
    public static void fileTolist(File dir, List<File> list){
        File[] files = dir.listFiles();
        for (File file:files){
            if (file.isDirectory()){
                fileTolist(file,list);
            }else{
                if (file.getName().endsWith(".java")){
                    list.add(file);
                }
            }
        }
    }
    public static void writeToFile(List<File> list,String javalistFIle) throws IOException{
        BufferedWriter bufw = null;
        try{
            bufw = new BufferedWriter(new FileWriter(javalistFIle));
            for (File file : list) {
                String path = file.getAbsolutePath();
                bufw.write(path);
                bufw.newLine();
                bufw.flush();
            }
        }catch(IOException e){

        }finally {
            try{
                if (bufw != null){
                    bufw.close();
                }
            }catch(IOException e){
                throw e;
            }
        }
    }
}
