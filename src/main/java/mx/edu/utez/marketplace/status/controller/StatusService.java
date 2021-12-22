package mx.edu.utez.marketplace.status.controller;

import mx.edu.utez.marketplace.status.model.Status;
import mx.edu.utez.marketplace.status.model.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StatusService {
    @Autowired
    StatusRepository statusRepository;

    public List<Status> findAll(){
        return statusRepository.findAll();
    }

}
