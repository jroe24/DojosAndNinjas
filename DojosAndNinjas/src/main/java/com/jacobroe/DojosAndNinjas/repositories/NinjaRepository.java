package com.jacobroe.DojosAndNinjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.jacobroe.DojosAndNinjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository <Ninja, Long>{

}