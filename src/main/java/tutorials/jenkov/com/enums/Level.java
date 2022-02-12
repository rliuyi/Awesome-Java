package tutorials.jenkov.com.enums;

import java.util.EnumMap;

public enum Level {
    HIGH("high") {
        @Override
        public String toDescription() {
            return String.format("This is %s value", this.text);
        }
    },
    MEDIUM("medium") {
        @Override
        public String toDescription() {
            return String.format("This is %s value", this.text);
        }
    },
    LOW("low") {
        @Override
        public String toDescription() {
            return String.format("This is %s value", this.text);
        }
    };

    protected final String text;

    private Level(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("toString: %s", this.text);
    }

    public abstract String toDescription();
    
    public static void main(String[] args) {
        for(Level level : Level.values()) {
            System.out.print(String.format("%s, ", level));
            System.out.println(level.toDescription());
        }
        
        EnumMap<Level, String> levelMap = new EnumMap<Level, String>(Level.class);
        levelMap.put(HIGH, "high");
        levelMap.put(MEDIUM, "medium");
        levelMap.put(LOW, "low");
        
        String highValue = levelMap.get(Level.HIGH);
        System.out.println(String.format("The value of key HIGH is: %s", highValue));
    }
}