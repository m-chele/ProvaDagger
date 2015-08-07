package com.mcenere.provadagger;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                VeicoloModule.class
        }
)
public interface VeicoloComponent
{
    Veicolo provideVeicolo();
}

