package com.company.appwebhooktelegram.controller;

import com.company.appwebhooktelegram.service.TgService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
@RequestMapping("/api/telegram")
@RequiredArgsConstructor
public class WebHookController {

    private final TgService tgService;

    @PostMapping
    public void getUpdate(@RequestBody Update update) {
//       telegramdan kelgan object
        System.out.println(update);
        tgService.awaitUpdate(update);
    }
}
