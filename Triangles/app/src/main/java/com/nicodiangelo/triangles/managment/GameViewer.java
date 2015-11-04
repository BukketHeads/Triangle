package com.nicodiangelo.triangles.managment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameViewer extends SurfaceView
{
    private GameThread game;
    private SurfaceHolder holder;
    public GameViewer(Context context)
    {
        super(context);
        game = new GameThread(this);
        holder = getHolder();
        holder.addCallback(new SurfaceHolder.Callback()
        {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder)
            {
                System.out.println("STARTED");
                game.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3)
            {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder)
            {
                game.stop();
                System.out.println("STOPPING THE GAME");
            }
        });
    }

    @Override
    protected void onDraw(Canvas g)
    {
        g.drawColor(Color.RED);
//        g.drawOval(0,0,10,10,null);
    }
}
