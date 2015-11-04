package com.nicodiangelo.triangles.classes;

public class BadTriangle extends Triangle
{
    private int posX;
    private int posY;

    /**
     * Default BadTriangle constructor
     */
    public BadTriangle()
    {
        posX = 0;
        posY = 0;
    }

    /**
     * Overloaded BadTriangle constructor
     * @param posX x to initialize attributes.
     * @param posY y to initialize attributes.
     */
    public BadTriangle(int posX, int posY)
    {
        this.posX = posX;
        this.posY = posY;
    }

    /**
     * This program returns the effect of the given class
     * @return Returns the effect of the object when chosen.
     */
    public String getEffect()
    {
        return "bad";
    }
}
