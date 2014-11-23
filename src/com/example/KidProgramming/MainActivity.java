package com.example.KidProgramming;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import static android.widget.AbsListView.CHOICE_MODE_MULTIPLE_MODAL;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    ListView listInstruction;
    ArrayList<Instruction> mArrayInstruction;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //Instruction mInstruction=new Instruction(R.drawable.routing_forward,"di thang");
        mArrayInstruction=new ArrayList<Instruction>();
        //mArrayInstruction.add(mInstruction);
        final InstructionAdapter mInstructionAdapter=new InstructionAdapter(this, R.layout.instruction_layout, mArrayInstruction);
        listInstruction=(ListView)findViewById(R.id.list_instruction);
        listInstruction.setAdapter(mInstructionAdapter);
        listInstruction.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Instruction selecteditem = mInstructionAdapter.getItem(position);
                mInstructionAdapter.remove(selecteditem);
                mInstructionAdapter.notifyDataSetChanged();
            }
        });
        listInstruction.setChoiceMode(CHOICE_MODE_MULTIPLE_MODAL);
        listInstruction.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                // Capture total checked items
                final int checkedCount = listInstruction.getCheckedItemCount();
                // Set the CAB title according to total checked items
                mode.setTitle(checkedCount + " Selected");
                // Calls toggleSelection method from ListViewAdapter Class
                mInstructionAdapter.toggleSelection(position);
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(R.menu.activity_main,menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.delete:
                        // Calls getSelectedIds method from ListViewAdapter Class
                        SparseBooleanArray selected = mInstructionAdapter.getSelectedIds();
                        // Captures all selected ids with a loop
                        for (int i = (selected.size() - 1); i >= 0; i--) {
                            if (selected.valueAt(i)) {
                                Instruction selecteditem = mInstructionAdapter.getItem(selected.keyAt(i));
                                // Remove selected items following the ids
                                mInstructionAdapter.remove(selecteditem);
                            }
                        }
                        // Close CAB
                        mode.finish();
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                mInstructionAdapter.removeSelection();
            }
        });
        Log.i("Thanh","onCreate");
        ImageButton ibtnTurnLeft=(ImageButton)findViewById(R.id.ibtn_turn_left);
        ImageButton ibtnForward=(ImageButton)findViewById(R.id.ibtn_forward);
        ImageButton ibtnTurnRight=(ImageButton)findViewById(R.id.ibtn_turn_right);
        ibtnTurnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Instruction mTurnLeftInstruction=new Instruction(R.drawable.routing_turn_left,"Turn left");
                mArrayInstruction.add(mTurnLeftInstruction);
                mInstructionAdapter.notifyDataSetChanged();
            }
        });
        ibtnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Instruction mForwardInstruction=new Instruction(R.drawable.routing_forward,"Forward");
                mArrayInstruction.add(mForwardInstruction);
                mInstructionAdapter.notifyDataSetChanged();;
            }
        });
        ibtnTurnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Instruction mTurnRight=new Instruction(R.drawable.routing_turn_right,"Turn Right");
                mArrayInstruction.add(mTurnRight);
                mInstructionAdapter.notifyDataSetChanged();
            }
        });
    }
}
