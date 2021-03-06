package cona.pi;

import java.io.IOException;
import java.util.Properties;

/* A basic Kafka cona.pi.Producer that reads sensor data and sends to
* Kafka Broker*/
public class Main {
    static Properties props;

    public static void main(String[] args) throws IOException {
        readProps();
        Ping ping = new Ping(
                props.getProperty("rangefinder-topic"),
                props.getProperty("ip"),
                props.getProperty("rangefinderSensorID"),
                true,
                props.getProperty("USBdevice"));
        /*
        Button button = new Button(
                props.getProperty("button-topic"),
                props.getProperty("ip"),
                props.getProperty("buttonSensorID"),
                true);
         */
        ping.start();
        //button.start();

    }

    public static void readProps() throws java.io.IOException {
        props = new Properties();
        props.load(Main.class.getClassLoader().getResourceAsStream("config.properties"));
    }
}