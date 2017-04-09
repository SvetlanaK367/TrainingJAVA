package com.sviatlana.infohandling.model;

import java.util.Iterator;

public class LeafPart implements IComponent {

    private String value;

    public LeafPart(String val) { value = val; }

    @Override
    public void add(IComponent value) { }

    @Override
    public void remove(IComponent value) { }

    @Override
    public IComponent getComponent(int i) {
        return null;
    }

    @Override
    public void setEntity(IComponent entity) {
        if(entity == null) {
            this.value = null;
        } else {
            this.value = entity.toString();
        }
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public Iterator<IComponent> getIterator() {
        throw new UnsupportedOperationException();

    }

}
