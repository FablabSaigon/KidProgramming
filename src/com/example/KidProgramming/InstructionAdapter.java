package com.example.KidProgramming;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by thanh on 11/14/14.
 */
public class InstructionAdapter extends BaseAdapter {
    Activity mActivity;
    ArrayList<Instruction> mArrayInstruction;
    public InstructionAdapter(Activity mActivity, ArrayList<Instruction> mArrayInstruction) {
        this.mActivity = mActivity;
        this.mArrayInstruction=mArrayInstruction;
        Log.i("Thanh","InstructionAdapter");
    }

    @Override
    public int getCount() {
        return mArrayInstruction.size();
    }

    @Override
    public Object getItem(int position) {
        return mArrayInstruction.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = mActivity.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.instruction_layout, null, true);
        Instruction mInstruction=(Instruction)getItem(position);
        TextView textInstruction= (TextView) rowView.findViewById(R.id.text_instruction);
        ImageView imgInstruction= (ImageView) rowView.findViewById(R.id.img_instruction);
        textInstruction.setText(mInstruction.getNameInstruction());
        imgInstruction.setImageResource(mInstruction.getImageId());
        return rowView;
    }
}
