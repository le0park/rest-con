package com.example.restcon.service.supports;

import java.io.ByteArrayOutputStream;

import org.apache.logging.log4j.util.Strings;

import com.example.restcon.service.models.SshKeyPair;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.KeyPair;

public class SshKeyPairFactory {
	static final int KEY_SIZE = 2048;
	static final int KEY_ALGORITHM = KeyPair.RSA;

	public static SshKeyPair create() {
		ByteArrayOutputStream bytePublicKey = new ByteArrayOutputStream();    // 공개키
		ByteArrayOutputStream bytePrivateKey = new ByteArrayOutputStream();    // 개인키

		KeyPair keyPair = null;
		try {
			keyPair = KeyPair.genKeyPair(new JSch(), KEY_ALGORITHM, KEY_SIZE);
			keyPair.writePublicKey(bytePublicKey, Strings.EMPTY);
			keyPair.writePrivateKey(bytePrivateKey);
			return new SshKeyPair(bytePublicKey.toString(), bytePrivateKey.toString());
		} catch (JSchException e) {
			throw new IllegalArgumentException("JSch KeyPair create fail.", e);
		} finally {
			if (keyPair != null) {
				keyPair.dispose();
			}
		}
	}
}
