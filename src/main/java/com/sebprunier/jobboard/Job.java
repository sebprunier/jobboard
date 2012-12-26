package com.sebprunier.jobboard;

import java.io.Serializable;
import java.util.Date;

public class Job implements Serializable {

    private static final long serialVersionUID = 6117981647462587825L;

    private Long id;

    private String title;

    private String description;

    private Date creationDate;

    public Job() {
        super();
    }

    public Job(Long id, String title, String description, Date creationDate) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

}
