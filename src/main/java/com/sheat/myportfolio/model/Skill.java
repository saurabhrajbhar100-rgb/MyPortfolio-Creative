package com.sheat.myportfolio.model;

/**
 * Describes ONE technical skill shown in the Skills section.
 */
public class Skill {

    private String name;
    private String category;
    private String description;

    public Skill(String name, String category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
