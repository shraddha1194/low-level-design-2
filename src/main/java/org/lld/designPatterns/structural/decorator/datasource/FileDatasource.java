package org.lld.designPatterns.structural.decorator.datasource;

// Step 2 - create product class
public class FileDatasource implements Datasource{
    @Override
    public String read() {
        return "Base";
    }

    @Override
    public void write(String value) {
        System.out.println(value);
    }
}
