package Structural.Decorator.dataSource.decorators;

import Structural.Decorator.dataSource.DataSource;

public abstract class DataSourceDecorator implements DataSource{
    private DataSource dataSource;

    public DataSourceDecorator(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public void write(String data){
        dataSource.write(data);
    }

    public String read(){
        return dataSource.read();
    }
}
