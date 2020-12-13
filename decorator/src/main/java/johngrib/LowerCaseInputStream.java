package johngrib;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStream extends FilterInputStream {

	/**
	 * Constructor for objects of class LowerCaseInputStream
	 */
	public LowerCaseInputStream(InputStream is) {
		super(is);
	}

	public int read() throws IOException {
		int charIn = super.read();  //grab a character as an int
		if (charIn != -1)
			return Character.toLowerCase((char) charIn);
		else
			return charIn;
	}

	public int read(byte[] b, int offset, int len) throws IOException {
		int noBytes = super.read(b, offset, len);
		for (int i = offset; i < offset + noBytes; i++) {
			b[i] = (byte) Character.toLowerCase((char) b[i]);
		}
		return noBytes;
	}
}

