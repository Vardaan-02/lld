#!/bin/bash

# create output directory
mkdir -p out

# compile all java files
javac -d out $(find . -name "*.java")

# run main class
java -cp out Behavioural.Memento.Main
