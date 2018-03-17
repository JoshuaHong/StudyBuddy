package com.example.josh.studybuddy;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by ChooA on 3/17/2018.
 */

public class studyEventAdapter extends ArrayAdapter<studyEvent>{

    public studyEventAdapter(Context context, ArrayList<studyEvent> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        if(listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.listbox,parent,false);
        }
        final studyEvent currentStudy = getItem(position);

        TextView desc = (TextView) listView.findViewById(R.id.description);
        desc.setText(currentStudy.getDescription());
        TextView currentNum = (TextView) listView.findViewById(R.id.currentNumber);
        TextView totalNum = (TextView) listView.findViewById(R.id.totalNumber);
        currentNum.setText(currentStudy.getCurrentPeople());
        totalNum.setText(currentStudy.getMaxPeople());
        TextView startTime = (TextView) listView.findViewById(R.id.from);
        TextView endTime = (TextView) listView.findViewById(R.id.to);
        startTime.setText(currentStudy.getBeginTime());
        endTime.setText(currentStudy.getEndTime());
        Button join = (Button) listView.findViewById(R.id.join);

        return listView;
    }
}
