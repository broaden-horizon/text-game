package com.codestates.seb.lol_program.game.unit;

import java.util.ArrayList;
import java.util.Arrays;

public class Enemies {
    private static ArrayList<Unit> units = new ArrayList<>();
    private static Enemies enemies = null;

    public static ArrayList<Unit> getUnits() {
        return units;
    }

    private Enemies() {
        units.add(level1());
        units.add(level2());
        units.add(level3());
        units.add(level4());
    }

    public static Enemies getInstance() {
        if(enemies == null) {
            enemies = new Enemies();
        }
        return enemies;
    }

    private Unit level1() {
        Unit enemy = new Unit("level1Enemy", 5, 5, 10);
        enemy.setTempDefencePower(5);
        enemy.setTempAttackPower(5);
        return enemy;
    }
    private Unit level2() {
        Unit enemy = new Unit("level2Enemy", 10, 10, 15);
        enemy.setTempDefencePower(10);
        enemy.setTempAttackPower(10);
        return enemy;
    }
    private Unit level3() {
        Unit enemy = new Unit("level3Enemy", 15, 15, 20);
        enemy.setTempDefencePower(15);
        enemy.setTempAttackPower(15);
        return enemy;
    }
    private Unit level4() {
        Unit enemy = new Unit("level4Enemy", 20, 20, 30);
        enemy.setTempDefencePower(20);
        enemy.setTempAttackPower(20);
        return enemy;
    }

}
