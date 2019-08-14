package com.biddingplatform.db.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "client")
    private Cart cart;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 200)
    private String password;

    @Column(name = "company_name", nullable = true, length = 80)
    private String companyName;

    @Column(name = "tax_id", nullable = true)
    private Integer taxId;

    @Column(name = "balance", nullable = false, precision = 0)
    private double balance;

    @Column(name = "is_admin", nullable = false)
    private Boolean isAdmin;

    @OneToOne
    @JoinColumn(name= "id", insertable = false, updatable = false)
    private Address address;

    public UUID getId() {
        return id;
    }

    public User setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Cart getCart() {
        return cart;
    }

    public User setCartId(Cart cart) {
        this.cart = cart;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public User setAddress(Address newAddress) {
        this.address = newAddress;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public User setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public Integer getTaxId() {
        return taxId;
    }

    public User setTaxId(Integer taxId) {
        this.taxId = taxId;
        return this;
    }

    public double getBalance() {
        return balance;
    }

    public User setBalance(double balance) {
        this.balance = balance;
        return this;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public User setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
        return this;
    }

    @Override
    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var roles = getRoles();

        return roles.stream().map(SimpleGrantedAuthority::new).collect(toList());
    }

    @Override
    @Transient
    public String getUsername() {
        return email;
    }

    @Override
    @Transient
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @Transient
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    @Transient
    public boolean isEnabled() {
        return true;
    }

    @Transient
    public ArrayList<String> getRoles() {
        var roles = new ArrayList<String>();

        roles.add("user");

        if (isAdmin) roles.add("admin");

        return roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;

        if (Double.compare(that.balance, balance) != 0) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (cart != null ? !cart.equals(that.cart) : that.cart != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (taxId != null ? !taxId.equals(that.taxId) : that.taxId != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (cart != null ? cart.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (taxId != null ? taxId.hashCode() : 0);
        result = 31 * result + (isAdmin != null ? isAdmin.hashCode() : 0);
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
