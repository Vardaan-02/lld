#!/bin/bash
set -e

OUT_DIR=out

rm -rf $OUT_DIR
mkdir -p $OUT_DIR

# compile all java files recursively
javac -d $OUT_DIR $(find . -name "*.java")

# run using package-qualified main class
java -cp $OUT_DIR Behavioural.Strategy.Main
