package com.example.josycom.textme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextRepository mTextRepository;
    private TextView mTextView;
    private EditText mEditText;
    private String mFileContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button saveButton = findViewById(R.id.buttonSave);
        final Button viewButton = findViewById(R.id.buttonView);
        mTextView = findViewById(R.id.textView);
        mEditText = findViewById(R.id.editText);
        String filename = "my_file.txt";
        mTextRepository = new TextRepository(getApplicationContext(), filename);

        //Gets the types String from the EditText, puts it into a file and saves the file
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFileContent = mEditText.getText().toString();
                if (!mFileContent.isEmpty()) {
                    mTextRepository.setContent(mFileContent);
                    mEditText.setText("");
                    mTextView.setText("");
                    Toast.makeText(getApplicationContext(), "File saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Type in a word", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Reads the content of the file and displays it
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = getContent();
                if (!content.isEmpty()){
                    mTextView.setText(content);
                } else {
                    Toast.makeText(getApplicationContext(), "No file saved", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public String getContent() {
        return mTextRepository.getContent();
    }
}
