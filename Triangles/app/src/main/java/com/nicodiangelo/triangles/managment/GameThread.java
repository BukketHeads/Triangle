package com.nicodiangelo.triangles.managment;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


public class GameThread implements Runnable
{
    private GameViewer view;
    private Thread mainThread;
    private boolean running;
    private int curFrames;

    /**
     * Constructor for GameThread
     * @param view
     */
    public GameThread(GameViewer view)
    {
        this.view = view;
        running = true;
    }
    public void run()
    {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;
        double delta = 0;
        int frames = 0;
        int ticks = 0;
        while(running)
        {

            long now = System.nanoTime();
            delta+=(now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1)
            {
                tick();
                ticks++;
                delta--;
            }

            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer+=1000;
                curFrames = frames;
                System.out.println("Ticks: " + ticks + "\nFrames: " + frames);
                frames = 0;
                ticks = 0;
            }
        }
    }

    public synchronized void start()
    {
        running = true;
        mainThread = new Thread(this, "game");
        mainThread.start();
    }

    public synchronized void stop()
    {
        running = false;
        try
        {
            mainThread.join();
        }catch(InterruptedException e)
        {
            e.printStackTrace();
            System.out.println("HOLY CRAP IT BROKE");
        }
    }

    public void tick()
    {

    }
    public void render()
    {
        Canvas c = null;
        try
        {
            c = view.getHolder().lockCanvas();
            synchronized (view.getHolder())
            {
                view.onDraw(c);
                c.drawColor(Color.WHITE);
                Paint paint = new Paint();
                paint.setColor(Color.RED);
                paint.setTextSize(60);
                c.drawText("Frames: " + Integer.toString(curFrames),0,60,paint);
            }
        }
        finally
        {
            if(c != null)
                view.getHolder().unlockCanvasAndPost(c);
        }
    }
}
