package com.xfactor.openlibrary.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import com.xfactor.openlibrary.domain.Publisher;
import com.xfactor.openlibrary.repositories.PublisherRepositories;
@RestController
@RequestMapping("publishers")
public class PublisherController {
    private PublisherRepositories publisherRepositories;
    public PublisherController(PublisherRepositories publisherRepositories){
        this.publisherRepositories = publisherRepositories;
    }

    @PostMapping("/savepublishers")
    public Publisher savePublisher(@RequestBody Publisher publisher)
    {
        publisherRepositories.save(publisher);
        return publisher;
    }

    @PutMapping("/updatepublisher")
    public Publisher updatePublisher(@RequestBody Publisher publisher, CrudRepository<Publisher, Long> publisherRepository) {
        if (publisher.getId() != null) {
            Publisher publisher2 = publisherRepository.save(publisher);
            return publisher2;
        }
        return null;
    }

    @DeleteMapping("delete/{id}")
    public void deletepublisher(@PathVariable Long id) {
        publisherRepositories.deleteById(id);
    }

    @GetMapping("findTotal")
    public Long findTotal() {
        return publisherRepositories.count();
    }

    @GetMapping("/getAll")
    public List<Publisher> getAllPublishers()
    {
        return publisherRepositories.findAll();
    }

    @GetMapping("findById/{id}")
    public Publisher findById(@PathVariable Long id){
        Optional<Publisher> optionalOfPublisher = publisherRepositories.findById(id);
        if(optionalOfPublisher.isPresent()){
            return optionalOfPublisher.get();
        }
        return null;
    }

    @GetMapping("findByname/{name}")
    public List<Publisher> findByname(@PathVariable String name){
        List<Publisher> listOfname = publisherRepositories.findByname(name);
        return listOfname;
    }

    @GetMapping("findByaddress/{address}")
    public List<Publisher> findByaddress(@PathVariable String address) {
        List<Publisher> listOfaddress = publisherRepositories.findByaddress(address);
        return listOfaddress;
    }

    @GetMapping("/findByphone/{phone}")
    public List<Publisher> findByphone(@PathVariable String phone){
        List<Publisher> listOfphone = publisherRepositories.findByphone(phone);
        return listOfphone;
    }

    @GetMapping("findByemail/{email}")
    public List<Publisher> findByemail(@PathVariable String email){
        List<Publisher> listOfemail = publisherRepositories.findByemail(email);
        return listOfemail;
    }
}