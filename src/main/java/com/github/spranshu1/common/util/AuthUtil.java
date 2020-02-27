/**
 * @author pranshu.shrivastava
 */
package com.github.spranshu1.common.util;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.igtb.jose.JWSUtils;
import com.igtb.jose.model.JWS;
import com.nimbusds.jose.JOSEException;


/**
 * Provides common helper methods, useful for JWS signing/verification.
 */
public final class AuthUtil {

	/** The logger. */
	private static final Logger logger = LoggerFactory.getLogger(AuthUtil.class);
	
	/**
	 * Instantiates a new auth util.
	 */
	private AuthUtil() {
		// constructor intentionally kept empty
	}
	
	/**
	 * Signature.
	 *
	 * @param payload the payload
	 * @return the string
	 * @throws JOSEException the JOSE exception
	 */
	public static String signature(final String payload,final String privateKeyId, final Map<String, String> privateKeyMap) throws JOSEException {
		logger.debug("called with {}", payload);

		String signature = null;
		try {
			final JWS jwsObject = JWSUtils.getJWSBuilder(privateKeyId).payload(payload).build();
			signature = JWSUtils.sign(jwsObject, privateKeyMap).split("\\.")[2];
		} catch (IllegalArgumentException | IllegalStateException | NoSuchAlgorithmException | InvalidKeySpecException
				| IOException ex) {
			logger.error("{} - Exception signing the payload : {}","SYS_DATA_TEMPERING", ex.getMessage(), ex);
			throw new JOSEException(ex.getMessage(), ex);
		}

		logger.debug("returning {}", signature);
		return signature;
	}	
	


}
