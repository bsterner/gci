package com.gci.api.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;

import com.gci.api.Constants;

public class ContractUtil {

	public static String createRandomSiteName() {
		return new StringBuilder(Constants.SITE_PREFIX).append(
		        RandomStringUtils.randomAlphanumeric(Constants.RANDOM_SITE_NAME_LENGTH)).toString();
	}

	public static String createRandomServiceName() {
		return new StringBuilder(Constants.SERVICE_PREFIX).append(
		        RandomStringUtils.randomAlphanumeric(Constants.RANDOM_SERVICE_NAME_LENGTH)).toString();
	}

	public static Date createRandomDate(int daysFromNow) {
		Date today = new Date();
		return new Date(today.getTime() + TimeUnit.MILLISECONDS.convert(90, TimeUnit.DAYS));
	}

}
