package com.jacobroe.DojosAndNinjas.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.jacobroe.DojosAndNinjas.models.Dojo;
import com.jacobroe.DojosAndNinjas.models.Ninja;
import com.jacobroe.DojosAndNinjas.repositories.DojoRepository;
import com.jacobroe.DojosAndNinjas.repositories.NinjaRepository;

@Service
public class DojoAndNinjaServices {
	private final DojoRepository dojoRepository;
	private final NinjaRepository ninjaRepository;
	
	public DojoAndNinjaServices(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
		this.dojoRepository = dojoRepository;
		this.ninjaRepository = ninjaRepository;
	}

	public void addDojo(Dojo dojo) {
		dojoRepository.save(dojo);
	}
	
	public List<Dojo> getAllDojos() {
		return dojoRepository.findAll();
	}
	
	public Dojo singleDojo(Long id) {
		Optional<Dojo> dojo = dojoRepository.findById(id);
		if(dojo.isPresent()) {
			return dojo.get();
		}
		else {
			return null;
		}
	}
	
	public void addNinja(Ninja ninja) {
		ninjaRepository.save(ninja);
	}
}