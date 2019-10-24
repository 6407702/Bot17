package ru.hackathon.chatBot17.services.api;

import org.springframework.stereotype.Service;
import ru.hackathon.chatBot17.common.CommandTypes;
import ru.hackathon.chatBot17.common.ParsedCommand;

import java.net.URI;
import java.util.Map;
@Service
public class HelpServiceImpl implements HelpService{

        @Override
        public String  process(ParsedCommand parsedCommand) throws Exception {
                String result="";
                for (CommandTypes env : CommandTypes.values()) {
                        result=result + " "+ (env.getName());
                }

return   result;

        }



}
