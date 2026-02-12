package Structural.Composite.fileSystem;

public interface FileSystemNode {
    public String getName();
    public int getSize();

    public void print(String indent);
    default public void print(){
        print("");
    }
}
