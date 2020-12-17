package main;

import java.util.Date;

public interface IObserver {
    void update(Date modificationTime);
    Date getTime();
}
