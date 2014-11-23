package com.example.KidProgramming;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by thanh on 11/14/14.
 */
public class InstructionAdapter extends ArrayAdapter<Instruction> {
    Activity mActivity;
    List<Instruction> lInstructions;
    private SparseBooleanArray mSelectedItemsIds;

    public InstructionAdapter(Activity mActivity, int resId, List<Instruction> mArrayInstruction) {
        super(mActivity, resId, mArrayInstruction);
        mSelectedItemsIds = new SparseBooleanArray();
        this.mActivity = mActivity;
        this.lInstructions=mArrayInstruction;
        Log.i("Thanh","InstructionAdapter");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = mActivity.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.instruction_layout, null, true);
        Instruction iInstruction=getItem(position);
        TextView textInstruction= (TextView) rowView.findViewById(R.id.text_instruction);
        ImageView imgInstruction= (ImageView) rowView.findViewById(R.id.img_instruction);
        textInstruction.setText(iInstruction.getNameInstruction());
        imgInstruction.setImageResource(iInstruction.getImageId());
        return rowView;
    }

    @Override
    public void remove(Instruction object) {
        lInstructions.remove(object);
        notifyDataSetChanged();
    }

    public List<Instruction> getInstructions()
    {
        return lInstructions;
    }

    public void toggleSelection(int position) {
        selectView(position, !mSelectedItemsIds.get(position));
    }

    public void removeSelection() {
        mSelectedItemsIds = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    public void selectView(int position, boolean value) {
        if (value)
            mSelectedItemsIds.put(position, value);
        else
            mSelectedItemsIds.delete(position);
        notifyDataSetChanged();
    }

    public int getSelectedCount() {
        return mSelectedItemsIds.size();
    }

    public SparseBooleanArray getSelectedIds() {
        return mSelectedItemsIds;
    }
}
