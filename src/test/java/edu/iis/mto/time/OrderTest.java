package edu.iis.mto.time;

import edu.iis.mto.time.Order;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import org.mockito.Mockito.when;
import org.powermock.api.mockito.PowerMockito.mockStatic;


import org.joda.time.DateTime;

@RunWith(PowerMockRunner.class)
@PrepareForTest(OrderTime.class)
public class OrderTest {
	
	private DateTime time;
	private Order order;
	
	@Before
	public void setUp () {
		mockStatic(OrderTime.class);
		
		time = DateTime.now().plusDays(2);
		
		when(OrderTime.getTime()).thenReturn(time);
		
		order = new Order();
	}

    @Test(expected=OrderExpiredException.class)
    public void test() {
        order.submit();
        order.confirm();
    }
}