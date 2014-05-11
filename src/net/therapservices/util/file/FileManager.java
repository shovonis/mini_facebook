package net.therapservices.util.file;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: rifatul.islam
 * Date: 4/28/14
 * Time: 12:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileManager {

    public static void getBlobFromImage(String filePath) {

        try {
            BufferedImage imm = ImageIO.read(new File(filePath));
            ByteArrayOutputStream imageByteArray = new ByteArrayOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
