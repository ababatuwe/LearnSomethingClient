package com.example.hreeels.learnsomethingclient;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hreeels.learnsomethingclient.server.ServerInterface;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends ActionBarActivity implements ServerInterface {

    // Constants
    private static final String SERVICE_URL = "http://172.17.41.180:8080/com.comp3601.rest/rest/person/sample";
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
        activateActionListeners();

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
     * Activates all the action listeners for this activity.
     */
    public void activateActionListeners() {
        iLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginButtonOnClick();
            }
        });
    }

    /**
     * Deactivates all the action listeners for this activity.
     */
    public void deActivateActionListeners() {
        iLoginButton.setOnClickListener(null);
    }

    /**
     * On click listener for the login button.
     */
    public void loginButtonOnClick() {
        String lUsername = getUsername();
        String lPassword = getPassword();

        if(lUsername.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter a username.",
                    Toast.LENGTH_LONG).show();
        }

        if(lPassword.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter a password.",
                    Toast.LENGTH_LONG).show();
        }

        if (!(lUsername.isEmpty()) && !(lPassword.isEmpty())) {
            validateUserLogin(getUsername(),
                    getPassword());
        }
    }

    /**
     * Sends a request to the server to authenticate the user's login credentials.
     *
     * @param aUsername the username to be validated
     * @param aPassword the password to be validated
     */
    public void validateUserLogin(String aUsername, String aPassword) {
       // String lRequestURL = SERVICE_URL + "/" + aUsername + "/" + aPassword;

        LearnSomethingServer lServer = new LearnSomethingServer(LearnSomethingServer.GET_TASK,
                this, "Validating User Credentials", this);

        lServer.execute(new String[]{SERVICE_URL});
    }

    /**
     * Handles the response once the LearnSomethingServer class is done
     * executing.
     *
     * @param aResponse the response from the server
     */
    public void handleResponse(String aResponse) {
        try{
            JSONObject lJson = new JSONObject(aResponse);

            Toast.makeText(this, "Response Received...", Toast.LENGTH_LONG).show();

            System.out.println("HERE IS THE RESPONSE:\n" + lJson);
        } catch(JSONException e) {
            e.printStackTrace();
        }
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
