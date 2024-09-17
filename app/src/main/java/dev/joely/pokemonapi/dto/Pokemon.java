package dev.joely.pokemonapi.dto;

import java.util.List;

public class Pokemon {

    private int id;
    private Name name;
    private List<String> type;
    private BaseStats base;
    private String species;
    private String description;
    private Evolution evolution;
    private Profile profile;
    private Image image;

    // Inner classes to map nested objects
    public static class Name {
        private String english;
        private String japanese;
        private String chinese;
        private String french;

        // Getters and Setters
        public String getEnglish() { return english; }
        public void setEnglish(String english) { this.english = english; }

        public String getJapanese() { return japanese; }
        public void setJapanese(String japanese) { this.japanese = japanese; }

        public String getChinese() { return chinese; }
        public void setChinese(String chinese) { this.chinese = chinese; }

        public String getFrench() { return french; }
        public void setFrench(String french) { this.french = french; }
    }

    public static class BaseStats {
        private int HP;
        private int Attack;
        private int Defense;
        private int SpAttack;
        private int SpDefense;
        private int Speed;

        // Getters and Setters
        public int getHP() { return HP; }
        public void setHP(int HP) { this.HP = HP; }

        public int getAttack() { return Attack; }
        public void setAttack(int attack) { this.Attack = attack; }

        public int getDefense() { return Defense; }
        public void setDefense(int defense) { this.Defense = defense; }

        public int getSpAttack() { return SpAttack; }
        public void setSpAttack(int spAttack) { this.SpAttack = spAttack; }

        public int getSpDefense() { return SpDefense; }
        public void setSpDefense(int spDefense) { this.SpDefense = spDefense; }

        public int getSpeed() { return Speed; }
        public void setSpeed(int speed) { this.Speed = speed; }
    }

    public static class Evolution {
        private List<List<String>> next;

        // Getters and Setters
        public List<List<String>> getNext() { return next; }
        public void setNext(List<List<String>> next) { this.next = next; }
    }

    public static class Profile {
        private String height;
        private String weight;
        private List<String> egg;
        private List<List<String>> ability;
        private String gender;

        // Getters and Setters
        public String getHeight() { return height; }
        public void setHeight(String height) { this.height = height; }

        public String getWeight() { return weight; }
        public void setWeight(String weight) { this.weight = weight; }

        public List<String> getEgg() { return egg; }
        public void setEgg(List<String> egg) { this.egg = egg; }

        public List<List<String>> getAbility() { return ability; }
        public void setAbility(List<List<String>> ability) { this.ability = ability; }

        public String getGender() { return gender; }
        public void setGender(String gender) { this.gender = gender; }
    }

    public static class Image {
        private String sprite;
        private String thumbnail;
        private String hi_res;

        // Getters and Setters
        public String getSprite() { return sprite; }
        public void setSprite(String sprite) { this.sprite = sprite; }

        public String getThumbnail() { return thumbnail; }
        public void setThumbnail(String thumbnail) { this.thumbnail = thumbnail; }

        public String getHi_res() { return hi_res; }
        public void setHi_res(String hi_res) { this.hi_res = hi_res; }
    }

    // Getters and Setters for Pokemon class
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Name getName() { return name; }
    public void setName(Name name) { this.name = name; }

    public List<String> getType() { return type; }
    public void setType(List<String> type) { this.type = type; }

    public BaseStats getBase() { return base; }
    public void setBase(BaseStats base) { this.base = base; }

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Evolution getEvolution() { return evolution; }
    public void setEvolution(Evolution evolution) { this.evolution = evolution; }

    public Profile getProfile() { return profile; }
    public void setProfile(Profile profile) { this.profile = profile; }

    public Image getImage() { return image; }
    public void setImage(Image image) { this.image = image; }
}
