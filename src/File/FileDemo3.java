package File;

import java.io.File;

/*
 *@author 王炳烈
 *2019/5/24  10:04
 */
/*
*
* 列出指定目录下文件夹或者文件，包含子目录中的内容
* 也就是列出指定目录下所有内容
*
*
* */
public class FileDemo3 {
    public static void main(String[] args) {
        /*File dir = new File("D:\\NET大作业");
        showDir(dir);*/

        /*toBin(6);*/

        System.out.println(getSum(10));
    }
    //获取目录中的文件和文件夹(递归)
    public static void showDir(File dir){
        System.out.println("******************************************************");
        //输出目录
        System.out.println(dir);

        //获得目录中的文件或者文件夹
        File[] files = dir.listFiles();

        for (int x = 0; x < files.length ; x ++){

            if (files[x].isDirectory()){
                //假如是路径（文件夹），调用本函数
                showDir(files[x]);
            }else{
                //不是文件夹，就输出文件
                System.out.println(files[x]);
            }

        }

    }

    /*
    * 递归需要注意
    * 1.终止条件
    *
    *2.递归次数
    *
    * */

    //数值求二进制（递归模拟）
    public static void toBin(int num){
        if (num > 0) {
            toBin(num / 2);
            System.out.print(num % 2);
        }
    }

    //递归求和
    public static int getSum(int n){
        if (n == 1){
            return 1;
        }
        else{
            return n + getSum(n - 1);
        }
    }
}












