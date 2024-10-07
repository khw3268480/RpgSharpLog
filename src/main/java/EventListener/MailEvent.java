package EventListener;

import com.hj.rpgsharp.rpg.apis.database.RPGSharpDB;
import com.hj.rpgsharp.rpg.apis.rpgsharp.RPGSharpAPI;
import com.hj.rpgsharp.rpg.apis.rpgsharp.events.mailbox.MailSendEvent;
import org.bson.Document;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.EventListener;
import java.util.List;

public class MailEvent implements Listener {

    @EventHandler
    public void onMailSend(MailSendEvent e){
        RPGSharpDB mailLog = RPGSharpDB.getRPGSharpDB("MailLog");
        String target = e.getTarget();
        String player = e.getMail().getSender();
//        e.getMail().getSerializeItems().
        List<String> serializeItems = e.getMail().getSerializeItems();
        Document document = new Document("sendPlayer", player).append("receivedPlayer", target).append("mailItem", serializeItems);
        mailLog.insertOne(document);
        System.out.println("업로드 완료");
    }
}
