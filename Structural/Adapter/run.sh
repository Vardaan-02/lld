#!/bin/bash

set -e

ROOT_DIR="$(pwd)"
OUT_DIR="$ROOT_DIR/out"

rm -rf "$OUT_DIR"
mkdir -p "$OUT_DIR"

javac -d "$OUT_DIR" $(find "$ROOT_DIR" -name "*.java")
java -cp "$OUT_DIR" Structural.Adapter.Main
