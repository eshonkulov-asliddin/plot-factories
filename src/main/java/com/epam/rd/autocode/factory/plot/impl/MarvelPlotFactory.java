package com.epam.rd.autocode.factory.plot.impl;

import com.epam.rd.autocode.factory.plot.Character;
import com.epam.rd.autocode.factory.plot.EpicCrisis;
import com.epam.rd.autocode.factory.plot.Plot;
import com.epam.rd.autocode.factory.plot.PlotFactory;

import java.util.Arrays;

public class MarvelPlotFactory implements PlotFactory {
    private final Character[] heroes;
    private final EpicCrisis epicCrisis;
    private final Character villain;

    public MarvelPlotFactory(Character[] heroes, EpicCrisis epicCrisis, Character villain) {
        this.heroes = heroes;
        this.epicCrisis = epicCrisis;
        this.villain = villain;
    }

    @Override
    public Plot plot() {
        String plot = Arrays.stream(heroes).count() > 1L ? createStoryWithHeros(heroes, epicCrisis, villain) :
                                                           createStoryWithSingleHero(heroes[0], epicCrisis, villain);

        return () -> plot;
    }

    private String createStoryWithSingleHero(Character hero, EpicCrisis epicCrisis, Character villain){
        return String.format(
                "%s threatens the world. " +
                "But the brave %s is on guard. So, no way that intrigues of %s will bend the willpower of the inflexible hero.",
                epicCrisis.name(), hero.name(), villain.name()
        );
    }

    private String createStoryWithHeros(Character[] heros, EpicCrisis epicCrisis, Character villain){
        StringBuilder plot = new StringBuilder();
        plot.append(epicCrisis.name())
                .append(" threatens the world.")
                .append(" But").append(" the brave ").append(heros[0].name());
        int length = (int) Arrays.stream(heros).count();
        for (int i = 1; i < length - 1; i++){
            plot.append(", the brave ").append(heros[i].name());
        }

        plot.append(" and ").append("the brave ").append(heros[length-1].name());

        plot.append(" are on guard. So, no way that intrigues of ").append(villain.name()).append(" will bend the willpower of inflexible heroes.");

        return plot.toString();
    }
}
