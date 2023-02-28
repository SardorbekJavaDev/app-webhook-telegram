package com.company.appwebhooktelegram.controller;

import com.company.appwebhooktelegram.payload.ResultTelegram;
import com.company.appwebhooktelegram.service.TgService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.*;

import static com.company.appwebhooktelegram.constants.RestConstants.BOT_TOKEN;
import static com.company.appwebhooktelegram.constants.RestConstants.TELEGRAM_BASE_URL;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final TgService tgService;
    private final RestTemplate restTemplate;


    private Set<String> chatIdList = new HashSet<>(Arrays.asList("1438229631"));

    @PostMapping("/sendXabar")
    public String sendXabar(@RequestParam String text) {
        for (String chatID : chatIdList) {   // hohlasang habar jo'natishni bemalol servicega chiqarish mumkin
            SendMessage sendMessage = new SendMessage(chatID, text);
            ResultTelegram resultTelegram = restTemplate.postForObject(TELEGRAM_BASE_URL + BOT_TOKEN + "/sendMessage", sendMessage, ResultTelegram.class);
        }

        return "Xabar jo'natildi !";
    }
}
