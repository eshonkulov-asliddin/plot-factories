package com.epam.rd.autocode.factory.plot.impl;

import com.epam.rd.autocode.factory.plot.Character;
import com.epam.rd.autocode.factory.plot.EpicCrisis;
import com.epam.rd.autocode.factory.plot.Plot;
import com.epam.rd.autocode.factory.plot.PlotFactory;

public class ContemporaryDisneyPlotFactory implements PlotFactory {
    private final Character hero;
    private final EpicCrisis epicCrisis;
    private final Character funnyFriend;

    public ContemporaryDisneyPlotFactory(Character hero, EpicCrisis epicCrisis, Character funnyFriend){
        this.hero = hero;
        this.epicCrisis = epicCrisis;
        this.funnyFriend = funnyFriend;
    }
    @Override
    public Plot plot() {
        String plot = String.format(
                "In the beginning, %s feels a bit awkward and uncomfortable. " +
                "But personal issue fades, when a big trouble comes - %s. %s stands up against it, but with no success at first." +
                " But then, by putting self together and with the help of friends, including spectacular, funny %s, %s restores the spirit, " +
                "overcomes the crisis and gains gratitude and respect.",
                hero.name(), epicCrisis.name(), hero.name(), funnyFriend.name(), hero.name()
        );

        return () -> plot;
    }
}
