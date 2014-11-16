package com.example.KidProgramming;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

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
        final InstructionAdapter mInstructionAdapter=new InstructionAdapter(this,mArrayInstruction);
        listInstruction=(ListView)findViewById(R.id.list_instruction);
        listInstruction.setAdapter(mInstructionAdapter);
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
