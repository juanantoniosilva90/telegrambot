package dev.silva.telegrambot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class TelegramBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        // Se obtiene el mensaje escrito por el usuario
        final String messageTextReceived = update.getMessage().getText();

        System.out.println("Escribieron en el bot " + messageTextReceived);

        // Se obtiene el id de chat del usuario
        final long chatId = update.getMessage().getChatId();

        // Se crea un objeto mensaje
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Gracias, por el momento no podemos atenderte, escribe *URGENTE* para notificarme o escribe a @antoniosilva9003");

        try {
            // Se envía el mensaje
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getBotUsername() {
        return "silvajuan_bot";
    }

    @Override
    public String getBotToken() {
        return "5991774005:AAFlQZP9y0KEZmShc8yxEnYRK7aeeUp_bvw";
    }
}
