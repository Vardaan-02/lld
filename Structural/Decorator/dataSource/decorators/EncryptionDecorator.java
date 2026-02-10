package Structural.Decorator.dataSource.decorators;

import Structural.Decorator.dataSource.DataSource;

public class EncryptionDecorator extends DataSourceDecorator{
    public EncryptionDecorator(DataSource dataSource){
        super(dataSource);
    }

    public void write(String data){
        String encrypted = "ENCRYPTED(" + data + ")";
        super.write(encrypted);
    }

    public String read(){
        String data = super.read();
        return data.replace("ENCRYPTED(", "").replace(")", "");
    }
}
