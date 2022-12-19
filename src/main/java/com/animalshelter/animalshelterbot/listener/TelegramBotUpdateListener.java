package com.animalshelter.animalshelterbot.listener;

import com.animalshelter.animalshelterbot.handler.MessageHandler;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TelegramBotUpdateListener implements UpdatesListener {
    private final MessageHandler messageHandler;
    private final TelegramBot telegramBot;

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> messageHandler.handle(update.message()));
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
}
