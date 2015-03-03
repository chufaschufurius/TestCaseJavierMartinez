package com.nicajaowk.javi.testcase;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class MyApplicationTest extends ActivityInstrumentationTestCase2<Login> {
    public MyApplicationTest() {
        super(Login.class);
    }

    private TextView lblGotoRegister;
    private Button btnLogin;
    private EditText inputEmail;
    private EditText inputPassword;

    private Login activity;

    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
        lblGotoRegister = (TextView) activity.findViewById(R.id.link_to_rememberPass);
        inputEmail = (EditText) activity.findViewById(R.id.txtEmail);
        inputPassword = (EditText) activity.findViewById(R.id.txtPass);
        btnLogin = (Button) activity.findViewById(R.id.btnLogin);
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    private static final String USER_1 = "javi";
    private static final String PASS_1="javiPass";
    private static final String USER_2 = "jorge";
    private static final String PASS_2="jorgePass";
    private static final String PASS_RESULT = "javiPass";

    public void testPreconditions(){
        assertNotNull(inputEmail);
        assertNotNull(inputPassword);
    }

    public void testLoginCorrect() {
        //on value 1 entry
        TouchUtils.tapView(this, inputEmail);
//        getInstrumentation().sendKeySync();

        TouchUtils.tapView(this, inputPassword);
        sendKeys(PASS_1);


// now on Add button
//        TouchUtils.clickView(this, btnLogin);

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                inputEmail.setText("javi");
                inputPassword.setText("javiPass");
//                TouchUtils.clickView(this, btnLogin);
            }
        });
//        inputPassword.setText(PASS_1);
//        TouchUtils.clickView(this, btnLogin);
//        assertTrue("javi".equals(inputEmail.getText()));
        assertTrue("javiPass".equals(inputPassword.getText()));
    }



}