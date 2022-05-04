package f73.bredex.chatterbox.chat.chat;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.PARAMETER;

@Constraint(validatedBy = RoomValidator.class)
@Target(PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRoom {

    String message() default "Diesen Raum gibt es nicht.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
