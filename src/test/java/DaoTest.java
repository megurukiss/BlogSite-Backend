import com.meguru.blog.common.Result;
import com.meguru.blog.pojo.Blog;
import com.meguru.blog.pojo.User;
import com.meguru.blog.service.impl.BlogServiceImpl;
import com.meguru.blog.service.impl.UserServiceImpl;
import com.meguru.blog.util.JwtHelper;
import org.junit.Test;

import com.meguru.blog.dao.impl.UserDaoImpl;

import com.meguru.blog.util.WebUtil;
import java.util.List;
import static com.meguru.blog.util.WebUtil.getJson;

public class DaoTest {

    @Test
    public void test() {
        User user = new UserDaoImpl().getUserById(1);
        System.out.println(getJson(user));
    }

    @Test
    public void testGetRecent() {
        List<Blog> recentBlogs = new BlogServiceImpl().getRecentBlogs();
        System.out.println(getJson(Result.ok(recentBlogs)));
    }

    @Test
    public void testAddBlog() {
        Blog blog = new Blog();
        blog.setTitle("test2");
        blog.setContent("my second blog");
        blog.setUid(1);
        new BlogServiceImpl().addBlog(blog);
    }


    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("Meguru_kiss");
        user.setUserPwd("1213Fcz1016");
        user.setEmail("cristinajoster@gmail.com");
        new UserServiceImpl().addUser(user);
    }

    @Test
    public void testGetObjectFromJson() {
        String json = "{ \"email\":\"cristinajoster@gmail.com\", \"userPwd\":\"1213Fcz1016\" }";
        User user = WebUtil.getObjectFromJson(json, User.class);
        System.out.println(user);
    }

    @Test
    public void testCreateToken() {
        User user= new User();
        user.setUid(3);
        user.setEmail("cristinajoster@gmail.com");
        System.out.println(JwtHelper.createToken(user.getUid().longValue(), user.getEmail()));
    }
}

