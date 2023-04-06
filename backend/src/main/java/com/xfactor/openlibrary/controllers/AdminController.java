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
import com.xfactor.openlibrary.domain.Admin;
import com.xfactor.openlibrary.repositories.AdminRepositories;
@RestController
@RequestMapping("admins")
public class AdminController {
    private AdminRepositories adminRepositories;
    public AdminController(AdminRepositories adminRepositories){
        this.adminRepositories = adminRepositories;
    }
    @PostMapping("/saveadmin")
    public Admin saveAdmin(@RequestBody Admin admin)
    {
        adminRepositories.save(admin);
        return admin;
    }

    @PutMapping("/updateadmin")
    public Admin updateAdmin(@RequestBody Admin admin, CrudRepository<Admin, Long> adminRepository){
        if(admin.getId() != null){
            Admin admin2 = adminRepository.save(admin);
            return admin2;
        }
        return null;
    }

    @DeleteMapping("delete/{id}")
    public void deleteAdmin(@PathVariable Long id){
        adminRepositories.deleteById(id);
    }

    @GetMapping("/getAll")
    public List<Admin> getAllAdmins()
    {
        return adminRepositories.findAll();
    }

    @GetMapping("findTotal")
    public Long findTotal() {
        return adminRepositories.count();
    }

    @GetMapping("findById/{id}")
    public Admin findById(@PathVariable Long id) {
        Optional<Admin> optionalOfAdmin = adminRepositories.findById(id);
        if (optionalOfAdmin.isPresent()) {
            return optionalOfAdmin.get();
        }
        return null;
    }

    @GetMapping("findByName/{name}")
    public List<Admin> findByName(@PathVariable String name){
        List<Admin> listOfName = adminRepositories.findByName(name);
        return listOfName;
    }

    @GetMapping("findByUsername/{username}")
    public List<Admin> findByUsername(@PathVariable String username){
        List<Admin> listOfUsername = adminRepositories.findByUsername(username);
        return listOfUsername;
    }

    @GetMapping("findByPassword/{password}")
    public List<Admin> findByPassword(@PathVariable String password){
        List<Admin> listOfPassword = adminRepositories.findByPassword(password);
        return listOfPassword;
    }

}