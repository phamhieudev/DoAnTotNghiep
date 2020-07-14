package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.VungXa;

public interface VungXaRepository<P> extends CrudRepository<VungXa, Long> {

	@Query(value = "SELECT * FROM vungtdm WHERE ST_Intersects(geom, ST_SetSRID(ST_MakePoint(:x,:y),4326))", nativeQuery = true)	
	VungXa selectxy(@Param("x") float x,@Param("y") float y);
}
