package weathernode;

public class WeatherNodeFunc {


  /**
   * テテンの実験式によりある温度に於ける飽和水蒸気圧を求めます
   * @param temp : 温度[℃]
   * @return : 飽和水蒸気圧[hPa]
   */
  public static double calcTetensEs(double temp){
    final double a = 7.5;
    final double b = 237.3;
    return 6.11 * Math.pow (10, a*temp/(b+temp));
  }


  /**
   * 露点を計算します。
   * @param temp : 気温[℃]
   * @param humid : 湿度[%]
   * @return 露点[℃]
   */
  public static double calcDewPoint(double temp, double humid){
    if ( humid <= 0 ) return -100;
    if ( 100 <= humid ) return temp;
    if ( temp <= -10 ) return temp;

    final double STEP_TEMP = 0.2;

    // 現時点の水蒸気圧を求める
    double es = calcTetensEs(temp) * humid / 100.0;

    double tmp = temp - STEP_TEMP;
    double dewPoint = -100;
    double tmpEs = 0;

    while(true){
      if ( tmp < 0 ) break;
      tmpEs = calcTetensEs(tmp);
      if ( tmpEs < es ) {
        dewPoint = tmp;
        break;
      }
      tmp -= STEP_TEMP;
    }

    return dewPoint;
  }


}
