package com.londonappbrewery.destini;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button mButtonTop;
    Button mButtonBottom;
    TextView mStoryTextViewm;
    int mStoryIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mStoryIndex = savedInstanceState.getInt("StoryIndex");
        } else {
            mStoryIndex = 1;
        }

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);
        mStoryTextViewm = (TextView) findViewById(R.id.storyTextView);

        upDateStory();

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Log.d("Destini", "ButtonTop");
                if (mStoryIndex == 1) {
                    mStoryIndex = 3;
                } else if (mStoryIndex == 2) {
                    mStoryIndex = 3;
                } else if (mStoryIndex == 3) {
                    mStoryIndex = 6;
                }
                upDateStory();
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Log.d("Destini", "ButtonBottom");
                if (mStoryIndex == 1) {
                    mStoryIndex = 2;
                } else if (mStoryIndex == 2) {
                    mStoryIndex = 4;
                } else if (mStoryIndex == 3) {
                    mStoryIndex = 5;
                }
                upDateStory();
            }
        });

    }

    private void upDateStory() {
        // Log.d("Destini", "Next Story " + mStoryIndex);
        if (mStoryIndex == 1) {
            mStoryTextViewm.setText(R.string.T1_Story);
            mButtonTop.setText(R.string.T1_Ans1);
            mButtonBottom.setText(R.string.T1_Ans2);
        } else if (mStoryIndex == 2) {
            mStoryTextViewm.setText(R.string.T2_Story);
            mButtonTop.setText(R.string.T2_Ans1);
            mButtonBottom.setText(R.string.T2_Ans2);
        } else if (mStoryIndex == 3) {
            mStoryTextViewm.setText(R.string.T3_Story);
            mButtonTop.setText(R.string.T3_Ans1);
            mButtonBottom.setText(R.string.T3_Ans2);
        } else if (mStoryIndex == 4) {
            mStoryTextViewm.setText(R.string.T4_End);
        } else if (mStoryIndex == 5) {
            mStoryTextViewm.setText(R.string.T5_End);
        } else if (mStoryIndex == 6) {
            mStoryTextViewm.setText(R.string.T6_End);
        }

        if (mStoryIndex == 4 || mStoryIndex == 5 || mStoryIndex == 6 ) {
            mButtonTop.setText("");
            mButtonBottom.setText("");
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("StoryIndex", mStoryIndex);
    }

}
