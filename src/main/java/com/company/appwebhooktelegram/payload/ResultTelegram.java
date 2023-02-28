package com.company.appwebhooktelegram.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Message;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultTelegram {
//    {ok=true, result={message_id=11, from={id=6147458938, is_bot=true, first_name=WebhookExample, username=masterclassbysirojiddinecmabot}, chat={id=1438229631, first_name=Sardorbek, last_name=Yorkulov, username=Sardorbek_Rakhmatjonov, type=private}, date=1677564037, text=Salom jigar}}

    private boolean ok;
    private Message result;

}
