package Memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
     private List<Memento> savedMonitors= new ArrayList<>();

    public void addMemento(Memento m){
        savedMonitors.add(m);
    }
    public Memento getMemento(int index){
        return savedMonitors.get(index);
    }

    public List<Memento> getSavedMonitors() {
        return savedMonitors;
    }
}
