package f73.bredex.chatterbox.chat.chat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RoomValidator implements ConstraintValidator<ValidRoom,String> {

    private RoomRepository roomRepository;

    public RoomValidator(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public boolean isValid(String room, ConstraintValidatorContext constraintValidatorContext) {
        return roomRepository.findALlRooms().contains(room);
    }
}
