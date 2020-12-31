package com.user00.coronavirus;


import com.user00.coronavirus.Models.User;
import com.user00.coronavirus.Utils.Utils;

import org.junit.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class UTest {
    User user;
    Utils u ;

    @BeforeClass
    public static   void BeforeClass(){
        System.out.println("BeforeClass");
    }
    @Before
    public void Before(){
        u = new Utils();
        user = new User("mohanad@gmail.com", "264813579", "1355792468", "mohanad sh", null, null,"I am a web developer2021",
                System.currentTimeMillis(),
                true,
                false); }
    @Test
    public void validate_email(){

        System.out.println("validate email");
        assertTrue(u.validateEmail(user.getEmail()));
    }

    @Test
    public void validate_Password(){

        System.out.println("validate Password");
        assertTrue(u.validatePassword(user.getPassword()));
    }

    @Test
    public void validate_Name(){
        System.out.println("validate Name");
        assertFalse(u.validatePassword(user.getName()));
    }

    @Test
    public void validate_Mobile(){
        System.out.println("validate Mobile");
        assertFalse(u.validatePassword(user.getMobile()));
    }

    @Test
    public void Sign_up_with_email(){
        System.out.println("Sign up with email");
        assertTrue(u.validateEmail(user.getEmail()));
    }


    @Test
    public void Sign_up_with_Password(){

        System.out.println("Sign up with password");
        assertTrue(u.validateEmail(user.getPassword()));

    }
    @After
    public  void After(){
        System.out.println("After");
    }
    @AfterClass
    public static void AfterClass(){
        System.out.println("AfterClass");
    }

}
