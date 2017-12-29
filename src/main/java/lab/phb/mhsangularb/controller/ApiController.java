package lab.phb.mhsangularb.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import lab.phb.mhsangularb.repo.PenulisRepo;
import lab.phb.mhsangularb.entity.Penulis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication
.logout.SecurityContextLogoutHandler;
 

@RestController
public class ApiController {

	@Autowired
	private PenulisRepo penulisRepo;

	@RequestMapping("/get-nama")
	public Map<String, Object> getNama() {
		Map<String, Object> result = new HashMap<>();
		result.put("nama", "azka");
		return result;
	}

	@RequestMapping("/ambil-nama/{nama}")
	public Map<String, Object> ambilNama(
			@PathVariable("nama") String nama) {
		Map<String, Object> result = new HashMap<>();
		result.put("nama", nama);
		return result;
	}

	@RequestMapping("/set-nama")
	public Map<String, Object> setNama(
			@RequestParam("nama") String nama) {
		Map<String, Object> result = new HashMap<>();
		result.put("nama", nama);
		return result;
	}


	// -- aplikasi mahasiswa

	@RequestMapping("/daftar-penulis")
	public List<Penulis> getDaftarPenulis() {
		return penulisRepo.findAll();
	}

	@RequestMapping(value = "/simpan", method = RequestMethod.POST)
	public void simpan(@RequestBody Penulis mhs) {
		//System.out.println("nim : " + mhs.getNim());
		//System.out.println("nama : " + mhs.getNama());
		//System.out.println("jurusan : " + mhs.getJurusan());
		penulisRepo.save(mhs);
	}

	@RequestMapping("/ambil-data-pns/{id}")
	public Penulis getDataPns(@PathVariable("id") String id) {
		//System.out.println("nim : " + nim);
		//return null;
		return penulisRepo.findOneById(id);
	}

	@RequestMapping(value = "/hapus/{id}", method = RequestMethod.DELETE)
	public void hapus(@PathVariable("id") String id) {
		penulisRepo.delete(id);
	}

	@RequestMapping("/logout")
	public void logout(HttpServletRequest req,
		HttpServletResponse resp){
		Authentication auth =
		SecurityContextHolder.getContext()
		.getAuthentication();
		new SecurityContextLogoutHandler().logout(req, resp, auth);
	}

	
}