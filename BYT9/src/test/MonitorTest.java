import Memento.Originator;
import main.Connection;
import main.Monitor;
import main.Observer;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import java.net.URLConnection;
import java.util.Date;

import static org.junit.Assert.*;

public class MonitorTest {



    private String URL1 = "http://www.pja.edu.pl/";
    private String URL2 = "https://www.squarespace.com/";
    private String URL3 = "http://www.youtube.com/";
    private Monitor monitor = new Monitor();
    private Observer observer1 = new Observer(URL1);
    private Observer observer2 = new Observer(URL2);
    private Observer observer3 = new Observer(URL3);

    public Connection connection1= new Connection(URL1);
    public Connection connection2= new Connection(URL2);
    public Connection connection3= new Connection(URL3);
    Date date = new Date();

    @Test
    public void register() {

        connection1.register(observer1);
        connection2.register(observer2);
        connection3.register(observer3);
        monitor.addConnection(connection1);
        monitor.addConnection(connection2);
        monitor.addConnection(connection3);
        assertEquals(3,monitor.size());
    }

    @Test
    public void monitor() {
        register();
        //monitor.monitor();
        URLConnection urlconnection1 = Mockito.mock(URLConnection.class);

        when(urlconnection1.getLastModified()).thenReturn(date.getTime());
        connection1.setModifiedtime(new Date(urlconnection1.getLastModified()));

        assertEquals(observer1.getTime(),date);
    }
}