import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

/*
  The four template paramters are:
    Input Key - which is a long integer offset
    Input Value - which is a line of text from the file
    Output Key - which is the # of books a word appears in
    Output Value - which is the word (ngram)
*/
public class BookMapper extends Mapper<LongWritable, Text, IntWritable, Text>
{
  @Override
  public void map(LongWritable key, Text value, Context context)
    throws IOException, InterruptedException
  {
    String line = value.toString();
    String tokens[] = line.split("\t");
    String ngram = tokens[0];
    int count = Integer.parseInt(tokens[4]);
    context.write(new IntWritable(count), new Text(ngram));
  }
}
