package com.example.hoanbk.remotecontrol;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by hoanbk on 3/12/2017.
 */

public class RemoteControlFragment extends Fragment {

    private static final String TAG = "RemoteControlFragment";

    private TextView mWorkingTextView;
    private TextView mSelectedTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_remote_control, container, false);
        mSelectedTextView = (TextView) v.findViewById(R.id.fragment_remote_control_selectedTextView);
        mWorkingTextView = (TextView) v.findViewById(R.id.fragment_remote_control_workingTextView);
        View.OnClickListener numberButtonListen = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) v;
                String working = mWorkingTextView.getText().toString();
                String text = textView.getText().toString();
                if(working.equals("0")) {
                    mWorkingTextView.setText(text);
                } else {
                    mWorkingTextView.setText(working + text);
                }
            }
        };
//        Button zeroButton = (Button) v.findViewById(R.id.fragment_remote_control_zeroButton);
//        zeroButton.setOnClickListener(numberButtonListen);
//        Button oneButton = (Button) v.findViewById(R.id.fragment_remote_control_oneButton);
//        oneButton.setOnClickListener(numberButtonListen);
//        Button enterButton = (Button) v.findViewById(R.id.fragment_remote_control_enterButton);
        TableLayout tableLayout = (TableLayout) v.findViewById(R.id.fragment_remote_control_tableLayout);
        int number = 1;
        for(int i = 2; i < tableLayout.getChildCount() - 1; i++){
            TableRow row = (TableRow)tableLayout.getChildAt(i);
            for(int j = 0; j < row.getChildCount(); j++){
                Button button = (Button)row.getChildAt(j);
                button.setText();
            }
        }
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence working = mWorkingTextView.getText();
                if(working.length() > 0){
                    mSelectedTextView.setText(working);
                    mWorkingTextView.setText("0");
                }
            }
        });

        return v;
    }
}
