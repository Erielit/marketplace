package mx.edu.utez.marketplace.product.model;

public class ProductImage {
    private String name;
    private String file;
    private long size;
    private String contentType;

    public ProductImage() {
    }

    public ProductImage(String name, String file, long size, String contentType) {
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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
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
}
