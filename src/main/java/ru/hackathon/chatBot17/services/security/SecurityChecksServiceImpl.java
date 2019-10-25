package ru.hackathon.chatBot17.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hackathon.chatBot17.common.UserRoles;
import ru.hackathon.chatBot17.db.entity.User;

/**
 * Class provides security policy for checking commands
 */
@Service
public class SecurityChecksServiceImpl implements SecurityChecksService {

    /**
     * @inheritDoc
     * //TODO: hard-code example. Fix it.
     */
    @Override
    public boolean checkSshCommandUserRights(User user, String command) {
        if (user != null) {
            UserRoles userRoles = UserRoles.getByRoleId(user.getRoleId());

            if (command.toUpperCase().equals("REBOOT") && userRoles != UserRoles.ADMIN) {
                return false;
            }
        }
        return true;
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean checkSshCommandInjection(String command) {
        //TODO: implement security rules for ssh commands.
        return true;
    }

    @Override
    public boolean checkJenkinsCommand(String command) {
        //TODO: implement security rules for jenkins commands.
        return true;
    }
}
