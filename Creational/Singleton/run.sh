#!/bin/bash

set -e

OUT_DIR=out

rm -rf $OUT_DIR
mkdir -p $OUT_DIR
javac -d $OUT_DIR *.java
java -cp $OUT_DIR Main