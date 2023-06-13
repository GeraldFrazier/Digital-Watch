import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


class DigitalWatch implements Runnable{
    JFrame f;
    Thread t;
    int hours=0, minutes=0, seconds=0;
    String timeString = "";
    JButton b;
    private static final Logger logger = LogManager.getLogger(DigitalWatch.class);


    DigitalWatch(){
        f=new JFrame();

        t = new Thread(this);
        t.start();

        b=new JButton();
        b.setBounds(100,100,100,50);

        f.add(b);
        f.setSize(300,400);
        f.setLayout(null);
        f.setVisible(true);

    }

    public void run (){
        try {
            while (true){
                Calendar cal = Calendar.getInstance();
                hours = cal.get(Calendar.HOUR_OF_DAY);
                if (hours > 12 ) hours -= 12;
                minutes = cal.get(Calendar.MINUTE);
                seconds = cal.get (Calendar.SECOND);

                SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
                Date date =cal.getTime();
                timeString = formatter.format(date);

                printTime();

                t.sleep(1000);

            }
        }
        catch (Exception e){
            "Exception in DigitalWatch", e);        }}

        public void printTime(){
            b.setText(timeString);
        }
    }





public class Main {
    public static void main(String[] args) {
       new DigitalWatch();
    }
}