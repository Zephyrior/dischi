package it.epicode.dischi.canzoni;


import org.springframework.data.jpa.repository.JpaRepository;

public interface CanzoneRepository extends JpaRepository<Canzone, Long> {
}