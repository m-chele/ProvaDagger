package com.mcenere.provadagger;


import javax.inject.Inject;

public class Veicolo
{

    private final Motore motore;

    @Inject
    public Veicolo(Motore motore)
    {
        this.motore = motore;
    }

    public void aumentaVelocita(int incremento)
    {
        motore.accelera(incremento);
    }

    public void fermati()
    {
        motore.frena();
    }

    public int getVelocita()
    {
        return motore.getVelocita();
    }

}
