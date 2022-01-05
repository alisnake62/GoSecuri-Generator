package maven_test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class HttpGet {

	
	public static ArrayList<String> HttpGet(String file_name) {
		try {
            //Get Response
            BufferedReader rd = new BufferedReader(new FileReader("/var/lib/jenkins/workspace/GoSecuti_html_maj/all_txt/" + file_name));
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
