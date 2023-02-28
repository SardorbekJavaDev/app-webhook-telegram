package com.company.appwebhooktelegram.service;

import com.company.appwebhooktelegram.constants.RestConstants;
import com.company.appwebhooktelegram.payload.ResultTelegram;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.company.appwebhooktelegram.constants.RestConstants.BOT_TOKEN;
import static com.company.appwebhooktelegram.constants.RestConstants.TELEGRAM_BASE_URL;

@Service
@RequiredArgsConstructor
public class WebHookService {

    private final RestTemplate restTemplate;
    public void sendMessageWhenStart(Update update){
        SendMessage sendMessage = new SendMessage(update.getMessage().getChatId().toString(), "Salom jigar");
        ResultTelegram resultTelegram = restTemplate.postForObject(TELEGRAM_BASE_URL + BOT_TOKEN + "/sendMessage", sendMessage, ResultTelegram.class);
        System.out.println(resultTelegram);
    }
}
