package mx.edu.utez.marketplace.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Base64;

public class ProductImage {
       private String name;
    private byte[] file;
    private long size;
    private String contentType;

    public ProductImage() {
    }

    public ProductImage(String name, byte[] file, long size, String contentType) {
        this.name = name;
        this.file = file;
        this.size = size;
        this.contentType = contentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFile() {
        return Base64.getEncoder().encodeToString(file);
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
