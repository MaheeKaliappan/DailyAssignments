package formValidation.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class RegexUsingValidation {

	static Pattern pattern;
	static Matcher matcher;
	private static boolean nameValidation(String name) {
		pattern = Pattern.compile("^[a-zA-Z]{6,15}$");
		matcher = pattern.matcher(name);
		return matcher.matches();
		
	}
	private static boolean emailValidation(String emailIdValidation) {
		pattern = Pattern.compile("[A-Za-z0-9+_.-]+@(.+)");
		matcher = pattern.matcher(emailIdValidation);
		return matcher.matches();
		
	}
	private static boolean mobileNumberValidation(String mobileNumber) {
		pattern = Pattern.compile( "^[6-9][0-9]{9}$");
		matcher = pattern.matcher(mobileNumber);
		return matcher.matches();
	}
	private static boolean aadharNumberValidation(String aadharNumber) {
		pattern = Pattern.compile( "^[0-9]{16}$");
		matcher = pattern.matcher(aadharNumber);
		return matcher.matches();
	}

}
