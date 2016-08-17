import java.io.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.*;
import org.apache.hadoop.mapreduce.lib.output.*;

public class BookExample
{
  public static void main(String args[]) throws Exception
  {
    Job job = new Job();
    job.setJarByClass(BookExample.class);
    job.setJobName("Book Example");

    FileInputFormat.addInputPath(job, new Path("./data"));
    FileOutputFormat.setOutputPath(job, new Path("./output"));

    job.setMapperClass(BookMapper.class);
    job.setReducerClass(BookReducer.class);

    job.setOutputKeyClass(IntWritable.class);
    job.setOutputValueClass(Text.class);

    System.exit(job.waitForCompletion(true /* verbose */) ? 0 : 1);
  }
}
