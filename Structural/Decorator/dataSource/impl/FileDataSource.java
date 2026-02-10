package Structural.Decorator.dataSource.impl;

import Structural.Decorator.dataSource.DataSource;

public class FileDataSource implements DataSource{
    String data;

    public void write(String data){
        this.data = data;
    }

    public String read(){
        return this.data;
    }
}
