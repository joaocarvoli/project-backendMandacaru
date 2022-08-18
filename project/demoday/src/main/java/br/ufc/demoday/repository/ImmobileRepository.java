package br.ufc.demoday.repository;
import br.ufc.demoday.model.Immobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



//Anotação @Repository na Interface ImmobileRepository extendendo a interface JpaRepository e delegando a gerencia dos dados 
@Repository
public interface ImmobileRepository extends JpaRepository<Immobile, Integer>{
	
}
