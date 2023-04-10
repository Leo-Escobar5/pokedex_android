package com.almaralengineering.pokedex;

import android.os.Parcel;
import android.os.Parcelable;

public class Stats implements Parcelable {
    private String hp;
    private String attack;
    private String defense;
    private String speed;

    public Stats(String hp, String attack, String defense, String speed) {
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

    protected Stats(Parcel in) {
        hp = in.readString();
        attack = in.readString();
        defense = in.readString();
        speed = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(hp);
        dest.writeString(attack);
        dest.writeString(defense);
        dest.writeString(speed);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Stats> CREATOR = new Parcelable.Creator<Stats>() {
        @Override
        public Stats createFromParcel(Parcel in) {
            return new Stats(in);
        }

        @Override
        public Stats[] newArray(int size) {
            return new Stats[size];
        }
    };

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public String getDefense() {
        return defense;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}
