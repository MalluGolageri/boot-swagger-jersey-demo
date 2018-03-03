package com.sapient.user;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.models.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/user-service")
@Api(value="user resource", produces=MediaType.APPLICATION_JSON)
public class UserController {	
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "")
	@GET
	@Path("/user/")
	public List<User> getAllUsers() {		
		return userService.getAllUsers();
	}
	
	@ApiOperation(value = "")
	@GET
	@Path("/user/{id}")
	public User getUser( @PathParam("id") long userId) {				
		return userService.getUser(userId);
	}
	
	@ApiOperation(value = "")
	@PUT
	@Path("/user/")
	public void update(User user) {		
		userService.update(user);
	}
	
	@ApiOperation(value = "")
	@POST
	@Path("/user/")
	public void create(User user) {		
		userService.create(user);
	}
	
	@ApiOperation(value = "")
	@DELETE
	@Path("/user/{id}")
	public User delete(@PathParam ("id") long id) {		
		return userService.delete(id);
	}
}
