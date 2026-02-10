package Structural.Decorator;

import Structural.Decorator.dataSource.DataSource;
import Structural.Decorator.dataSource.decorators.CompressionDecorator;
import Structural.Decorator.dataSource.decorators.EncryptionDecorator;
import Structural.Decorator.dataSource.impl.FileDataSource;

public class Main {
    public static void main(String args[]){
        DataSource dataSource = new EncryptionDecorator(new CompressionDecorator(new FileDataSource()));

        dataSource.write("HELLO WORLD");

        System.out.println(dataSource.read());
    }
}
