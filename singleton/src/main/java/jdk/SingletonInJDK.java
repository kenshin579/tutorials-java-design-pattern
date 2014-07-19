package jdk;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

public class SingletonInJDK {
    public static void main(String[] args) {
        //1. getRunTime
        try {
            Process p = Runtime.getRuntime().exec("whoami");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2.getLocalGraphicsEnvironment
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        GraphicsConfiguration[] configurations = defaultScreen.getConfigurations();
        System.out.println("Default screen device: " + defaultScreen.getIDstring());
        for (int i = 0; i < configurations.length; i++) {
            System.out.println("  Configuration " + (i + 1));
            System.out.println("  " + configurations[i].getColorModel());
        }

        //3.getDesktop
        try {
            URI uri = new URI("http://www.java2s.com");
            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }

            if (desktop != null)
                desktop.browse(uri);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (URISyntaxException use) {
            use.printStackTrace();
        }


    }
}
