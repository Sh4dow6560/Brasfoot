package bf22.intermediary;

import mod.recovered.geo.CountryInfo;
import java.util.Comparator;

class C0733 implements Comparator<CountryInfo> {
   public int compare(CountryInfo c0697, CountryInfo c06972) {
      String var3 = c0697.jF();
      String var4 = c06972.jF();
      return !var3.equals(var4) ? var3.compareTo(var4) : 0;
   }
}
