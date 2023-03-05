package dev.overlax.decoder.controllers;

import dev.overlax.decoder.models.Message;
import dev.overlax.decoder.services.DecoderService;
import dev.overlax.decoder.utils.DecoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/decoder")
public class DecoderController {

    private final DecoderService service;

    @Autowired
    public DecoderController(DecoderService service) {
        this.service = service;
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @PostMapping
    public String create(@ModelAttribute("encoded") String encoded, Model model) {
        Message message = new Message();
        message.setEncodedMessage(encoded);
        message.setDecodedMessage(DecoderUtil.decode(encoded));
        message.setProcessedAt(new Date());
        service.save(message);

        model.addAttribute("decoded", message.getDecodedMessage());

        return "index";
    }
}
