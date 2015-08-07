package com.mcenere.provadagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class VeicoloModule
{

    @Provides
    @Singleton
    Motore provideMotore()
    {
        return new Motore();
    }

    @Provides
    @Singleton
    Veicolo provideVeicolo(Motore motore)
    {
        return new Veicolo(motore);
    }

}
