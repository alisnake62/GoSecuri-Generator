package maven_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
        String url_staff = "https://raw.githubusercontent.com/alisnake62/GoSecuri-repoGenerator/master/staff.txt";
        ArrayList<String> list = HttpGet.HttpGet();
        System.out.println(list);
        String new_index_html = read_index_html(list);
        System.out.println("index" + new_index_html );
        write_in_new_index_html(new_index_html);
    }

    private static String read_index_html(ArrayList<String> list) throws IOException {
        BufferedReader rd = new BufferedReader(new FileReader("/var/lib/jenkins/workspace/GoSecuri_package/src/main/java/html/index.html"));
        String line;
        String index_html = "";
        while ((line = rd.readLine()) != null) {
            index_html += line;
        }
        rd.close();
        String row_template = "<tr><td>var_name</td><td><a href=var_link>var_name</a></td></tr>";
        String tableau = "";
        for (int i = 0; i < list.size(); i++) {
            String row = row_template;
            row = row.replace("var_name", list.get(i));
            tableau = tableau + row;
        }
        String new_index_html = index_html.replace("var_tableau", tableau);
        return new_index_html;
    }

    private static void write_in_new_index_html(String new_index_html) throws IOException {
        File file = new File("/var/www/html/index.html");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(new_index_html);
        bw.close();
    }

}
