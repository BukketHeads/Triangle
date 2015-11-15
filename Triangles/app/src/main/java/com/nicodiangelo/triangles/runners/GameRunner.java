package com.nicodiangelo.triangles.runners;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import com.nicodiangelo.triangles.managment.GameViewer;

public class GameRunner extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        GameViewer game = new GameViewer(this,getWindowManager().getDefaultDisplay().getWidth(),
                                         getWindowManager().getDefaultDisplay().getHeight());
        System.out.println(getWindowManager().getDefaultDisplay().getWidth() + ":" +  getWindowManager().getDefaultDisplay().getHeight());

        FrameLayout layout = new FrameLayout(this);
        layout.addView(game);

        setContentView(layout);

    }
}
