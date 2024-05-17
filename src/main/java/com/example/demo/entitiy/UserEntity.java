package com.example.demo.entitiy;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String username;
	String email;
	String password;
	String gender;
	String role;
	String address;
	boolean isPremiumCustomer;
	@OneToMany
	List<PlayListEntitiyCustomer> useEntitiyCustomers;
	
	public UserEntity() {
		super();
	}

	public UserEntity(int id, String username, String email, String password, String gender, String role,
			String address, boolean isPremiumCustomer, List<PlayListEntitiyCustomer> useEntitiyCustomers) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.role = role;
		this.address = address;
		this.isPremiumCustomer = isPremiumCustomer;
		this.useEntitiyCustomers = useEntitiyCustomers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isPremiumCustomer() {
		return isPremiumCustomer;
	}

	public void setPremiumCustomer(boolean isPremiumCustomer) {
		this.isPremiumCustomer = isPremiumCustomer;
	}

	public List<PlayListEntitiyCustomer> getUseEntitiyCustomers() {
		return useEntitiyCustomers;
	}

	public void setUseEntitiyCustomers(List<PlayListEntitiyCustomer> useEntitiyCustomers) {
		this.useEntitiyCustomers = useEntitiyCustomers;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", role=" + role + ", address=" + address + ", isPremiumCustomer="
				+ isPremiumCustomer;
//		+ ", useEntitiyCustomers=" + useEntitiyCustomers + "]";
	}
	
}
