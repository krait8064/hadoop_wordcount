package hadoop.simple.word_count;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * 日期：2017/9/19 created by：17
 * email：krait8064@163.com
 */

public class WCReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    private IntWritable result = new IntWritable();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int count = 0;
        for (IntWritable intWritable : values) {
            count += intWritable.get();
        }
        result.set(count);
        context.write(key, result);
    }
}