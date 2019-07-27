package com.hunter_brown.myplacesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PlaceCreateActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mSubmitButton;
    private EditText mEditName;
    private EditText mEditDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_create);
        setTitle(R.string.create_title);
        mSubmitButton= (Button) findViewById(R.id.submit_button);
        mSubmitButton.setOnClickListener(this);

        mEditName=(EditText) findViewById(R.id.place_name_edit_text);
        mEditDesc=(EditText) findViewById(R.id.place_description_edit_text);

    }

    @Override
    public void onClick(View view) {
        String name = mEditName.getText().toString();
        String descripton= mEditDesc.getText().toString();

        Intent resultData= new Intent();
        resultData.putExtra("place_name",name);
        resultData.putExtra("place_description", descripton);

        setResult(RESULT_OK,resultData);
        finish();
    }
}
