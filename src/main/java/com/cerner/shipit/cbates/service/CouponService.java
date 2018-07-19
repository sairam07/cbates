package com.cerner.shipit.cbates.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cerner.shipit.cbates.model.Coupon;

@Service
public class CouponService {

	private static final Logger logger = LoggerFactory.getLogger(CouponService.class);
	String couponName = null;

	private ArrayList<Coupon> sampleCouponList = new ArrayList<Coupon>(
			Arrays.asList(new Coupon("Apple", "https://apple.com"), new Coupon("Google", "https://google.com"),
					new Coupon("Facebook", "https://facebook.com"), new Coupon("Dell", "https://dell.com")));

	public List<Coupon> getAll() {
		logger.info("At coupon Service->getAll() ");
		Collections.sort(sampleCouponList);
		return sampleCouponList;
	}

	public Coupon searchCoupon(String url) {
		logger.info("At coupon search Service -> " + url);
		ArrayList<Coupon> couponList = new ArrayList<>();
		String fields[] = null;

		if (url != null && !url.isEmpty())
			fields = url.split("\\.");

		if (fields != null && fields.length > 2)
			couponName = fields[1].toLowerCase();

		logger.info("Identified Coupon was:" + couponName);

		return searchCouponWithName(couponName);
	}

	public Coupon updateCoupon(Coupon couponUpdate, String couponName) {
		logger.info("At coupon update Service -> " + couponName);
		Coupon coupon = searchCouponWithName(couponName);
		coupon.setLastUpdated(new Date());
		updateCouponStatus(couponUpdate, coupon);
		return coupon;
	}

	private Coupon searchCouponWithName(String couponName) {

		for (Coupon coupon : sampleCouponList) {
			if (coupon.getCouponName().toLowerCase().equals(couponName)) {
				return coupon;
			}
		}
		return null;
	}

	private void updateCouponStatus(Coupon couponUpdate, Coupon coupon) {
		if (couponUpdate.getLastUpdatedStatus()) {
			coupon.setWorkedCount(coupon.getWorkedCount() + 1);
			coupon.setLastUpdatedStatus(true);
		} else {
			coupon.setNotWorkedCount(coupon.getNotWorkedCount() + 1);
			coupon.setLastUpdatedStatus(false);
		}
	}

}
