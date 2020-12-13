package johngrib;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * http://csc.columbusstate.edu/woolbright/java/designpatterns2.html
 * InputStream (추상 component 역할)
 * - FileInputStream
 * - StringBufferInputStream
 * - FilterInputStream (추상 decorator 역할)
 *   > BufferedInputStream
 *   > LowerCaseInputStream
 *
 */
public class LowerCaseInputStreamRunner {
	public static void main(String[] args) throws IOException {
		int charIn;
		try {
			FileInputStream fis = new FileInputStream("/tmp/upper.dat");
			BufferedInputStream bis = new BufferedInputStream(fis);

			InputStream is = new LowerCaseInputStream(bis);

			while ((charIn = is.read()) >= 0)
				System.out.print((char) charIn);
		} catch (IOException excp) {
			System.err.println("An IOException occurred");
			System.out.println(excp);
		}
	}
}
