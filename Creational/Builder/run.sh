#!/bin/bash

rm -rf out
javac -d out $(find . -name "*.java")
java -cp out Creational.Builder.Main