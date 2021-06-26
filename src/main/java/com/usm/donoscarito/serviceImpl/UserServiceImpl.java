package com.usm.donoscarito.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usm.donoscarito.entities.User;
import com.usm.donoscarito.repository.UserRepository;
import com.usm.donoscarito.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@PersistenceContext
	EntityManager entityManager;
	  
	@Override
	public void save(User user) {
		userRepository.save(user);
	}
 
	@Override
	public void update(User user) {
		// Armar PK compuesta
		// Validar existencia de elemento
		if (userRepository.existsById(user.getIdUser())) {
			// Rescatar reserva
			Optional<User> userToUpdate = userRepository.findById(user.getIdUser());
			if(userToUpdate.isPresent()) {
				// Configurar clase
				User userUpdate = userToUpdate.get();
				
				if(user.getUserType() != null) {
					userUpdate.setUserType(user.getUserType());
				}
				if(user.getEmail() != null) {
					userUpdate.setEmail(user.getEmail());
				}
				
				if(user.getName() != null) {
					userUpdate.setName(user.getName());
				}
				
				if(user.getLastName()!= null) {
					userUpdate.setLastName(user.getLastName());
				}
				
				if(user.getPhone() != null) {
					userUpdate.setPhone(user.getPhone());
				}
				
				if(user.getPassword() != null) {
					userUpdate.setPassword(user.getPassword());
				}
				// Modificar
				userRepository.save(userUpdate);
			}
			
		} else {
			throw new IllegalArgumentException("No existe Usuario.");
		}
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public List<User> findByEmailPassword(String email, String pass) {
		@SuppressWarnings("unchecked")
		List<User> userList = entityManager.createQuery("Select u from User u where u.email = ?1 and u.password = ?2")
		.setParameter(1, email)
		.setParameter(2, pass)
		.getResultList();
		
		return userList;
	}

}
