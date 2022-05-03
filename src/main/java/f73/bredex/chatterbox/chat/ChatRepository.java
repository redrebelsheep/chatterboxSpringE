package f73.bredex.chatterbox.chat;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChatRepository extends CrudRepository<Chat,Chat> {


    List<Chat> findByRoom(String room);
}
