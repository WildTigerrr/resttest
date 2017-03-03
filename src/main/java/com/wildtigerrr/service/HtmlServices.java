package com.wildtigerrr.service;

public class HtmlServices {

    public static String redir(String url){
        String redir = "<html><head><meta content='0; url=" +
                url + "' http-equiv='Refresh'/></head></html>";
        return redir;
    }

    public static String htmlWrap(String body){
        String head = "<html>\n" +
                "<head>\n" +
                "    <link>\n" +
                "    <meta charset='utf-8'>\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <title>RESTful pj</title>\n" +
                "    \n" +
                "</head>\n"
                + "<body>";
        String bottom = "</body>\n" +
                "</html>";

        return head + body + bottom;
    }

}
