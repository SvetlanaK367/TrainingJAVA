package com.sviatlana.xml.model;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OldCards {

    @XmlElement(name = "card")
    private ArrayList<OldCard> list = new ArrayList<OldCard>();

    public OldCards() {
        super();
    }

    public void setList(ArrayList<OldCard> list) {
        this.list = list;
    }

    public boolean add(OldCard st) {
        return list.add(st);
    }

    @Override
    public String toString() {
        return "OldCards [list=" + list + "]";
    }
    
}







