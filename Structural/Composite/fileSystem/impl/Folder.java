package Structural.Composite.fileSystem.impl;

import java.util.ArrayList;
import java.util.List;

import Structural.Composite.fileSystem.FileSystemNode;

public class Folder implements FileSystemNode{
    String name;
    private List<FileSystemNode> children = new ArrayList<>();

    public Folder(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void add(FileSystemNode node){
        children.add(node);
    }

    public void remove(FileSystemNode node){
        children.remove(node);
    }

    public int getSize(){
        int ans = 0;
        for (FileSystemNode node : children){
            ans += node.getSize();
        }
        return ans;
    }

    public void print(String indent){
        System.out.println(indent + this.name + "/");
        for (FileSystemNode node : children){
            node.print(indent + "   ");
        }
    }
}
