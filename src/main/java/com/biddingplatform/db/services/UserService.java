package com.biddingplatform.db.services;

import com.biddingplatform.db.entities.Address;
import com.biddingplatform.db.entities.Country;
import com.biddingplatform.db.entities.User;
import com.biddingplatform.db.DAOs.AddressDAO;
import com.biddingplatform.db.DAOs.UserDAO;
import com.biddingplatform.db.DAOs.CountryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserDAO userRepository;

    @Autowired
    private AddressDAO addressRepository;

    @Autowired
    private CountryDAO countryRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ArrayList<User> findByName(String firstName, String lastName){
        return userRepository.findByFirstNameOrLastName(firstName, lastName);
    }

    public ArrayList<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(UUID id){
        return userRepository.findById(id).get();
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email).get();
    }

    public long count(){
        return userRepository.count();
    }

    public UUID add(String firstName, String lastName, String email, String password, int apartment, int building,
                    String street, String city, String country, String companyName, int taxId){

        var newClient = new User();

        newClient.setFirstName(firstName);
        newClient.setLastName(lastName);
        newClient.setEmail(email);
        newClient.setTaxId(taxId);
        newClient.setCompanyName(companyName);
        newClient.setPassword(passwordEncoder.encode(password));

        var newAddress = new Address();
        newAddress.setApartment(apartment);
        newAddress.setBuilding(building);
        newAddress.setStreet(street);
        newAddress.setCity(city);

        var savedCountry = countryRepository.findByName(country).get();
        newAddress.setCountry(savedCountry);

        var savedAddress = addressRepository.saveAndFlush(newAddress);

        newClient.setAddress(savedAddress);

        var savedClient = userRepository.save(newClient);

        return savedClient.getId();
    }

    public void delete(UUID id) { userRepository.deleteById(id); }
}
