package lab.phb.mhsangularb.repo;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import lab.phb.mhsangularb.entity.Penulis;

@Repository
public interface PenulisRepo 
	extends JpaRepository<Penulis, String>
{

	Penulis findOneById(String id);
	
}