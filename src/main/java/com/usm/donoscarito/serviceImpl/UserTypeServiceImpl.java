package com.usm.donoscarito.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usm.donoscarito.entities.User;
import com.usm.donoscarito.entities.UserType;
import com.usm.donoscarito.repository.UserTypeRepository;
import com.usm.donoscarito.service.UserTypeService;

@Service
public class UserTypeServiceImpl implements UserTypeService {

	@Autowired
	UserTypeRepository userTypeRepository;

	@Override
	public List<UserType> findAllUsersTypes() {
		// TODO Auto-generated method stub
		return userTypeRepository.findAll();
	}

	@Override
	public void update(UserType userType) {
		// Validar existencia de elemento
		if (userTypeRepository.existsById(userType.getIdUserType())) {
			//Obtiene el registro que se quiere modificar
			Optional<UserType> userTypeToUpdate = userTypeRepository.findById(userType.getIdUserType());
			if(userTypeToUpdate.isPresent()) {
				// Configurar clase
				UserType userTypeUpdate = userTypeToUpdate.get();
				
				if(userType.getDescription() != null) {
					userTypeUpdate.setDescription(userType.getDescription());
				}
				// Modificar
				userTypeRepository.save(userTypeUpdate);
			}
			
		} else {
			throw new IllegalArgumentException("No existe Usuario.");
		}
		
	}

	@Override
	public void save(UserType userType) {
		userTypeRepository.save(userType);	
	}
}
