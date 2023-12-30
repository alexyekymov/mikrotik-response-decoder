package dev.overlax.decoder.controllers;

import dev.overlax.decoder.models.Message;
import dev.overlax.decoder.services.DecoderService;
import dev.overlax.decoder.utils.DecoderUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@Slf4j
@CrossOrigin("https://ovelrax.pp.ua")
@RequestMapping(
        path = "/decoder/api/v1/decode",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class DecoderController {

    private final DecoderService service;

    @Autowired
    public DecoderController(DecoderService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> update(@RequestBody Message message) {

        String decoded = DecoderUtil.decode(message.getEncodedMessage());
        message.setDecodedMessage(decoded);
        message.setProcessedAt(new Date());
        service.save(message);
        log.info("Received and saved new message: {}", message);

        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
}
