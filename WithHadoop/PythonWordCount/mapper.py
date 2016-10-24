#!/usr/bin/env python

# example take from:
# http://www.michael-noll.com/tutorials/writing-an-hadoop-mapreduce-program-in-python/
# example runs without hadoop
# echo "a b c d e" | ./mapper.py
# echo "a b c d e" | ./mapper.py | sort -k1
# echo "a b c d e" | ./mapper.py | sort -k1 | ./reducer.py
# cat data/4300-0.txt  | ./mapper.py | sort -k1 | ./reducer.py

import sys

# input comes from STDIN (standard input)
for line in sys.stdin:
    # remove leading and trailing whitespace
    line = line.strip()
    # split the line into words
    words = line.split()
    # increase counters
    for word in words:
        # write the results to STDOUT (standard output);
        # what we output here will be the input for the
        # Reduce step, i.e. the input for reducer.py
        #
        # tab-delimited; the trivial word count is 1
        print '%s\t%s' % (word, 1)
