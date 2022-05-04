package f73.bredex.chatterbox.chat.chat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ChatValidator implements ConstraintValidator<ValidChat,Chat> {

    private ChatRepository chatRepository;

    public ChatValidator(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public boolean isValid(Chat chat, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
