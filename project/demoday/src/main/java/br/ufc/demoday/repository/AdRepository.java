package br.ufc.demoday.repository;
import br.ufc.demoday.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Anotação @Repository na Interface AdRepository extendendo a interface JpaRepository e delegando a gerencia dos dados 

@Repository
public interface AdRepository extends JpaRepository<Ad, Integer>{
}
