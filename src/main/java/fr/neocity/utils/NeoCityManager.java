package fr.neocity.utils;

import fr.neocity.utils.admin.FreezeListener;

import static fr.neocity.NeoCity.registerEvents;

public class NeoCityManager {

    public NeoCityManager (){
        init();
    }

    private void init (){
        registerEvents(
                new FreezeListener()
        );
    }
}
