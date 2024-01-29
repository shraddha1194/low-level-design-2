package org.lld.designPatterns.structural.decorator.datasource;

import lombok.AllArgsConstructor;

//  Step 3 - base decorator
@AllArgsConstructor
public abstract class BaseDecorator implements Datasource {
    protected Datasource nextLayer;
}
