package diDeTr;

/**
 * Created by kucerj28@fjfi.cvut.cz on 10/5/13.
 */
public class Utils {
    /**
     * From int[] creates String of it's values separated by comas (no spaces)
     * @param arr
     * @return
     */
      public static String printIntArrayAsCSV(int[] arr){
          String str = "";

          for (int i: arr) {
              str = str + i + ",";
          }
          str = str + "e";
          str = str.replace(",e","");
          return str;
      }
}
