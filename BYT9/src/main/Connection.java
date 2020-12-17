package main;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Connection implements Serializable {
    private String url;
    private URL address ;
    private URLConnection connection;
    private Date modifiedtime;

    private List<IObserver> observerList= new ArrayList<>();


    public Connection(String url){
        this.url=url;
    }

    public void register(Observer ob){
        if(!observerList.contains(ob)){
            observerList.add(ob);
        }else{
            System.out.println("Already registered!");
        }

    }
    public void unregister(Observer ob){
        observerList.remove(ob);
    }

    public void createConnection(){
        try {
            address = new URL(url);
            connection = address.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
        for (IObserver ob : this.observerList) {

            if (ob.getTime() == null) {

                ob.update(modifiedtime);
            }
            if (ob.getTime().compareTo(modifiedtime) < 0) {

                ob.update(modifiedtime);
            }
        }
    }


    public long getModifiedtime() {
        return this.connection.getLastModified();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Connection)) return false;
        Connection that = (Connection) o;
        return Objects.equals(url, that.url) &&
                Objects.equals(connection, that.connection) &&
                Objects.equals(modifiedtime, that.modifiedtime) &&
                Objects.equals(observerList, that.observerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, connection, modifiedtime, observerList);
    }
}
