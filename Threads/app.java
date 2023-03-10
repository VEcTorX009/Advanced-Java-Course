package Threads;

import java.util.Scanner;

class Processor extends Thread {
    private volatile boolean running = true;
    //volatile keyword is used to prevent threads clashing variables when their not changed
    public void run()
    {
        while(running)
        {
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void shutdown()
    {
        running = false;
    }
}

public class app
{
 public static void main(String[] args) {
     Processor proc1 = new Processor();
     proc1.start();

     System.out.println("Press return to stop..");
     Scanner sc = new Scanner(System.in);
     sc.nextLine();

     proc1.shutdown();
     sc.close();
 }
}