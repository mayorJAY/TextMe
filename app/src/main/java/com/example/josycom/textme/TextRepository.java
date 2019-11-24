package com.example.josycom.textme;

import android.content.Context;

/**
 * This class is used to abstract the data from the MainActivity
 */
public class TextRepository {
    private String mContent;

    TextRepository(Context context, String filename, String fileContent){
        TextFile mTextFile = new TextFile(context, filename, fileContent);
        mContent = mTextFile.getContent();
    }

    String getContent(){
        return mContent;
    }
}