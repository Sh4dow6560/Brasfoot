package bf22.intermediary;

import java.io.File;
import java.io.FilenameFilter;

class C0891 implements FilenameFilter {
   @Override
   public boolean accept(File file, String string) {
      return string.toLowerCase().endsWith(".xml");
   }
}
