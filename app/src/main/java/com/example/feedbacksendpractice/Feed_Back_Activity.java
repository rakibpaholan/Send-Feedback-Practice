package com.example.feedbacksendpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feed_Back_Activity extends AppCompatActivity implements View.OnClickListener {
    private EditText name,massage;
    private Button send,clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed__back_);

        name = (EditText)findViewById(R.id.edit_text_id);
        massage = (EditText)findViewById(R.id.edit_text_id_massage);

        send = (Button)findViewById(R.id.send_button_id);
        clear = (Button)findViewById(R.id.clear_id);

        send.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {
            String user_name = name.getText().toString();
            String user_text = massage.getText().toString();

            if (view.getId()==R.id.send_button_id){
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");
                intent.putExtra(Intent.EXTRA_EMAIL,new String [] {"rakibpaholan9999@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT,"FeedBack Opertunatiy");
                intent.putExtra(Intent.EXTRA_TEXT,"Name : "+user_name+"\n Massage : " + user_text);
                startActivity(Intent.createChooser(intent,"Feedback With mail"));
            }
            else if (view.getId()==R.id.clear_id){
                name.setText("");
                massage.setText("");
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Exception :"+e,Toast.LENGTH_SHORT).show();
        }
    }
}