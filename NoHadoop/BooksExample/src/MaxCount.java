import java.io.*;
import java.util.*;

public class MaxCount
{
  public static void main(String[] args) throws Exception
  {
    Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
    File dir = new File("./data");
    for (File f : dir.listFiles())
    {
      if (f.getName().endsWith(".csv"))
      {
        System.out.println("Reading " + f.getName());
        Scanner in = new Scanner(f);
        while (in.hasNextLine())
        {
          String tokens[] = in.nextLine().split("\t");
          String ngram = tokens[0];
          int count = Integer.parseInt(tokens[4]);
          if (!map.containsKey(count))
            map.put(count, new ArrayList<String>());
          map.get(count).add(ngram);
        }
      }
    }
    FileWriter out = new FileWriter("out.txt");
    for (int key : map.keySet())
      out.write(String.format("%s->%s%n", key, map.get(key)));
    out.close();
  }
}
