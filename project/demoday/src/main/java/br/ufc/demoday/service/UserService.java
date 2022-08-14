package br.ufc.demoday.service;
import br.ufc.demoday.repository.UserRepository;
import br.ufc.demoday.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

//Anotação @Sevice para referenciar camada de Negócio
@Service
public class UserService {
  
	//Injeção automática de dependências spring na interface UserRepository
	@Autowired
    UserRepository userRepository;

	//Tratativas vindas da camada controller,  Classe UserController
	
    public void save(int idUser, User entity){
        
    	User user =  new User();
    	
    	if (idUser != 0) {
  
    		entity.setIdUSer(idUser); 
            user.setName(entity.getName());
    		user.setAddress(entity.getAddress());
            user.setCpf(entity.getCpf());
            user.setEmail(entity.getEmail());
            user.setPassword(entity.getPassword());
            user.setPhone(entity.getPhone());
            userRepository.save(entity);
    	}
        
        
    }

    public void update(int idUser, User entity){
        

		// Falta finalizar esse método pois é preciso que a classe User esteja pronta
        User user = new User();
    	
    	if (idUser != 0) {
    		 
            user.setName(entity.getName());
    		user.setAddress(entity.getAddress());
            user.setCpf(entity.getCpf());
            user.setEmail(entity.getEmail());
            user.setPassword(entity.getPassword());
            user.setPhone(entity.getPhone());
            userRepository.save(entity);
    	}
       
    }

    public User find(int idUser){
        if(idUser == 0){
            return null;
        }
        Optional<User> user = userRepository.findById(idUser);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    public ArrayList<User> findAll(){
        return (ArrayList<User>) userRepository.findAll();
    }

    public void delete(int idUser){
        User user = find(idUser);  
        if(idUser!= 0){
            userRepository.delete(user); 
        }
    }
}
