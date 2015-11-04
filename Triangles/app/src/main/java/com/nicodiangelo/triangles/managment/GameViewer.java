package com.nicodiangelo.triangles.managment;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.nicodiangelo.triangles.R;
import com.nicodiangelo.triangles.classes.Triangle;

public class GameViewer extends SurfaceView
{
    private GameThread game;
    private SurfaceHolder holder;
    final private int WIDTH;
    final private int HEIGHT;
    private Triangle[][] map;


    public GameViewer(Context context, int width, int height)
    {
        super(context);

        game = new GameThread(this);
        WIDTH = width;
        HEIGHT = height;
        holder = getHolder();

        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                System.out.println("STARTED");
                initalize();
                game.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                game.stop();
                System.out.println("STOPPING THE GAME");
            }
        });
    }

    @Override
    protected void onDraw(Canvas g)
    {
        g.drawColor(Color.RED);
        drawMap(g);
//        g.drawOval(0,0,10,10,null);
    }
    private void drawMap(Canvas g)
    {
        for(int a = 0; a < WIDTH / 50; a++)
        {
            for(int b = 0; b < HEIGHT / 50; b++)
            {
                map[a][b].onDraw(g);
            }
        }
    }
    private void initalize()
    {
        map = new Triangle[WIDTH / 50][HEIGHT / 50];
        for(int a = 0; a < WIDTH/20; a++)
        {
            for(int b = 0; b < HEIGHT/20; b++)
            {
                int randNum = getNum();

                if(randNum == 0)
                    map[a][b] = new Triangle(a,b,BitmapFactory.decodeResource(getResources(), R.drawable.zero));
                else if(randNum == 1)
                    map[a][b] = new Triangle(a,b,BitmapFactory.decodeResource(getResources(), R.drawable.one));
                else
                    map[a][b] = new Triangle(a,b,BitmapFactory.decodeResource(getResources(), R.drawable.two));
            }
        }

    }
    private int getNum()
    {
        int rand = (int)(Math.random() * 20);
        switch(rand)
        {
            case 0: return 0;
            case 1: return 1;
            default: return 2;
        }

    }
}
