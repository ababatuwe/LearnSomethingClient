package com.example.hreeels.learnsomethingclient.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hreeels.learnsomethingclient.R;
import com.example.hreeels.learnsomethingclient.model.Skill;

import java.util.ArrayList;

/**
 * Created by Hreeels on 2015-08-04.
 */
public class SkillAdapter extends ArrayAdapter<Skill> {

    /*
    Keeps a list of background drawables
    for each unique position in the list view.
     */
    private ArrayList<Integer> iViewBackgroundDrawables;

    public SkillAdapter(Context context, ArrayList<Skill> values) {
        // Used for row_layout_2
        //super(context, R.layout.row_layout_2, values);

        // Used for row_layout_3
        super(context, R.layout.event_list_row_layout, values);

        // Initialize background drawables for view
        iViewBackgroundDrawables = new ArrayList<Integer>();
        this.initializeBackgroundDrawables();
    }

    /*
    Returns the background drawable for the view at the position provided.
     */
    private int getBackgroundDrawableAtPosition(int position) {
        return iViewBackgroundDrawables.get(position);
    }

    /*
    Sets a unique drawable for each position in the background color list.
    The drawables cycle between 3 different ones.
     */
    private void initializeBackgroundDrawables() {
        int currentBackgroundID = 0;

        for(int i = 0; i < getCount(); i++) {
            // Set 1 of 3 unique colors to each position in ArrayList
            if(currentBackgroundID == 0) {
                iViewBackgroundDrawables.add(R.drawable.rounded_button_cyan_a100);
            } else if(currentBackgroundID == 1) {
                iViewBackgroundDrawables.add(R.drawable.rounded_button_cyan_a200);
            } else {
                iViewBackgroundDrawables.add(R.drawable.rounded_button_cyan_a400);
            }

            // Cycle color ID between 0 and 2
            if(currentBackgroundID < 2) {
                currentBackgroundID++;
            } else {
                currentBackgroundID = 0;
            }
        }
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        // Get Fonts
        Typeface customFont = Typeface.createFromAsset(getContext().getAssets(), "bebas_neue_regular.ttf");
        Typeface customFontBold = Typeface.createFromAsset(getContext().getAssets(), "bebas_neue_bold.ttf");

        LayoutInflater theInflater = LayoutInflater.from(getContext());

        View theView = theInflater.inflate(R.layout.event_list_row_layout, parent, false);
        theView.setBackgroundResource(this.getBackgroundDrawableAtPosition(position));

        Skill mySkill = getItem(position);

        TextView theTextView = (TextView) theView.findViewById(R.id.textView1);
        theTextView.setText(mySkill.skillName);
        theTextView.setTypeface(customFontBold);

        return theView;
    }
}