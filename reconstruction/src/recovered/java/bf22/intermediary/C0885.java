package bf22.intermediary;

import java.io.File;
import java.io.FilenameFilter;

class C0885 implements FilenameFilter {
   @Override
   public boolean accept(File file, String string) {
      return string.toLowerCase().endsWith(".ban");
   }
}
