import com.alex.entity.Student;
import com.alex.mapper.StudentMapper;
import com.alex.utils.MybatisUtil;
import lombok.extern.java.Log;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.*;

import java.util.logging.Level;

@Log
public class MainTest {
    @BeforeAll
    public static void getSqlSession() {
        SqlSession sqlSession = MybatisUtil.getSqlSession(true);

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student studentById = studentMapper.getStudentById(2);

        System.out.println("studentById = " + studentById);
    }

    @Test
    @DisplayName("Compare two arrays")
    public void test() {
        log.log(Level.INFO, "Test demo");

        System.out.println("test");
        Assertions.assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});
    }
}
