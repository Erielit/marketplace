package mx.edu.utez.marketplace.status.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import mx.edu.utez.marketplace.category.model.Category;
import mx.edu.utez.marketplace.product.model.Product;
import mx.edu.utez.marketplace.role.model.Role;
import mx.edu.utez.marketplace.subcategory.model.Subcategory;

import javax.persistence.*;
import java.util.List;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String description;
    @OneToMany(mappedBy = "status")
    @JsonIgnore
    List<Category> categories;
    @OneToMany(mappedBy = "status")
    @JsonIgnore
    List<Product> products;
    @OneToMany(mappedBy = "status")
    @JsonIgnore
    List<Subcategory> subcategories;
    @OneToMany(mappedBy = "status")
    @JsonIgnore
    List<Role> roles;

    public Status() {
    }

    public Status(String description) {
        this.description = description;
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

}
