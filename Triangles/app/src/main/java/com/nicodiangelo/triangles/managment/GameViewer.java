package com.nicodiangelo.triangles.managment;

import android.content.Context;
import android.graphics.Bitmap;
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
    private int shift;
    final private Bitmap RED;
    final private Bitmap GREEN;
    final private Bitmap BLUE;


    public GameViewer(Context context, int width, int height)
    {
        super(context);

        game = new GameThread(this);
        WIDTH = width;
        HEIGHT = height;
        shift = 0;
        holder = getHolder();
        RED = BitmapFactory.decodeResource(getResources(), R.drawable.zero);
        GREEN = BitmapFactory.decodeResource(getResources(), R.drawable.one);
        BLUE = BitmapFactory.decodeResource(getResources(), R.drawable.two);

        holder.addCallback(new SurfaceHolder.Callback()
        {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder)
            {
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

    /**
     * Keeps track of the shift in the viewing
     * @return returns the shift itself
     */
    public int shift()
    {
        if(shift == 99)
            shift = 0;
        else
            shift++;
        return shift;
    }

    /**
     * This method takes the list, and attempts to shift it up
     * however at the moment it does not work.
     */
    public void updateRows()
    {
        for(int k = 0; k < WIDTH / 100; k++)
        {
            map[k][0] = new Triangle(0,0,0);
        }

        for(int a = 1; a < HEIGHT / 100; a++)
        {
            for(int b = 0; b < WIDTH/100; b++)
            {
                map[b][a-1] = new Triangle(map[b][a].getPosX(),map[b][a].getPosY(),
                        map[b][a].getBmpNum());
                map[b][a] = null;
            }
        }
        for(int k = 0; k < WIDTH/100; k++)
        {
            int randNum = getNum();

            if(randNum == 0)
                map[k][(HEIGHT / 100) - 1] = new Triangle(k,(HEIGHT / 100) - 1,0);
            else if(randNum == 1)
                map[k][(HEIGHT / 100) - 1] = new Triangle(k,(HEIGHT / 100) - 1,1);
            else
                map[k][(HEIGHT / 100) - 1] = new Triangle(k,(HEIGHT / 100) - 1,2);
        }


    }
    /**
     * Draws the "Triangles" onto the screen
     * @param g What's being drawn on
     */
    private void drawMap(Canvas g)
    {
        for(int a = 0; a < WIDTH / 100; a++)
        {
            for(int b = 0; b < HEIGHT / 100; b++)
            {
                switch(map[a][b].getBmpNum())
                {
                    case 0:g.drawBitmap(RED,a*100,b*100-shift,null);break;
                    case 1:g.drawBitmap(GREEN,a*100,b*100-shift,null);break;
                    case 2:g.drawBitmap(BLUE,a*100,b*100-shift,null);break;
                }
            }
        }
    }

    /**
     * Creates and fills the array with Triangle objects,
     * and randomizes them.
     */
    private void initalize()
    {
        map = new Triangle[WIDTH / 100][HEIGHT / 100];
        for(int a = 0; a < WIDTH/100; a++)
        {
            for(int b = 0; b < HEIGHT/100; b++)
            {
                int randNum = getNum();
                map[a][b] = new Triangle(a,b,randNum);

            }
        }

    }

    /**
     * Returns a number from 0 to 2(inclusive) depending on a
     * randomly generated number.
     * @return returns the random number according to the list.
     */
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
