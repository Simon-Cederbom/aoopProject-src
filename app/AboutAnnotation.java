package app;

import java.lang.annotation.Documented;

@Documented
public @interface AboutAnnotation {
	String version();
	String author();
	String date();
	String purpose() default "This program was created as a project in the course<br/>Advanced Object Oriented Programming at Halmstad University";
}
