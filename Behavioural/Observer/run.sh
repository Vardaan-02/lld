#!/bin/bash

# stop on error
set -e

# output directory for compiled classes
OUT_DIR="out"

rm -rf $OUT_DIR
mkdir -p $OUT_DIR
javac -d $OUT_DIR $(find . -name "*.java")
java -cp $OUT_DIR Behavioural.Observer.Main
