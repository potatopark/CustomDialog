package com.example.user.a7_customdialogexam;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener{

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                showLoginDialog();
                break;
        }
    }

    public void showLoginDialog(){
        LayoutInflater inflater = getLayoutInflater();
        final View loginView = inflater.inflate(R.layout.dialog,null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("로그인");
        builder.setCancelable(false);
        builder.setView(loginView);

        builder.setNegativeButton("CANCEL",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplication(), "CANCEL 버튼 눌러짐", Toast.LENGTH_SHORT).show();
                    }
                });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText editText1 = (EditText) loginView.findViewById(R.id.editText1);
                EditText editText2 = (EditText) loginView.findViewById(R.id.editText2);
                String user_id = editText1.getText().toString().trim();
                String user_pw = editText2.getText().toString().trim();

                Toast.makeText(getApplication(),"아이디 : " + user_id + " / 비밀번호 : " +
                user_pw, Toast.LENGTH_LONG).show();
            }
       });
        builder.create();
        builder.show();
    }
}
