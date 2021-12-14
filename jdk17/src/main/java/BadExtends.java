import java.util.List;
import java.util.stream.Stream;

public class BadExtends {
}

class Condition {
    boolean isValidOnly() {return true;}

}

class User {
    boolean isValid() {
        return true;
    }
}

abstract class BaseUserService {
    Stream<User> getValidUsers() {
        return filterValidUsers(getAllUsers());
    }

    private Stream<User> getAllUsers() {
        // 実装略（データベースから取ってくる処理とかを想定）
        return Stream.of();
    }

    private Stream<User> filterValidUsers(Stream<User> users) {
        return users.filter(User::isValid);
    }
}

class UserSearchService extends BaseUserService {
    List<User> search(Condition condition) {
        Stream<User> users = getValidUsers();
        // 略...
        return users.toList();
    }
}

class UserBulkMessageService extends BaseUserService {
    void bulkSend() {
        var target = getValidUsers();
        doSend(target);
    }

    void doSend(Stream<User> users) {
        // 実装略
    }
}