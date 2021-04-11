/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.spring.dev.home.AuthApp.model;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.dev.home.AuthApp.model.audit.DateAudit;
import com.spring.dev.home.AuthApp.validation.annotation.NullOrNotBlank;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "USER")
public class User extends DateAudit {

	private static final long serialVersionUID = 1L;
	
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", allocationSize = 1)
    private Long id;

    @NaturalId
    @Column(name = "EMAIL", unique = true)
    @NotBlank(message = "User email cannot be null")
    private String email;

    @Column(name = "USERNAME", unique = true)
    @NullOrNotBlank(message = "Username can not be blank")
    private String username;

    @Column(name = "PASSWORD")
    @NotNull(message = "Password cannot be null")
    private String password;

    @Column(name = "FIRST_NAME")
    @NullOrNotBlank(message = "First name can not be blank")
    private String firstName;
    
    @Column(name = "ADDRESSE")
    @NullOrNotBlank(message = "adresse can not be blank")
    private String adresse;
    
    @Column(name = "telephone")
    @NullOrNotBlank(message = "telephone can not be blank")
    private String telephone;

    @Column(name = "LAST_NAME")
    @NullOrNotBlank(message = "Last name can not be blank")
    private String lastName;
    
    @Column(name = "phone_Number")
    @NullOrNotBlank(message = "Last name can not be blank")
    private String phoneNumber;
    
    @Column(name = "postal_Code")
    @NullOrNotBlank(message = "Last name can not be blank")
    private String postalCode;

    @Column(name = "IS_ACTIVE", nullable = false)
    private Boolean active;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "USER_AUTHORITY", joinColumns = {
            @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")}, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")})
    private Set<Role> roles = new HashSet<>();

    @Column(name = "IS_EMAIL_VERIFIED", nullable = false)
    private Boolean isEmailVerified;
    
    @OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	private List<Property> property;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	private List<Favorite> favoris=new ArrayList<Favorite>();

	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	private List<Wish> wish;
	
	public void addWish(Wish W)
	{
		W.setUser(this);
		this.wish.add(W);
	}
	
	public void removeWish(Wish W)
	{
		W.setUser(null);
		this.wish.remove(W);
	}

    public User() {
        super();
    }

    public User(User user) {
        id = user.getId();
        username = user.getUsername();
        password = user.getPassword();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        email = user.getEmail();
        active = user.getActive();
        roles = user.getRoles();
        isEmailVerified = user.getEmailVerified();
    }

    public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public User(Long id, @NotBlank(message = "User email cannot be null") String email, String username,
			@NotNull(message = "Password cannot be null") String password, String firstName, String adresse,
			String telephone, String lastName, String phoneNumber, String postalCode, Boolean active, Set<Role> roles,
			Boolean isEmailVerified) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.adresse = adresse;
		this.telephone = telephone;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.postalCode = postalCode;
		this.active = active;
		this.roles = roles;
		this.isEmailVerified = isEmailVerified;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void addRole(Role role) {
        roles.add(role);
        role.getUserList().add(this);
    }

    public void addRoles(Set<Role> roles) {
        roles.forEach(this::addRole);
    }

    public void removeRole(Role role) {
        roles.remove(role);
        role.getUserList().remove(this);
    }

    public void markVerificationConfirmed() {
        setEmailVerified(true);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> authorities) {
        roles = authorities;
    }

    public Boolean getEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    @Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", firstName=" + firstName + ", adresse=" + adresse + ", telephone=" + telephone + ", lastName="
				+ lastName + ", phoneNumber=" + phoneNumber + ", postalCode=" + postalCode + ", active=" + active
				+ ", roles=" + roles + ", isEmailVerified=" + isEmailVerified + "]";
	}
    
    public List<Property> getProperty() {
		return property;
	}




	public void setProperty(List<Property> property) {
		this.property = property;
	}
	
	public void addProperty(Property aa)
	{
		this.property.add(aa);
		aa.setUser(this);
	}
	
	@JsonManagedReference(value="user-favoris")
	public List<Favorite> getFavoris() {
		return favoris;
	}

	public void setFavoris(List<Favorite> favoris) {
		this.favoris = favoris;
	}



	@JsonManagedReference(value="user-wish")
	public List<Wish> getWish() {
		return wish;
	}

	public void setWish(List<Wish> wish) {
		this.wish = wish;
	}
	
	
	public void addFavorite(Favorite F)
	{
		F.setUser(this);
		this.favoris.add(F);
	}


}
