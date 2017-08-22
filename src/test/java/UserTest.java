
import com.key.mybatis.MybatisUtil;
import com.key.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class UserTest {

    SqlSession sqlSession;

    @Test
    public void insertUser() {
        sqlSession = MybatisUtil.getSqlSession();
        int id = 2;
        String userName = "test";
        String nickName = "testNickname";
        String password = "test";

        String email = "abcderf@qq.com";
        User user = new User();
        user.setUid(id);
        user.setNickname(nickName);
        user.setUsername(userName);
        user.setPassword(password);
        user.setEmail(email);
        try {
            sqlSession.insert("insertUser", user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }

    @Test
    public void findById() {
        sqlSession = MybatisUtil.getSqlSession();
        int id = 0;
        try {
            User user = sqlSession.selectOne("findById", id);

            sqlSession.commit();
            System.out.println(user.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }

    public static void main(String[] args) {
        UserTest newUser = new UserTest();
//        newUser.insertUser();
        newUser.findById();
    }
}