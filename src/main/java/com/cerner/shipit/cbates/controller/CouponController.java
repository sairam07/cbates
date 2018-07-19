package com.cerner.shipit.cbates.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cerner.shipit.cbates.model.Coupon;
import com.cerner.shipit.cbates.service.CouponService;

@RestController
@RequestMapping("/cbates")
public class CouponController {

	private CouponService couponService = new CouponService();
	private static final Logger logger = LoggerFactory.getLogger(CouponController.class);

	@RequestMapping("/coupons")
	public List<Coupon> getAllCoupons() {
		logger.info("At Get All Controller");
		return couponService.getAll();
	}

	@RequestMapping(value = "/{url}", produces = { "application/json" }, consumes = "text/html")
	public Coupon searchByURL(@PathVariable("url") String url) {
		logger.info("At coupon Controller->" + url);
		return couponService.searchCoupon(url);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{couponName}", produces = { "application/json" }, consumes = {
			"application/json" })
	public Coupon updateCoupon(@RequestBody Coupon coupon, @PathVariable String couponName) {
		logger.info("At coupon update Controller->" + coupon.getCouponName());
		return couponService.updateCoupon(coupon, couponName);
	}

	@RequestMapping("/hello")
	public String sayHello() {
		return "Your cBates Application was running";
	}

}
