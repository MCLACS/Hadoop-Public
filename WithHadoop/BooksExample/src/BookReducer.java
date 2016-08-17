import java.io.*;
import java.util.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

/*
  The four template paramters are:
    Input Key - which is the # of books a word appears in
    Input Value -which is the word (ngram)
    Output Key - which is the # of books a collection of words appears in
    Output Value - a collection of all the words
*/
public class BookReducer extends Reducer<IntWritable, Text, IntWritable, Text>
{
  @Override
  public void reduce(IntWritable key, Iterable<Text> values, Context context)
    throws IOException, InterruptedException
  {
    List<String> words = new ArrayList<String>();

    for (Text t : values)
      words.add(t.toString());

    context.write(key, new Text(words.toString()));
  }
}
