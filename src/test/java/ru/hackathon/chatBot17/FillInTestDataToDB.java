package ru.hackathon.chatBot17;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.hackathon.chatBot17.common.UserRoles;
import ru.hackathon.chatBot17.db.entity.*;
import ru.hackathon.chatBot17.db.service.*;

@SpringBootTest
public class FillInTestDataToDB {

    @Autowired
    private CommandService commandService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private ServerService serverService;

    @Autowired
    private TechUserService techUserService;

    @Autowired
    private UserService userService;

    private void clearAll() {

        commandService.removeAll();
        typeService.removeAll();
        serverService.removeAll();
        techUserService.removeAll();
    }

    @Test
    public void fillDataIn() {

        clearAll();

        userService.save(new User("Alex", UserRoles.USER.getCode()));

        //types
        typeService.save(new Type("SSH"));
        typeService.save(new Type("JNK"));
        typeService.save(new Type("GIT"));

        //commands
        commandService.save(new Command("uptime", "uptime",
                1, "Получить время работы сервера: /ssh uptime <код сервера>"));

        commandService.save(new Command("pwd", "pwd",
                1, "Получить текущую директорию: /ssh uptime <код сервера>"));

        commandService.save(new Command("help", "help",
                4, "help - Вывести информацию о возможных командах: /help"));

        //tech user
        TechUser techUser = new TechUser("bot", "");
        techUserService.save(techUser);

        //servers
        serverService.save(new Server("62.109.7.2", "22", techUser, "IFT"));
    }
}
