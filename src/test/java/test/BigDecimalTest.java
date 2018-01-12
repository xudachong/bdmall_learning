package test;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Author: XuJuLong<5 7 4 4 0 8 5 7 8 @ qq.com>
 * @Description:
 * @Date: Created in 21:39 2018/1/9
 * @
 */
public class BigDecimalTest {

	@Test
	public void test1(){
		System.out.println(0.05+0.01);
		System.out.println(1.0-0.42);
		System.out.println(4.015*100);
		System.out.println(123.3/100);
	}

	@Test
	public void test2(){
		BigDecimal b1= new BigDecimal(0.05);
		BigDecimal b2= new BigDecimal(0.01);
		System.out.println(b1.add(b2));
	}

	@Test
	public void test3(){
		BigDecimal b1= new BigDecimal("0.05");
		BigDecimal b2= new BigDecimal("0.01");
		System.out.println(b1.add(b2));
	}

}
