package com.hunter_brown.myplacesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PlaceEditActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mEditButton;
    private EditText mEditName;
    private EditText mEditDesc;

    private int mPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_edit);
        setTitle(R.string.edit_title);
        mEditButton= (Button) findViewById(R.id.save_button);
        mEditButton.setOnClickListener(this);

        mEditName=(EditText) findViewById(R.id.place_name_edit);
        mEditDesc=(EditText) findViewById(R.id.place_description_edit);

        Intent data = getIntent();
        mEditName.setText(data.getStringExtra("place_name"));
        mEditDesc.setText(data.getStringExtra("place_description"));
        mPosition= data.getIntExtra("place_position", -1);

        if(mPosition == -1){
            //TODO Throw exception
        }

    }

    @Override
    public void onClick(View view) {
        String name = mEditName.getText().toString();
        String descripton= mEditDesc.getText().toString();

        Intent resultData= new Intent();
        resultData.putExtra("place_position",mPosition);
        resultData.putExtra("place_name",name);
        resultData.putExtra("place_description", descripton);

        setResult(RESULT_OK,resultData);
        finish();
    }
}
