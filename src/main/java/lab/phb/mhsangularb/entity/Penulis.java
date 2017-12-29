package lab.phb.mhsangularb.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Entity
public class Penulis {

	@Id @Getter @Setter
	private String id;
	@Getter @Setter
	private String nama;
	@Getter @Setter
	private String judul_buku;
	
}