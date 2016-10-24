#!/usr/bin/env bash
rm -rf output
hadoop jar \
/home/mclacsdev/Development/hadoop-2.7.2/share/hadoop/tools/lib/hadoop-streaming-2.7.2.jar \
-mapper mapper.py -reducer reducer.py \
-input data/4300-0.txt -output ./output
