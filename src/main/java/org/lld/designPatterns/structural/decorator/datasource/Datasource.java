package org.lld.designPatterns.structural.decorator.datasource;

//  Step 1 - create a product interface
public interface Datasource {

    String read();

    void write(String value);
}
