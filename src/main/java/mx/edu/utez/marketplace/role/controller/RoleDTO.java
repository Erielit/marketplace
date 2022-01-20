package mx.edu.utez.marketplace.role.controller;

import mx.edu.utez.marketplace.status.model.Status;

public class RoleDTO {
    long id;
    String description;
    Status status;

    public RoleDTO() {
    }

    public RoleDTO(long id, String description, Status status) {
        this.id = id;
        this.description = description;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
