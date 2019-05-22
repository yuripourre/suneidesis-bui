package com.harium.suneidesis.aal.input;

import org.junit.Assert;
import org.junit.Test;

public class ActionTest {

    @Test
    public void testPressMultipleKeys() {
        Action action = new Action().press("shift").type("F6").release("shift");

        Assert.assertEquals(5, action.inputs().size());
        Assert.assertEquals(InputAction.PRESS, action.inputs().get(0).action());
    }

}
