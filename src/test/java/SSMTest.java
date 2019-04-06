import com.naturemobility.kernel.entity.User;
import com.naturemobility.kernel.mapper.UserMapper;
import com.naturemobility.kernel.service.IUserService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mybatis.xml" })
public class SSMTest {
    private static Logger logger = LoggerFactory.getLogger(SSMTest.class);
    @Resource
    private IUserService userService;

    @Test
    public void testUser(){
        logger.info("========================Test Begin===========================");
        User user = new User("testUser","123456");
        Boolean insertResult = userService.addUser(user);
        Assert.assertTrue(insertResult);
        int userId = user.getId();
        User userFind = userService.getUserById(userId);
        Assert.assertNotNull(userFind);
        userFind.setUserName("newUser");
        Boolean updateResult = userService.updateUser(userFind);
        Assert.assertTrue(updateResult);
        Assert.assertEquals("newUser",userService.getUserById(userId).getUserName());
        logger.info("========================Test End ===========================");

    }
}
