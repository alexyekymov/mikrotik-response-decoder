package dev.overlax.decoder.services;

import dev.overlax.decoder.models.Message;
import dev.overlax.decoder.repositories.DecoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class DecoderService {
    private final DecoderRepository repository;

    @Autowired
    public DecoderService(DecoderRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void save(Message message) {
        repository.save(message);
    }
}
