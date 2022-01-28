package mx.edu.utez.marketplace.product.model;

import mx.edu.utez.marketplace.status.model.Status;
import mx.edu.utez.marketplace.subcategory.model.Subcategory;

import javax.persistence.*;
import java.util.Base64;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "fileBlob", columnDefinition = "longblob")
    private byte[] fileBase64;
    private int cuantity;
    private double price;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategory;

    public Product() {
    }

    public Product(String name, String description, byte[] fileBase64, int cuantity, double price, Status status, Subcategory subcategory) {
        this.name = name;
        this.description = description;
        this.fileBase64 = fileBase64;
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

    public String getFileBase64() {
        String file = Base64.getEncoder().encodeToString(this.fileBase64);
        return file;
    }

    public void setFileBase64(byte[] fileBase64) {
        this.fileBase64 = fileBase64;
    }
}
