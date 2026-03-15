public class SkateTrick {
    String name;
    Direction from;
    Direction to;
    Level level;
    boolean doSwitch;

    public SkateTrick (String name, Direction from, Direction to, Level level, boolean doSwitch ) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.level = level;
        this.doSwitch = doSwitch;
    }
}



