package weathernode;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class TestWeatherNodeFunc {

  public static void main(String args[]){
    TestWeatherNodeFunc obj = new TestWeatherNodeFunc();
    obj.testDewPoint();
  }

  /**
   * 露点計算のテストをします。
   * 値生成にStreamを使用
   * @throws IOException
   */
  private void testDewPoint() {

//    Stream<Double> humidSt = Stream.iterate((double)45, f -> f + 0.1).limit(300);

//    List<EnvData> envList = Stream.iterate((double)15, f -> f + 0.1).limit(100)
//        .map( f -> new EnvData(f) ).collect(Collectors.toList());

//    BiFunction<Stream<Double>, Double, List<EnvData>> biF = (tempSt, humid) ->
//      tempSt.map(f -> new EnvData(f, humid)).collect(Collectors.toList());
//    List<EnvData> envList2 = Stream.iterate((double)45, f -> f + 0.1).limit(300).forEach(h -> );

    BiFunction<Stream<Double>, Double, Stream<EnvData>> biF2 = (tempSt, humid) -> tempSt.map(f -> new EnvData(f, humid));
//    List<EnvData> envList2 = Stream.iterate((double)45, f -> f + 0.1).limit(300)
//        .flatMap(h -> biF2.apply(Stream.iterate((double)15, f -> f + 0.1).limit(100), h)).collect(Collectors.toList());
    String outFilePath = "out.txt";
    try (FileWriter out = new FileWriter(outFilePath);){
      Stream.iterate((double)-3, f -> f + 0.1).limit(1050)
      .flatMap(h -> biF2.apply(Stream.iterate((double)-1, f -> f + 0.1).limit(300), h))
      .forEach(ed -> {
        double dew = WeatherNodeFunc.calcDewPoint(ed.getTemp(), ed.getHumid());
//        System.out.println("temp:" + ed.getTemp() + " humid:" + ed.getHumid() + " dew:" + dew);
        try {
          String message = String.format("temp:%.1f, humid:%.1f, dew:%.2f\n", ed.getTemp(), ed.getHumid(), dew);
          out.write(message);
        } catch (IOException e) {
          // TODO 自動生成された catch ブロック
          e.printStackTrace();
        }
      });

    } catch (FileNotFoundException e) {
      // TODO 自動生成された catch ブロック
      e.printStackTrace();
    } catch (IOException e) {
      // TODO 自動生成された catch ブロック
      e.printStackTrace();
    }


//    Stream.iterate((double)15, f -> f + 0.1).limit(100)
//        .forEach(f -> {
//          return;
//        });
  }

}
