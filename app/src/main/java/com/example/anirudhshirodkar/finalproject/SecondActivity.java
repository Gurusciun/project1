package com.example.anirudhshirodkar.finalproject;


import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private ImageView imageView;

    private Button button;
    int image2;

    private EditText editText;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Bundle bundle = getIntent().getExtras();

        String text1=bundle.getString("text1");

        String text2=bundle.getString("text2");

        Bitmap bmp = (Bitmap) bundle.getParcelable("imagebitmap");




        button=(Button)findViewById(R.id.button);


        textView1=(TextView)findViewById(R.id.text1);

        textView2=(TextView)findViewById(R.id.text2);

        imageView=(ImageView)findViewById(R.id.imageView);

        editText=(EditText)findViewById(R.id.editText);

        String value=editText.getText().toString();



        textView1.setText(text1);
        textView2.setText(text2);

        imageView.setImageBitmap(bmp);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(SecondActivity.this,editText.getText().toString(),Toast.LENGTH_SHORT).show();

                onBackPressed();

            }
        });

    }
}