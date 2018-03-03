package com.sapient.user;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sapient.models.Address;
import com.sapient.models.Role;
import com.sapient.models.User;

@Service
public class UserService {
	static List<User> users=new ArrayList<>();	
	static {		 	
		Address address=new Address();
		address.setContactNumber(8892749031l);
		address.setHouseNumber(31);
		address.setPinCode(12345);
		address.setStreetName("JayaNagar");
		
		Role user=new Role("user");
		Role admin=new Role("admin");
		List<Role> roles=new ArrayList<>();
		roles.add(user);roles.add(admin);
				
		User user1=new User();
		user1.setId(12);user1.setName("ishaan");user1.setRoles(roles);
		user1.setAddress(address);
		
		User user2=new User();		
		user2.setAddress(address);
		user2.setId(13);user2.setName("Mallu");user2.setRoles(roles);
		
		users.add(user1);users.add(user2);
	}
	
	public List<User> getAllUsers() {
		return users;
	}

	public User getUser(long id) {
		return users.stream().filter(e->e.getId()==id).findFirst().get();
	}

	public void update(User user) {
		User u=users.stream().filter(e->e.getId()==user.getId()).findFirst().get();
		u.setAddress(user.getAddress());
		u.setCart(user.getCart());
		u.setName(user.getName());
		u.setRoles(user.getRoles());		
	}
	
	public void create(User user) {
		User user1=new User();
		user1.setId(users.stream().max(Comparator.comparingLong(User::getId)).get().getId()+1);
		user1.setAddress(user.getAddress());
		user1.setCart(user.getCart());
		user1.setName(user.getName());
		user1.setRoles(user.getRoles());		
		users.add(user1);
	}

	public User delete(long id) {		
		User user=users.stream().filter(e->e.getId()==id).findAny().get();
		users.remove(user);
		return user;		
	}

}
