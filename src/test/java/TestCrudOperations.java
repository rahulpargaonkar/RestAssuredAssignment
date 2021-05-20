
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import requestEntity.User;
import responseEntity.UserResponse;
import tests.Client;
import io.restassured.response.Response;

public class TestCrudOperations {
    private Response response;
    private Client client;


    @BeforeClass
    public void setUp() {

        client = new Client();
    }

    @Test (priority = 1)
    public void testCreateUserAPI() {
        User createUserReq = new User("Rahul", "SDET");
        response = client.createUserResponse(createUserReq);
        User responseUser = response.as(User.class);
        Assert.assertEquals(responseUser.getName(), "Rahul");
        Assert.assertEquals(responseUser.getJob(), "SDET");

    }

    @Test(priority = 2)
    public void testUpdateUser(){
        User UpdateUserReq = new User("Rahul1", "SDET1");
        response =  client.updateUserResponse(UpdateUserReq);
        User responseUser = response.as(User.class);
        Assert.assertEquals(responseUser.getName(), "Rahul1");
        Assert.assertEquals(responseUser.getJob(), "SDET1");
    }

    @Test(priority = 3)
    public void testGetUser(){
        User userReq = new User("2");
        System.out.println(userReq.getId());
        response =  client.getUserResponse(userReq);
        UserResponse responseUser = response.as(UserResponse.class);
        //Assert.assertEquals(responseUser.getData()., "Rahul1");
        //Assert.assertEquals(responseUser.getJob(), "SDET1");
    }

    @Test(priority = 3)
    public void testDeleteUser(){
        User userReq = new User("2");
        System.out.println(userReq.getId());
        response =  client.deleteUserResponse(userReq);
        UserResponse responseUser = response.as(UserResponse.class);

    }
}
