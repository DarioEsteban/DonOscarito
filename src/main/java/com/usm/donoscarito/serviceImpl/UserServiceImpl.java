package com.usm.donoscarito.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usm.donoscarito.entities.User;
import com.usm.donoscarito.repository.UserRepository;
import com.usm.donoscarito.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

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
				//fieldToUpdate.setIdState(field.getIdState()); 
				userUpdate.setUserType(user.getUserType());
				userUpdate.setName(user.getName());
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

}
