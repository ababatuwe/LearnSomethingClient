package com.example.hreeels.learnsomethingclient;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    // Constants
    private Typeface APP_FONT_REGULAR;
    private Typeface APP_FONT_FIELDS;

    // GUI Elements
    TextView iAppTitleText;
    TextView iUsernameText;
    TextView iPasswordText;
    EditText iUsernameField;
    EditText iPasswordField;
    Button iLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeActivity(getResources().getString(R.string.app_name));
    }

    public void initializeActivity(String aTitle) {
        APP_FONT_REGULAR = Typeface.createFromAsset(getAssets(), "bebas_neue_regular.ttf");
        APP_FONT_FIELDS = Typeface.createFromAsset(getAssets(), "Lato-Regular.ttf");

        initializeViewComponents();
        decorateComponents();

        update(aTitle);
    }

    public void initializeViewComponents() {
        iAppTitleText = (TextView) findViewById(R.id.login_app_title);
        iUsernameText = (TextView) findViewById(R.id.login_username_text);
        iPasswordText = (TextView) findViewById(R.id.login_password_text);
        iUsernameField = (EditText) findViewById(R.id.login_username_field);
        iPasswordField = (EditText) findViewById(R.id.login_password_field);
        iLoginButton = (Button) findViewById(R.id.login_login_button);
    }

    public void decorateComponents() {
        iAppTitleText.setTypeface(APP_FONT_REGULAR);
        iUsernameText.setTypeface(APP_FONT_REGULAR);
        iPasswordText.setTypeface(APP_FONT_REGULAR);
        iUsernameField.setTypeface(APP_FONT_FIELDS);
        iPasswordField.setTypeface(APP_FONT_FIELDS);
        iLoginButton.setTypeface(APP_FONT_REGULAR);
    }

    /**
     * Update the view's components.
     *
     * @param aTitleText The title of the app
     */
    public void update(String aTitleText) {
        iAppTitleText.setText(aTitleText);
    }

    public String getUsername() {
        return iUsernameField.getText().toString();
    }

    public String getPassword() {
        return iPasswordField.getText().toString();
    }
}
