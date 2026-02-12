package Structural.Composite.fileSystem.impl;

import Structural.Composite.fileSystem.FileSystemNode;

public class File implements FileSystemNode{
    String name;
    int size;

    public File(String name, int size){
        this.name = name;
        this.size = size;
    }

    public String getName(){
        return this.name;
    }

    public int getSize(){
        return this.size;
    }

    public void print(String indend){
        System.out.println(indend + this.name + " (" + size + ")");
    }
}
