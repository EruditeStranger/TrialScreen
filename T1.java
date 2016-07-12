package com.rb;
import java.util.Random;

public class T1 implements Runnable{

    int time;
    String name;
    Random r = new Random();

    public T1(String s){
        time=r.nextInt(999);
        name= s;
    }
    public void run()
    {
        try {
            System.out.printf("%s runs for %d time\n", name, time);

            Thread.sleep(time);

            System.out.printf("%s is done executing!\n",name);
        }
        catch(Exception e){};

    }
}
