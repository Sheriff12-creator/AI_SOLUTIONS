package model;

public class Project {

    private int id;
    private String projectName;
    private String clientName;
    private String description;
    private String technologies;
    private int rating;
    private String imageUrl;
    private double avgRating;

    // Empty constructor
    public Project() {}

    // Full constructor
    public Project(int id, String projectName, String clientName,
                    String description, String technologies,
                    int rating, String imageUrl,  double avgRating) {

        this.id = id;
        this.projectName = projectName;
        this.clientName = clientName;
        this.description = description;
        this.technologies = technologies;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.avgRating = avgRating;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }
}

