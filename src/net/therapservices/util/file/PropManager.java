package net.therapservices.util.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: rifatul.islam
 * Date: 4/27/14
 * Time: 12:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class PropManager {

    public static Properties loadProperties(String fileUrl) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileUrl);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        fileInputStream.close();
        return properties;
    }
}
