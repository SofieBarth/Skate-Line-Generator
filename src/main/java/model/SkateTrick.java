package model;

public class SkateTrick {
    public String name;
    public Direction from;
    public Direction to;
    public Level level;
    public boolean doSwitch;

    public SkateTrick(String name, Direction from, Direction to, Level level, boolean doSwitch) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.level = level;
        this.doSwitch = doSwitch;
    }
}



