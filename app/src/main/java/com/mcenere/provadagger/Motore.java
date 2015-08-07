package com.mcenere.provadagger;


public class Motore
{
    private int velocita;

    public Motore()
    {
    }

    public int getVelocita()
    {
        return velocita;
    }

    public void accelera(int incremento)
    {
        this.velocita += incremento;
    }

    public void frena()
    {
        velocita = 0;
    }
}
