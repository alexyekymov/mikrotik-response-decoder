package dev.overlax.decoder.controllers;

import dev.overlax.decoder.models.Message;
import dev.overlax.decoder.services.DecoderService;
import dev.overlax.decoder.utils.DecoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/")
public class DecoderController {

    private final DecoderService service;

    @Autowired
    public DecoderController(DecoderService service) {
        this.service = service;
    }

    @ModelAttribute(name = "message")
    public Message message() {
        return new Message();
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @PostMapping
    public String create(@ModelAttribute("message") Message message) {
        String decoded = DecoderUtil.decode(message.getEncodedMessage());
        message.setDecodedMessage(decoded);
        message.setProcessedAt(new Date());
        service.save(message);

        return "index";
    }
}
