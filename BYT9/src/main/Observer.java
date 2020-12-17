package main;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Observer implements IObserver , Serializable {

    private String url;
    private Date time;

    public Observer(String url){
        this.url=url;

    }
    public void update(Date modificationTime) {

        time = modificationTime;
        System.out.println("URL : " + url + " has been modified in time " + time );

    }

    public String getUrl() {
        return url;
    }

    public Date getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Observer)) return false;
        Observer observer = (Observer) o;
        return Objects.equals(url, observer.url) &&
                Objects.equals(time, observer.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, time);
    }
}
