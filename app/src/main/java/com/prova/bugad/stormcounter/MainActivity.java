package com.prova.bugad.stormcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int manaU;
    private TextView lblManaUCount;
    private int manaR;
    private TextView lblManaRCount;
    private int stormCount;
    private TextView lblManaStorm;
    private View.OnClickListener listener;
    private View.OnLongClickListener longListener;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manaU=0;
        manaR=0;
        stormCount=0;


        lblManaUCount = (TextView)findViewById(R.id.lblBlueCount);
        lblManaRCount = (TextView)findViewById(R.id.lblRedCount);
        lblManaStorm = (TextView)findViewById(R.id.lblStormCount);

        listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btnAddBlue:
                        manaU++;
                        break;
                    case R.id.btnRemoveBlue:
                        if (manaU > 0) {
                            manaU--;
                        } else {
                            manaU = 0;
                        }
                        break;
                    case R.id.btnAddRed:
                        manaR++;
                        break;
                    case R.id.btnRemoveRed:
                        if (manaR > 0) {
                            manaR--;
                        } else {
                            manaR = 0;
                        }
                        break;
                    case R.id.btnAddStorm:
                        stormCount++;
                        break;
                    case R.id.btnRemoveStorm:
                        if (stormCount > 0) {
                            stormCount--;
                        } else {
                            stormCount = 0;
                        }
                        break;

                    case R.id.btnReset:
                        stormCount = 0;
                        manaR = 0;
                        manaU = 0;
                        break;
                }
                printCount();
            }
        };

        longListener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                switch (view.getId()){
                    case R.id.btnAddBlue:
                        manaU+=3;
                        break;
                    case R.id.btnRemoveBlue:
                        if (manaU > 0) {
                            manaU-=3;
                            if(manaU<0){manaU=0;}
                        } else {
                            manaU = 0;
                        }
                        break;
                    case R.id.btnAddRed:
                        manaR+=3;
                        break;
                    case R.id.btnRemoveRed:
                        if (manaR > 0) {
                            manaR-=3;
                            if(manaR<0){manaR=0;}
                        } else {
                            manaR = 0;
                        }
                        break;
                    case R.id.btnAddStorm:
                        stormCount+=5;
                        break;
                    case R.id.btnRemoveStorm:
                        if (stormCount > 0) {
                            stormCount-=5;
                            if(stormCount<0){stormCount=0;}
                        } else {
                            stormCount = 0;
                        }
                        break;

                    case R.id.btnReset:
                        stormCount = 0;
                        manaR = 0;
                        manaU = 0;
                        break;
                }
                printCount();
                return true;
            }
        };



        Button btnAddManaU = (Button)findViewById(R.id.btnAddBlue);btnAddManaU.setOnClickListener(listener);btnAddManaU.setOnLongClickListener(longListener);
        Button btnRemoveManaU= (Button)findViewById(R.id.btnRemoveBlue);btnRemoveManaU.setOnClickListener(listener);btnRemoveManaU.setOnLongClickListener(longListener);

        Button btnAddManaR = (Button)findViewById(R.id.btnAddRed);btnAddManaR.setOnClickListener(listener);btnAddManaR.setOnLongClickListener(longListener);
        Button btnRemoveManaR= (Button)findViewById(R.id.btnRemoveRed);btnRemoveManaR.setOnClickListener(listener);btnRemoveManaR.setOnLongClickListener(longListener);

        Button btnAddStorm = (Button)findViewById(R.id.btnAddStorm);btnAddStorm.setOnClickListener(listener);btnAddStorm.setOnLongClickListener(longListener);
        Button btnRemoveStorm= (Button)findViewById(R.id.btnRemoveStorm);btnRemoveStorm.setOnClickListener(listener);btnRemoveStorm.setOnLongClickListener(longListener);

        ImageButton btnReset = (ImageButton)findViewById(R.id.btnReset);btnReset.setOnClickListener(listener);btnReset.setOnLongClickListener(longListener);

    }

    public void printCount(){
        lblManaUCount.setText(String.valueOf(manaU));
        lblManaRCount.setText(String.valueOf(manaR));
        lblManaStorm.setText(String.valueOf(stormCount));
    }

}
