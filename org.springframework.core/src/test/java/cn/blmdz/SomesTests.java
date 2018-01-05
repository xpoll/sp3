package cn.blmdz;

import org.springframework.core.JdkVersion;

public class SomesTests {

	public static void main(String[] args) {
		System.out.println(System.getProperty("java.version"));
		System.out.println(JdkVersion.getJavaVersion());
		System.out.println(JdkVersion.getMajorJavaVersion());
		
	}
}
