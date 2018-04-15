package com.muntian.ht68_first_client_server.inet;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        /*try {

            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println(inetAddress.toString());

            inetAddress = InetAddress.getByName("itstep.org");
            System.out.println(inetAddress.toString());

            byte[] ip = inetAddress.getAddress();

            System.out.println("IP Address: " +
                    (0xff & (int)ip[0]) + "." +
                    (0xff & (int)ip[1]) + "." +
                    (0xff & (int)ip[2]) + "." +
                    (0xff & (int)ip[3]));

            //inetAddress = InetAddress.getByAddress(ip);

            System.out.println(inetAddress.getHostName());
            System.out.println(inetAddress.getHostAddress());

            URL URL = new URL("https://www.google.com.ua/search?q=http&rlz=1C1CHBF_ruUA784UA784&oq=http&aqs=chrome..69i60l3j69i65l2j69i57.2041j0j7&sourceid=chrome&ie=UTF-8");

            URI URI = new URI(URLDecoder.decode(URLDecoder.decode("google.com.ua", "UTF-8"), "UTF-8"));

            System.out.println(URI.isOpaque());

            System.out.println(URLDecoder.decode(URLDecoder.decode("%253D%25D0%2590%25D0%25BB%25D0%25B5%25D0%25BA%25D1%2581%25D0%25B0%25D0%25BD%25D0%25B4%25D1%2580%2526lastname%253D%25D0%259B%25D0%25B5%25D0%25BC%25D1%258F%25D0%25B3%25D0%25BE%25D0%25B2", "UTF-8"), "UTF-8"));

            System.out.println(URL.toString());

            printUriInfo(URI.create("mailto:a@b.com"));
            printUriInfo(URI.create("http://example.com"));
            printUriInfo(URI.create("http://example.com/path"));
            printUriInfo(URI.create("scheme://example.com"));
            printUriInfo(URI.create("scheme:example.com"));
            printUriInfo(URI.create("scheme:example.com/path"));
            printUriInfo(URI.create("path"));
            printUriInfo(URI.create("/path"));

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        HttpURLConnection urlConnection = null;

        try {

            URL url = new URL("http://www.android.com/");

            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setDoOutput(true);
            urlConnection.setChunkedStreamingMode(0);

            OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
            //writeStream(out);

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            //readStream(in);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(urlConnection!=null) {
                urlConnection.disconnect();
            }
        }

    }

    private static void printUriInfo(URI uri) {
        System.out.println(String.format("Uri [%s]", uri));
        System.out.println(String.format(" scheme specific part [%s]", uri.getSchemeSpecificPart()));
        System.out.println(String.format(" is %sopaque", uri.isOpaque() ? "" : "not "));
        System.out.println(String.format(" is %sabsolute", uri.isAbsolute() ? "" : "not "));
        System.out.println(String.format(" Path [%s]", uri.getPath()));
    }

}
