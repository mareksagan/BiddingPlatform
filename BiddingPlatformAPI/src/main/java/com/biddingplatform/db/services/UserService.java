package com.biddingplatform.db.services;

import com.biddingplatform.db.entities.AddressEntity;
import com.biddingplatform.db.entities.UserEntity;
import com.biddingplatform.db.repositories.AddressRepository;
import com.biddingplatform.db.repositories.UserRepository;
import com.biddingplatform.db.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ArrayList<UserEntity> findByName(String firstName, String lastName){
        return userRepository.findByFirstNameOrLastName(firstName, lastName);
    }

    public ArrayList<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public UserEntity findById(UUID id){
        return userRepository.findById(id).get();
    }

    public UserEntity findByEmail(String email){
        return userRepository.findByEmail(email).get();
    }

    public long count(){
        return userRepository.count();
    }

    public UUID add(String firstName, String lastName, String email, String password, int apartment, int building,
                    String street, String city, String country, String companyName, int taxId){

        var newClient = new UserEntity();

        newClient.setFirstName(firstName);
        newClient.setLastName(lastName);
        newClient.setEmail(email);
        newClient.setTaxId(taxId);
        newClient.setCompanyName(companyName);
        newClient.setPassword(passwordEncoder.encode(password));

        var newAddress = new AddressEntity();
        newAddress.setApartment(apartment);
        newAddress.setBuilding(building);
        newAddress.setStreet(street);
        newAddress.setCity(city);

        var countryId = countryRepository.findByName(country).get().getId();
        newAddress.setCountryId(countryId);

        var savedAddressId = addressRepository.saveAndFlush(newAddress).getId();

        newClient.setAddressId(savedAddressId);

        var savedClient = userRepository.save(newClient);

        return savedClient.getId();
    }

    public void delete(UUID id) { userRepository.deleteById(id); }
}
