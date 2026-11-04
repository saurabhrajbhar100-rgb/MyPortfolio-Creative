package com.sheat.myportfolio.model;

import java.util.List;

/**
 * Describes ONE project shown in the Projects section.
 * repoUrl stays null until a real GitHub repository link is available.
 */
public class Project {

    private String title;
    private String category;
    private String description;
    private List<String> technologies;
    private String repoUrl;

    public Project(String title, String category, String description,
                   List<String> technologies, String repoUrl) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.technologies = technologies;
        this.repoUrl = repoUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<String> technologies) {
        this.technologies = technologies;
    }

    public String getRepoUrl() {
        return repoUrl;
    }

    public void setRepoUrl(String repoUrl) {
        this.repoUrl = repoUrl;
    }

    /** Thymeleaf reads this as ${project.repoAvailable}. */
    public boolean isRepoAvailable() {
        return repoUrl != null && !repoUrl.isBlank();
    }
}
