package mx.edu.utez.marketplace.subcategory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import mx.edu.utez.marketplace.category.model.Category;
import mx.edu.utez.marketplace.product.model.Product;
import mx.edu.utez.marketplace.status.model.Status;

import javax.persistence.*;
import java.util.List;

@Entity
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull
    private Category category;
    @OneToMany(mappedBy = "subcategory")
    @JsonIgnore
    List<Product> products;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    public Subcategory() {
    }

    public Subcategory(String description, Category category) {
        this.description = description;
        this.category = category;
    }

    public Subcategory(String description, Category category, Status status) {
        this.description = description;
        this.category = category;
        this.status = status;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
