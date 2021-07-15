import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;


public class BaseAuthService implements AuthService {
    private class Entry {// создание вложенного класса
        private String login;
        private String password;
        private String nick;// поля

        public Entry(String login, String password, String nick) { // конструктор вложенного класса
            this.login = login;
            this.password = password;
            this.nick = nick;
        }

        public String getLogin() {
            return login;
        }// реализация интерфейса у вложенного класса

        public String getPassword() {
            return password;
        }

        public String getNick() {
            return nick;
        }
    }

    private List<Entry> entries; //  List  содержащий образцы вложенного класса

    public BaseAuthService() {
        init();
    } // создание конструктора основного класса который вызывает  метод init();

    public int init() {
        entries = new ArrayList<>();
        entries.add(new Entry("login1", "pass1", "nick1"));
        entries.add(new Entry("login2", "pass2", "nick2"));
        entries.add(new Entry("login3", "pass3", "nick3"));
        return entries.size();// добавлено три экземпляра класса Entry, возвращает он размер, добавленного в этот Лист
    }

    @Override// реализация интерфейса для основного класса
    public String getNick(String login, String pass) {
        for (Entry e : entries) {
            if (e.getLogin().equals(login) && e.getPassword().equals(pass)) return e.getNick();
            // если логин и пароль е совпадает с введеными - всё ок. Иначе возвращает null.

        }
        return null;
    }

    @Override
    public boolean login(String login, String pass) {
        for (Entry e : entries) {
            if (e.getLogin().equals(login) && e.getPassword().equals(pass)) return true;
        }// если логин и пароль е совпадает с введеными - true. Иначе возвращает false.
        return false;
    }

    @Override
    public boolean contains(String userName) {
        if (userName == null || userName.trim().isEmpty()) return false;

        for (Entry e : entries) {
            if (userName.equals(e.getNick())) return true;
        }
        return false;
    }
}
