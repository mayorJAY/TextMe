package com.example.josycom.textme;

import android.content.Context;

/**
 * This class is used to abstract the data from the MainActivity
 */
class TextRepository {
    private TextFile mTextFile;

    TextRepository(Context context, String filename){
        mTextFile = new TextFile(context, filename);
    }

    void setContent(String fileContent) {
        mTextFile.setContent(fileContent);
    }

    String getContent(){
        return mTextFile.getContent();
    }
}