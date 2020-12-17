package Memento;

import main.Connection;
import main.Monitor;

import java.io.Serializable;
import java.util.List;

public class Memento implements Serializable {
    private List<Connection> connections;
    public Memento(List<Connection> connections){
        this.connections=connections;
    }
    public List<Connection> getSavedMonitor(){
        return connections;
    }
}
