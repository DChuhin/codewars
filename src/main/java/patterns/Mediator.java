package main.java.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Очень удобный паттерн когда есть группа объектов общающихся между собой
 * топология звезда
 */
public class Mediator {
    public static void main(String[] args) {
        ChatMediator chat = new ChatMediator();
        ChatUser user1 = new SimpleChatUser("Serega", chat);
        chat.addUser(user1);
        ChatUser user2 = new SimpleChatUser("Vasya", chat);
        chat.addUser(user2);
        ChatUser user3 = new SimpleChatUser("Petr", chat);
        chat.addUser(user3);
        user1.sendMessage("вы гавно");
        user2.sendMessage("сам ты гавно");
        user3.sendMessage("внатуре");
    }
}

interface ChatUser {
    void sendMessage(String message);
    void acceptMessage(String message, ChatUser sender);
    String getName();
}

class SimpleChatUser implements ChatUser{
    String name;
    ChatMediator chatMediator;

    public SimpleChatUser(String name, ChatMediator chatMediator) {
        this.name = name;
        this.chatMediator = chatMediator;
    }

    @Override
    public void sendMessage(String message) {
        chatMediator.sendMessage(message, this);
    }

    @Override
    public void acceptMessage(String message, ChatUser sender) {
        System.out.println(this.name + " получил месагу от " + sender.getName() + " " + message);
    }

    @Override
    public String getName() {
        return name;
    }
}

class ChatMediator {
    List<ChatUser> users = new ArrayList<>();

    public void sendMessage(String message, ChatUser user) {
        users.stream().filter(u -> user != u).forEach(u -> u.acceptMessage(message, user));
    }

    void addUser(ChatUser user) {
        users.add(user);
    }
}
