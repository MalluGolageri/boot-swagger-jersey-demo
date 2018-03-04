package com.sapient.user;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.models.Address;
import com.sapient.models.Cart;
import com.sapient.models.Product;
import com.sapient.models.Role;
import com.sapient.models.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	static List<User> users=new ArrayList<>();	
	static {		 	
		Address address=new Address();
		address.setContactNumber(8892749031l);address.setHouseNumber(31);address.setPinCode(12345);address.setStreetName("JayaNagar");
		
		Product product=new Product();
		product.setId(101);product.setName("Macbook Pro");product.setPrice(155000);product.setQuantity(1);
		
		Product product2=new Product();
		product2.setId(102);product2.setName("Macbook Air");product2.setPrice(95000);product2.setQuantity(1);
		
		List<Product> products=new ArrayList<>();
		products.add(product);products.add(product2);
		
		Cart cart=new Cart();
		cart.setProducts(products);cart.setQuantity(products.size());
		
		Role user=new Role("user");
		Role admin=new Role("admin");
		List<Role> roles=new ArrayList<>();
		roles.add(user);roles.add(admin);
				
		User user1=new User();
		user1.setId(12);user1.setName("Ishaan");user1.setRoles(roles);user1.setAddress(address);user1.setCart(cart);
		
		User user2=new User();		
		user2.setAddress(address);user2.setId(13);user2.setName("Bharat");user2.setRoles(roles);user2.setCart(cart);
		
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
