package com.animalshelter.animalshelterbot.service;

import com.animalshelter.animalshelterbot.exception.BotNotFoundException;
import com.animalshelter.animalshelterbot.model.BotUser;
import com.animalshelter.animalshelterbot.repository.BotUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <i>Сервис для сохранения или получания контактных данных пользователя</i>
 */

@Service
@RequiredArgsConstructor
public class BotUserService {
    private final BotUserRepository botUserRepository;

    public BotUser addBotUser(BotUser botUser) {
        return botUserRepository.save(botUser);
    }

    public BotUser getBotUserByChatId(Long id) {
        return botUserRepository.findBotUserByChatId(id);
    }

    public BotUser getBotUser(Long id) {
        Optional<BotUser> getBotUser = botUserRepository.findById(id);
        if (getBotUser.isEmpty()) {
            throw new BotNotFoundException();
        }
        return getBotUser.get();
    }

    public void deleteBotUser(Long id) {
        botUserRepository.deleteById(id);
    }

    public BotUser editBotUser(BotUser botUser) {
        return botUserRepository.save(botUser);
    }
}
