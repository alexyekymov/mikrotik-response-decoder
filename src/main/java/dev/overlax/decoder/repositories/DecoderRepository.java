package dev.overlax.decoder.repositories;

import dev.overlax.decoder.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecoderRepository extends JpaRepository<Message, Integer> {
}
