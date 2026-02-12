#!/bin/bash

mkdir -p out

javac -d out $(find . -name "*.java")
java -cp out Structural.Bridge.Main
