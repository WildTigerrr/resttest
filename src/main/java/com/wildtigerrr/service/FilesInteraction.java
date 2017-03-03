package com.wildtigerrr.service;

import com.wildtigerrr.config.Variables;

import java.io.*;

public class FilesInteraction {

    public static String toUTF(String str) {
        String someUTF;
        try {
            someUTF = new String(str.getBytes("windows-1251"), "UTF-8");
            return someUTF;
        } catch (UnsupportedEncodingException e) {
            return "Failed to encode.";
        } catch (NullPointerException e) {
            return "Here is NullPointerException";
        }
    }

    public static String getFileInString(String str) {
        String adress = Variables.getPath() + str;
        File headFile = new File(adress);
        try{
            FileReader reader = new FileReader(headFile);
            char[] buffer = new char[(int)headFile.length()];
            reader.read(buffer);
            String headStr = new String(buffer);
            reader.close();
            return headStr;
        }
        catch (IOException e){return "Failed " + e;}

    }

    public static String create(String str) {

        File file = new File(Variables.getPath() + str);

        try {
            if(!file.exists()){
                file.createNewFile();
            }

            return "";

        } catch(IOException e) {
            return "On " + Variables.getPath() + " failed to create " + e;
        }
    }

    public static String write(String str, String text){
        File file = new File(Variables.getPath() + str);
        PrintWriter out;
        try {
            out = new PrintWriter(file.getAbsoluteFile());
            try {
                out.print(text);
                return "";
            } finally {
                out.close();
            }
        } catch (FileNotFoundException e) {
            return "Failed to write in file " + e;
        }

    }

}
