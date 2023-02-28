package com.company.appwebhooktelegram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class TgService {
    private final WebHookService webHookService;

    public void awaitUpdate(Update update) {
        if (update.hasMessage()) {
            String text = update.getMessage().getText();
            switch (text) {
                case "/start" -> webHookService.sendMessageWhenStart(update);
            }
        }
    }
}
