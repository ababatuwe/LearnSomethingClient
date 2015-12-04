package com.example.hreeels.learnsomethingclient;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hreeels.learnsomethingclient.model.Instructor;
import com.example.hreeels.learnsomethingclient.model.Skill;
import com.example.hreeels.learnsomethingclient.utils.SkillAdapter;

import java.util.ArrayList;
import java.util.List;


public class ProfileActivity extends ActionBarActivity {

    private TextView iFullNameView;
    private TextView iSkillHeader;
    private ListView iListView;

    private Instructor iInstructorDetails;

    private Typeface iCustomFont;
    private Typeface iCustomFontBold;
    private Typeface iCustomFontSmall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        iInstructorDetails = getIntent().getParcelableExtra("userInfo");

        setupActivity(iInstructorDetails);
    }

    public void setupActivity(Instructor aInstructor) {
        iCustomFont = Typeface.createFromAsset(getAssets(), "bebas_neue_regular.ttf");
        iCustomFontBold = Typeface.createFromAsset(getAssets(), "bebas_neue_bold.ttf");
        iCustomFontSmall = Typeface.createFromAsset(getAssets(), "Lato-Light.ttf");

        initializeViewComponents();
        decorateComponents();

        updateActivity(aInstructor);

        iSkillHeader = (TextView) findViewById(R.id.skills_header);
        iSkillHeader.setText("WHAT DO I TEACH?");
        iSkillHeader.setTypeface(iCustomFont);

        iListView = (ListView) findViewById(R.id.theListView);

        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(new Skill("Salsa"));
        skills.add(new Skill("Java"));
        skills.add(new Skill("Programming"));
        skills.add(new Skill("Soccer Coaching"));
        skills.add(new Skill("High Intensity Workouts"));

        ArrayAdapter theAdapter = new SkillAdapter(this, skills);
        iListView.setAdapter(theAdapter);
    }

    public void updateActivity(Instructor aInstructor) {
        setFullNameView(aInstructor.getFirstName(),
                aInstructor.getLastName());
    }

    public void initializeViewComponents() {
        iFullNameView = (TextView) findViewById(R.id.profile_full_name);
    }

    public void decorateComponents() {
        iFullNameView.setTypeface(iCustomFontBold);
    }

    public void setFullNameView(String aFirstName, String aLastName) {
        iFullNameView.setText(aFirstName + " " + aLastName);
    }
}
