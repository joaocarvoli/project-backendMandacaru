package br.ufc.demoday.repository;
import br.ufc.demoday.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;


//Anotação @Repository na Interface AdRepository extendendo a interface JpaRepository e delegando a gerencia dos dados 

@Repository
public interface AdRepository extends JpaRepository<Ad, Integer>{
    @Query(value = "SELECT * FROM ad WHERE NOT ad_status='pending'", nativeQuery = true)
    ArrayList<Ad> findNotPending();
    @Query(value = "SELECT * FROM ad WHERE NOT ad_status='pending' AND id_ad=?1", nativeQuery = true)
    Ad findNotPendingById(int idAd);
}
