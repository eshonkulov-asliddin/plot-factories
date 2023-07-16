package com.epam.rd.autocode.factory.plot.impl;

import com.epam.rd.autocode.factory.plot.Character;
import com.epam.rd.autocode.factory.plot.Plot;
import com.epam.rd.autocode.factory.plot.PlotFactory;

public class ClassicDisneyPlotFactory implements PlotFactory {

    private final Character hero;
    private final Character beloved;
    private final Character villian;

    public ClassicDisneyPlotFactory(Character hero, Character beloved, Character villian){
        this.hero = hero;
        this.beloved = beloved;
        this.villian = villian;
    }
    @Override
    public Plot plot() {
        StringBuilder plot = new StringBuilder();
        plot.append(hero.name()).append(" is young and adorable. ")
                .append(hero.name()).append(" and ")
                .append(beloved.name()).append(" love each other. ")
                .append(villian.name()).append(" interferes with their happiness, but loses in the end.");

        return plot::toString;
    }
}
