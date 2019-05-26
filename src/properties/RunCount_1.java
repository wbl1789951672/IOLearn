package properties;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

    public class RunCount_1 {
        static int count_1 = 1;
        public static void main(String[] args) throws IOException

        {
            RunC();
            JFrame frame = new JFrame("Test");
            frame.setSize(400,400);
            JLabel label = new JLabel("If you can open it six times, you will lose.the"+count_1+"open");
            frame.add(label);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        public static void RunC() throws IOException{
            Properties prop = new Properties();
            File file = new File("count.ini");

            if (!file.exists()){
                file.createNewFile();
            }

            FileInputStream fis = new FileInputStream("count.ini");

            prop.load(fis);

            int count = 0;
            String value = prop.getProperty("time");

            if (value != null){
                count = Integer.parseInt(value);
                count_1 = count + 1;
                if (count >= 5){
                    System.out.println("The number of use has arrived, please register to buy!");
                    JOptionPane.showMessageDialog(null,"Please pay for the registered genuine!");
                    System.exit(0);
                }
            }

            count ++;

            prop.setProperty("time",count+"");

            FileOutputStream fos = new FileOutputStream(file);

            prop.store(fos,"");

            fos.close();
            fis.close();
        }
    }

