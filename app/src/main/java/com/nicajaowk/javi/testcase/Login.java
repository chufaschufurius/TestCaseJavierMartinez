package com.nicajaowk.javi.testcase;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class Login extends Activity {

    public Login() {
        super();
    }

    private TextView lblGotoRegister;
    private Button btnLogin;
    private EditText inputEmail;
    private EditText inputPassword;
    private TextView loginErrorMsg;

    String[] usuarios = {"javi", "juan", "jorge"};
    String[] password = {"javiPass", "juanPass", "jorgePass"};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEmail = (EditText) findViewById(R.id.txtEmail);
        inputPassword = (EditText) findViewById(R.id.txtPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
//        loginErrorMsg = (TextView) findViewById(R.id.login_error);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            login();
            }
        });
    }
    public boolean login(){
        String email = inputEmail.getText().toString();
        String pass = inputPassword.getText().toString();
        boolean bienLogueado=false;
        if (Arrays.asList(usuarios).contains(email)) {
            int userIndex = Arrays.asList(usuarios).indexOf(email);
            if ((password[userIndex]).equals(pass)) {
//                        String[] u={email,pass};
                Toast toast = Toast.makeText(getApplicationContext(), "Bienvenido " + email, Toast.LENGTH_LONG);
                toast.show();
                bienLogueado=true;
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "Error, password incorrect ", Toast.LENGTH_LONG);
                toast.show();
            }
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Error, user not exists ", Toast.LENGTH_LONG);
            toast.show();
        }
        return bienLogueado;
    }
}