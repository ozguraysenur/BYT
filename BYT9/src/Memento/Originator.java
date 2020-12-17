package Memento;

import main.Connection;
import main.Monitor;

import java.io.*;
import java.util.List;

public class Originator {
    private List<Connection> con;
    Caretaker caretaker=new Caretaker();


    public void storeInMemento(List<Connection> con){

        caretaker.addMemento(new Memento(con));
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("./file.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(caretaker.getSavedMonitors());
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
