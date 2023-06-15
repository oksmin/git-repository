package com.java.servlet.scheduler;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
 
public class Test01 {
    public static void main(String[] args) {
        BufferedReader in = null;
 
        try {
            URL obj = new URL("http://localhost:9000/project/api/member?opKey=123"); // 호출할 url
            HttpURLConnection con = (HttpURLConnection)obj.openConnection();
            //con.setRequestProperty("opKey", "123");
            
            con.setRequestMethod("POST");
 
            in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
        
            String line;
            while((line = in.readLine()) != null) { // response를 차례대로 출력
                System.out.println(line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(in != null) try { in.close(); } catch(Exception e) { e.printStackTrace(); }
        }
    }
}