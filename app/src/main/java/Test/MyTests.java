package Test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nicajaowk.javi.testcase.Login;
import com.nicajaowk.javi.testcase.R;

/**
 * Created by CHUFASCHIN on 01/03/2015.
 */
public class MyTests extends ActivityInstrumentationTestCase2<Login> {
    public MyTests() {
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
        getInstrumentation().sendStringSync("javi");

        TouchUtils.tapView(this, inputPassword);
        getInstrumentation().sendStringSync("javiPass");

        TouchUtils.clickView(this, btnLogin);
    }



}
