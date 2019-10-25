package ru.hackathon.chatBot17;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.hackathon.chatBot17.db.entity.Command;
import ru.hackathon.chatBot17.db.entity.Server;
import ru.hackathon.chatBot17.db.entity.TechUser;
import ru.hackathon.chatBot17.db.entity.Type;
import ru.hackathon.chatBot17.db.service.CommandService;
import ru.hackathon.chatBot17.db.service.ServerService;
import ru.hackathon.chatBot17.db.service.TechUserService;
import ru.hackathon.chatBot17.db.service.TypeService;

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

    private void clearAll() {

        commandService.removeAll();
        typeService.removeAll();
        serverService.removeAll();
        techUserService.removeAll();
    }

    @Test
    public void fillDataIn() {

        clearAll();

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
