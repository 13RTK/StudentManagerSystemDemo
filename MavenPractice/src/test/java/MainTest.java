import com.alex.utils.EditLogger;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;

@Log
public class MainTest {
    @Test
    public void logTest() {
        EditLogger.insertLogPrint("John");
    }
}
