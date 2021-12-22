package mx.edu.utez.marketplace.subcategory.controller;

import com.sun.istack.NotNull;
import mx.edu.utez.marketplace.category.model.Category;

public class SubcategoryDTO {
    long id;
    @NotNull
    String description;
    @NotNull
    Category category;

    public SubcategoryDTO() {
    }

    public SubcategoryDTO(long id, String description, Category category) {
        this.id = id;
        this.description = description;
        this.category = category;
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
}
