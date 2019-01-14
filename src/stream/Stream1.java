package stream;

import java.util.ArrayList;
import java.util.List;

public class Stream1 {

  public static void main (String args[]) {

    List<Goods> list = new ArrayList<>();
    list.add(new Goods(1, 1, "鉛筆", 20));
    list.add(new Goods(2, 1, "消しゴム", 80));
    list.add(new Goods(3, 2, "コーラ", 120));
    list.add(new Goods(4, 2, "ポッカ", 128));
    list.add(new Goods(5, 3, "ポテチ", 89));


    String maxValueName = list.stream().max((a,b)->(int)a.getValue()-(int)b.getValue()).get().getName();
    System.out.println("maxValueName:" + maxValueName);

    long sumValueDrink = list.stream().filter(t -> t.getTypeId()==2).mapToLong(t -> t.getValue()).sum();
    System.out.println("sumValueDrink:" + sumValueDrink);


  }

}
