package com.example.crud.service;

import java.util.List;

import com.example.crud.entity.Mobile;

public interface MobileService {
	Mobile saveMobile(Mobile mobile);
	List<Mobile> getAllMobiles();
	Mobile getMobileById(long id);
	Mobile updateMobile(Mobile mobile, long id);
	void deleteMobile(long id);
}
