package mx.edu.utez.marketplace.category.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import mx.edu.utez.marketplace.status.model.Status;
import mx.edu.utez.marketplace.subcategory.model.Subcategory;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @NotNull
    private Status status;
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Subcategory> subcategories;

    public Category() {
    }

    public Category(String description, Status status) {
        this.description = description;
        this.status = status;
    }

    public Category(String description, Status status, List<Subcategory> subcategories) {
        this.description = description;
        this.status = status;
        this.subcategories = subcategories;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }
}
