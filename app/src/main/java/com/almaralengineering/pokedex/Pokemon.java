package com.almaralengineering.pokedex;

public class Pokemon {
    private String id;
    private String name;
    private String imageUrl;
    private int soundId;
    private Stats stats;
    private Type type;

    public enum Type {
        FIRE, WATER, PLANT, ELECTRIC
    }

    public Pokemon(String id, String name, String imageUrl, int soundId, Type type, Stats stats) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.soundId = soundId;
        this.type = type;
        this.stats = stats;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public int getSoundId() {
        return soundId;
    }
    public Type getType() {
        return type;
    }
    public Stats getStats() {
        return stats;
    }

}
