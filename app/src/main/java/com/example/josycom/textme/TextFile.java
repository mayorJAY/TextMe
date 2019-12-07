package com.example.josycom.textme;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class TextFile {
    private File file;

    //Creates the file
    TextFile(Context context, String filename){
        file = new File(context.getFilesDir(), filename);
    }

    //Writes the content
    void setContent(String fileContent) {
        try{
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(fileContent.getBytes());
            outputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //Reads the file and gets the content
    String getContent(){
        String contentToString = "";
            try {
                FileInputStream inputStream = new FileInputStream(file);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                contentToString = bufferedReader.readLine();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return contentToString;
    }
}