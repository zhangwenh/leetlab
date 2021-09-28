package io.rdk.leetlab.yqTest.p1;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Case_1_1 {
    interface IPlayer{
        public String getPlayerName();
        // 收消息
        public void recieveMessage(Message message);
        // 请求支援
        public void requestSupport(AbstraceTeam team);
    }
    enum MessageType{
        // todo 1
        NEED_SUPPORT,
        OUT,
        IN;
    }

    static class Message{
        public final MessageType type;
        public final IPlayer player;
        public Message(MessageType type,IPlayer player){
            this.type = type;
            this.player = player;
        }
    }
    static class Player implements IPlayer {
        private final String playerName;

        // todo 2
        public Player(String playerName) {
            this.playerName = playerName;
        }

        @Override
        public String getPlayerName() {
            return playerName;
        }

        // end
        public void recieveMessage(Message message) {
            if (message.type == MessageType.NEED_SUPPORT) {
                System.out.println(playerName + "1111..." + message.player.getPlayerName());
            } else if (message.type == MessageType.OUT) {
                System.out.println(playerName + "2222..." + message.player.getPlayerName());
            } else if (message.type == MessageType.IN) {
                System.out.println(playerName + "3333..." + message.player.getPlayerName());
            } else {
                System.out.println(playerName + "4444..." + message.player.getPlayerName());
            }
        }

        // todo 3
        @Override
        public void requestSupport(AbstraceTeam team) {
            team.sendMessage(new Message(MessageType.NEED_SUPPORT, this));
        }
    }
    static abstract class AbstraceTeam {
        protected final String teamName;
        protected final List<IPlayer> players;

        public AbstraceTeam(String teamName, List<IPlayer> players) {
            this.teamName = teamName;
            this.players = players;

        }
        // todo 4
        private void sendMessage(Message msg) {
            for (IPlayer p : players) {
                if (p.equals(msg.player)) {
                    // 自己不需要知道消息
                    continue;
                }
                p.recieveMessage(msg);
            }
        }


        public void quit(IPlayer hero1) {
        }

        static class ConcreteTeam(String teamName) extends AbstraceTeam {
            public ConcreteTeam(String teamName){
                super(teamName,new ArrayList<>());
            }
        }
        public static void main(String args[]){
            IPlayer hero1,hero2,hero3,hero4,hero5;
            AbstraceTeam teamControl;
            teamControl = new ConcreteTeam("银河战队");
            hero1 = new Player("队员1");
            hero2 = new Player("队员2");
            hero3 = new Player("队员3");
            hero4 = new Player("队员4");
            hero5 = new Player("队员5");

            hero1.recieveMessage(teamControl);
            teamControl.quit(hero1);
        }
}