package maven_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class HttpGet {

	
	public static ArrayList<String> HttpGet(String url_request) {
        try {
            //Create connection
            URL url = new URL(url_request);
            URLConnection url_connection = url.openConnection();
            //Get Response
            BufferedReader rd = new BufferedReader(new InputStreamReader(url_connection.getInputStream()));
            String line;
            //Read line by line
            ArrayList<String> list = new ArrayList();
            while ((line = rd.readLine()) != null) {
                list.add(line);
            }
            rd.close();
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
