package com.nicodiangelo.triangles.classes;


import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Triangle
{
    private int posX;
    private int posY;
    private Bitmap bmp;

    /**
     * Default Triangle constructor
     */
    public Triangle()
    {
        posX = 0;
        posY = 0;
    }

    /**
     * Overloaded Triangle constructor
     * @param posX x to initialize attributes.
     * @param posY y to initialize attributes.
     */
    public Triangle(int posX, int posY)
    {
        this.posX = posX;
        this.posY = posY;
    }

    /**
     *
     * @param posX
     * @param posY
     * @param bmp
     */
    public Triangle(int posX, int posY,Bitmap bmp)
    {
        this.posX = posX;
        this.posY = posY;
        this.bmp = bmp;
    }

    public void onDraw(Canvas g,int shift)
    {
        g.drawBitmap(bmp,posX * 100,posY * 100 - shift,null);
    }
    public Triangle copy()
    {
        return new Triangle(posX,posY,bmp);
    }
    /**
     * This program returns the effect of the given class
     * @return Returns the effect of the object when chosen.
     */
    public String getEffect()
    {
        return "nothing";
    }

//GETTERS AND SETTERS

    public Bitmap getBmp()
    {
        return bmp;
    }

    public void setBmp(Bitmap bmp)
    {
        this.bmp = bmp;
    }

    /**
     * This method returns the x position of the object.
     * @return Returns the x position of the object.
     */
    public int getPosX()
    {
        return posX;
    }

    /**
     * This method set the x of the object to the
     * one sent in by the method.
     * @param posX The new x to become the location of the object
     */
    public void setPosX(int posX)
    {
        this.posX = posX;
    }

    /**
     * This method returns the y position of the object.
     * @return Returns the y position of the object.
     */
    public int getPosY()
    {
        return posY;
    }

    /**
     * This method set the y of the object to the
     * one sent in by the method.
     * @param posY The new y to become the location of the object
     */
    public void setPosY(int posY)
    {
        this.posY = posY;
    }
}
