//public class UserTest {
//
//    SqlSession sqlSession ;
//    @Test
//    public void insertUser(){
//        sqlSession = MybatisUtil.getSqlSession();
//        int id = 10000;
//        String userName = "test";
//        int age = 18;
//        String mobilePhone = "18000000000";
//        User user = new User();
//        user.setId(id);
//        user.setAge(age);
//        user.setUserName(userName);
//        user.setMobilePhone(mobilePhone);
//        try{
//            sqlSession.insert("insertUser",user);
//            sqlSession.commit();
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            MybatisUtil.closeSession(sqlSession);
//        }
//
//    }
//
//    @Test
//    public void queryById(){
//        sqlSession = MybatisUtil.getSqlSession();
//        int id = 1;
//        try{
//            User user = sqlSession.selectOne("queryById",id);
//
//            sqlSession.commit();
//            System.out.println(user.getUserName());
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            MybatisUtil.closeSession(sqlSession);
//        }
//
//    }
//}