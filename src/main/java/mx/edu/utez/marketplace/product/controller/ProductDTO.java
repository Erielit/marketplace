package mx.edu.utez.marketplace.product.controller;

import com.sun.istack.NotNull;
import mx.edu.utez.marketplace.status.model.Status;
import mx.edu.utez.marketplace.subcategory.model.Subcategory;

import java.util.Base64;


public class ProductDTO {
    private long id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private String file;
    @NotNull
    private int cuantity;
    @NotNull
    private double price;
    @NotNull
    private Status status;
    @NotNull
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

    public byte[] getFile() {
        return Base64.getDecoder().decode(file.replace(" ", "+"));
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
