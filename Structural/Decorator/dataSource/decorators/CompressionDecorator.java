package Structural.Decorator.dataSource.decorators;

import Structural.Decorator.dataSource.DataSource;

public class CompressionDecorator extends DataSourceDecorator{
    public CompressionDecorator(DataSource dataSource){
        super(dataSource);
    }

    public void write(String data){
        String compressed = "COMPRESSED(" + data + ")";
        super.write(compressed);
    }

    public String read(){
        String data = super.read();
        return data.replace("COMPRESSED(", "").replace(")", "");
    }
}
