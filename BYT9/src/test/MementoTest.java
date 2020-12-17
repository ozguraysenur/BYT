import Memento.Originator;
import main.Connection;
import main.Monitor;
import main.Observer;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class MementoTest {


    Monitor monitor =new Monitor();
    private String URL1 = "http://www.pja.edu.pl/";
    private Observer observer1 = new Observer(URL1);
    public Connection connection1= new Connection(URL1);
    File file = new File("./file.txt");
    @Before
    public void setUp() throws Exception {
        connection1.register(observer1);
        monitor.addConnection(connection1);
    }

    @Test
    public void testMemento(){

        Originator originator =new Originator();
        originator.storeInMemento(monitor.getconnectionList());
        assertTrue(file.length()!=0);
        assertTrue(file.exists());

    }
}