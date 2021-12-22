package mx.edu.utez.marketplace.product.controller;

import mx.edu.utez.marketplace.status.model.Status;
import mx.edu.utez.marketplace.subcategory.model.Subcategory;


public class ProductDTO {
    private long id;
    private String name;
    private String description;
    private String file;
    private int cuantity;
    private double price;
    private Status status;
    private Subcategory subcategory;

    public ProductDTO() {
    }

    public ProductDTO(long id, String name, String description, String file, int cuantity, double price, Status status, Subcategory subcategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.file = file;
        this.cuantity = cuantity;
        this.price = price;
        this.status = status;
        this.subcategory = subcategory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getCuantity() {
        return cuantity;
    }

    public void setCuantity(int cuantity) {
        this.cuantity = cuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }
}
