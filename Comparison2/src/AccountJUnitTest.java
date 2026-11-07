import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AccountJUnitTest {

    @Test
    void nameIsNullByDefault() {
        Account account = new Account();

        assertNull(account.getName());
    }

    @Test
    void setNameThenGetNameReturnsSameValue() {
        Account account = new Account();

        account.setName("Maria");

        assertEquals("Maria", account.getName());
    }

    @Test
    void setNameOverwritesPreviousValue() {
        Account account = new Account();
        account.setName("Maria");

        account.setName("João");

        assertEquals("João", account.getName());
    }

    @Test
    void setNameWithEmptyStringIsAccepted() {
        Account account = new Account();

        account.setName("");

        assertEquals("", account.getName());
    }

    @Test
    void setNameWithNullResetsToNull() {
        Account account = new Account();
        account.setName("Maria");

        account.setName(null);

        assertNull(account.getName());
    }
}
