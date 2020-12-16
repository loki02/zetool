package com.zetool.beancopy;


import com.zetool.beancopy.checkor.Checker;
import com.zetool.beancopy.handler.Copier;
import com.zetool.beancopy.handler.SimpleClassScanner;
import com.zetool.beancopy.helper.FieldContent;
import com.zetool.beancopy.javabean.A;
import com.zetool.beancopy.javabean.B;
import com.zetool.beancopy.javabean.C;
import com.zetool.beancopy.javabean.Default;
import com.zetool.beancopy.javabean.Except;
import com.zetool.beancopy.javabean.HumpToUnderLine;
import com.zetool.beancopy.javabean.UnderLineToHump;
import com.zetool.beancopy.util.Log;

public class App2 {
	public static void main(String[] args) {
//		Log.LEVEL = Log.WORN;
//		Log.logger = new StdLog();

		checkTest();

		checkMultCopy();


		baseTypeCopyTest();

		simpleCopyTest();
		
		copyTest();

		multCopyTest();
		
		underLineToHumpTest();
		
		HumpToUnderLineTest();
		
		exceptTest();
	}
	
	/**
	 * 测试 except 选项
	 */
	public static void exceptTest() {
		Default a = new Default();
		Except a2 = Copier.copy(a, Except.class);
		Log.info(App2.class, "拷贝后的a2为:" + FieldContent.toString(a2));
	}
	
	/**
	 * 测试  驼峰映射对 下划线
	 */
	public static void HumpToUnderLineTest() {
		UnderLineToHump a = new UnderLineToHump();
		HumpToUnderLine a2 = Copier.copy(a, HumpToUnderLine.class);
		Log.info(App2.class, "拷贝后的a2为:" + FieldContent.toString(a2));
	}
	
	/**
	 * 测试 下划线对 驼峰映射
	 */
	public static void underLineToHumpTest() {
		Default a = new Default();
		UnderLineToHump a2 = Copier.copy(a, UnderLineToHump.class);
		Log.info(App2.class, "拷贝后的a2为:" + FieldContent.toString(a2));
	}
	
	public static void checkTest() {
		Checker.check(
						new SimpleClassScanner().addClassesByClassName(A.class.getName())
				);
	}
	
	/**
	 * 检查允许多个CopyFrom注解
	 */
	public static void checkMultCopy(){
		Checker.check(
						new SimpleClassScanner().addClassesByClassName(A.class.getName())
				);
	}

	/**
	 * 运行多个注解情况下的拷贝
	 */
	public static void baseTypeCopyTest(){
		Integer[] arr = {Integer.valueOf(1), Integer.valueOf(2)};
		Integer[] arr2 = Copier.copy(arr);
		Log.info(App2.class, "拷贝后的A为:" + FieldContent.toString(arr2));
	}
	
	/**
	 * 运行多个注解情况下的拷贝
	 */
	public static void simpleCopyTest(){
		A a = new A();
		A a2 = Copier.copy(a);
		Log.info(App2.class, "拷贝后的A为:" + FieldContent.toString(a2));
	}
	
	/**
	 * 运行多个注解情况下的拷贝
	 */
	public static void multCopyTest(){
		A a = new A();
		B b = Copier.copy(a, B.class);
		Log.info(App2.class, "拷贝后的B为:" + FieldContent.toString(b));
		C c = Copier.copy(a,  C.class);
		Log.info(App2.class, "拷贝后的C为:" + FieldContent.toString(c));
	}
	
	public static void copyTest() {
		A a = new A();
		B b = Copier.copy(a, B.class);
		Log.info(App2.class, "拷贝后的B为:" + FieldContent.toString(b));
	}
	

}
