package com.sviatlana.infohandling.model;

import java.util.Iterator;

public interface IComponent {

    IComponent getComponent(int i);
    void setEntity(IComponent entity);
    void add(IComponent value);
    void remove(IComponent value);

    Iterator<IComponent> getIterator();

}
