package main;

import java.io.IOException;
import java.util.*;

public class Monitor {

    private static final int PERIOD_MILLISECONDS = 1000;

    private Map<Connection, Set<Observer>> _observers= new HashMap<>();

    private List<Connection> connectionList =new ArrayList<>();

    public List<Connection> getconnectionList(){
        return connectionList;
    }

    public void addConnection(Connection connection){
        if(!connectionList.contains(connection)){
            connectionList.add(connection);
        }else{
            System.out.println("Already monitored!");
        }
    }


        public void monitor(){
            while (true){
                try {
                    Thread.sleep(PERIOD_MILLISECONDS);
                for (Connection con : connectionList){
                    con.createConnection();

                    con.setModifiedtime(new Date(con.getModifiedtime()));
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        public int size(){
            return connectionList.size();
        }
}
