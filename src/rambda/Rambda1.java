package rambda;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Rambda1 {

  public static void main(String args[]) {

    ScheduledExecutorService exec = Executors.newScheduledThreadPool(2);
    for (int i=0; i<5; i++) {
      final int num = i;
      System.out.println("Hello! - " + num);
      exec.schedule( () ->
      {
        System.out.println("run-" + num);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          // TODO 自動生成された catch ブロック
          e.printStackTrace();
        }
        System.out.println(num + " finished.");
      } , 1000, TimeUnit.MILLISECONDS);
    }

  }

}
