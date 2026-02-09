#!/bin/bash

cd "$(dirname "$0")"

mkdir -p out
javac -d out *.java
java -cp out Creational.Prototype.Main
