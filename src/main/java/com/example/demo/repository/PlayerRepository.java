package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import com.example.demo.dto.RoleCountDTO;
import com.example.demo.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

	@Query("""
		       SELECT new com.example.demo.dto.RoleCountDTO(
		           p.role,
		           COUNT(p)
		       )
		       FROM Player p
		       WHERE p.teamName = :teamName
		       GROUP BY p.role
		       """)
		List<RoleCountDTO> getPlayerCountByRole(@Param("teamName") String teamName);

}