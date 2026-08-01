package bf22.intermediary;

import java.io.File;
import java.io.FilenameFilter;

class C0205 implements FilenameFilter {
   final bf22.intermediary.C0200 GR;
   C0205(C0200 c0200) {
      this.GR = c0200;
   }

   @Override
   public boolean accept(File file, String string) {
      return string.toLowerCase().endsWith(".s22");
   }
}
