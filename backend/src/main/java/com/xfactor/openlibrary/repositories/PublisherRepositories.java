package com.xfactor.openlibrary.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xfactor.openlibrary.domain.Publisher;

public interface PublisherRepositories extends JpaRepository<Publisher, Long>{
    List<Publisher> findByname(String name);
    List<Publisher> findByaddress(String address);
    List<Publisher> findByphone(String phone);
    List<Publisher> findByemail(String email);
}
