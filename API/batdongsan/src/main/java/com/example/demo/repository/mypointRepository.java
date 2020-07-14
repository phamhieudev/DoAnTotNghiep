package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Sanpham_cty;
import com.example.demo.entity.mypoint;


public interface mypointRepository<P> extends JpaRepository<mypoint, Long> {

	
	@Modifying
	@Query(value = "insert into test (id,geom,name,url) values (:id,ST_SetSRID(ST_MakePoint(:x, :y), 4326),:name,:url)", nativeQuery = true)
	@Transactional
	void addSPCTY( @Param("id") Integer id,@Param("x") float x, @Param("y") float y,@Param("name") String ten,@Param("url") String url);
	
//	 @Query(value = "SELECT t.id,t.name,t.geom FROM mypoints t WHERE t.id=?1",nativeQuery=true)
//	 List<mypoint> findById(Integer id);
	@Query(value="SELECT id FROM mypoints w WHERE w.id = ?1",nativeQuery = true)
	List<mypoint> findOneById(Long id);
	
	@Modifying
	@Query(value = "update test set id=:id,geom=ST_SetSRID(ST_MakePoint(:x, :y), 4326),name=:name where id =:id1", nativeQuery = true)	@Transactional
	void updateSPCTY( @Param("id") Integer id,@Param("x") float x, @Param("y") float y,@Param("name") String ten,@Param("id1") Integer id1);
}
