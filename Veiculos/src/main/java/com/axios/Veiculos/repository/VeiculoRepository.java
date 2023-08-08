package com.axios.Veiculos.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.axios.Veiculos.models.Veiculo;

public interface VeiculoRepository extends PagingAndSortingRepository<Veiculo, Integer>{

	
	@Query("FROM Veiculo v " +
	           "WHERE LOWER(v.veiculo) like %:filtro% " +
	           "OR LOWER(v.marca) like %:filtro%")
	    List<Veiculo> findByFilter(
	            @Param("filtro") String filtro);
}
