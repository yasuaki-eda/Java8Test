package weathernode;

/**
 * 環境データクラス
 * @author eda
 *
 */
public class EnvData {

  private double temp;    // 温度
  private double humid;   // 湿度
  private double dewPoint;  // 露点

  public EnvData(double temp){
    this.temp = temp;
  }
  public EnvData(){
  }

  public EnvData(double temp, double humid){
    this.temp = temp;
    this.humid = humid;
  }


  public double getDewPoint() {
    return dewPoint;
  }
  public void setDewPoint(double dewPoint) {
    this.dewPoint = dewPoint;
  }
  public double getHumid() {
    return humid;
  }
  public void setHumid(double humid) {
    this.humid = humid;
  }
  public double getTemp() {
    return temp;
  }
  public void setTemp(double temp) {
    this.temp = temp;
  }


}
