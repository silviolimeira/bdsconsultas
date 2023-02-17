package com.devsuperior.uri2990.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.entities.Empregado;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {

	
//	select e.cpf, e.enome, d.dnome, d.dnumero, p.pnumero, p.pnome from empregados e
//	join departamentos d on d.dnumero = e.dnumero
//	left join trabalha t on t.cpf_emp = e.cpf
//	left join projetos p on t.pnumero = p.pnumero
//	where p.pnumero is null
//	order by e.cpf;
//
//	select e.cpf, e.enome, d.dnome from empregados e
//	join departamentos d on d.dnumero = e.dnumero
//	where e.cpf not in (
//		select e.cpf from empregados e
//		inner join trabalha t on t.cpf_emp = e.cpf
//	);

	@Query(nativeQuery = true, value = 
			"select e.cpf, e.enome, d.dnome from empregados e " +
			"join departamentos d on d.dnumero = e.dnumero " +
			"where e.cpf not in ( " +
			"  select e.cpf from empregados e " +
			"  inner join trabalha t on t.cpf_emp = e.cpf " +
			") " +
			"order by e.cpf"
		  )
	List<EmpregadoDeptProjection> queryNaoAlocadosN();	

	@Query( 
			"SELECT new com.devsuperior.uri2990.dto.EmpregadoDeptDTO(e.cpf, e.enome, e.departamento.dnome) " +
			"FROM Empregado e " +
			"WHERE e.cpf NOT IN ( " +
			"  SELECT e.cpf " +
			"  FROM Empregado e " +
			"  INNER JOIN e.projetosOndeTrabalha " +
			") " +
			"ORDER BY e.cpf"
		  )
	List<EmpregadoDeptDTO> queryNaoAlocados();	

	
}
