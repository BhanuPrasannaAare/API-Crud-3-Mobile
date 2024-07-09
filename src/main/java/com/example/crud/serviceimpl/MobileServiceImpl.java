package com.example.crud.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.entity.Mobile;
import com.example.crud.repository.MobileRepository;
import com.example.crud.service.MobileService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MobileServiceImpl implements MobileService {

	@Autowired
	private MobileRepository mobileRepository;

	@Override
	public Mobile saveMobile(Mobile mobile) {
		return mobileRepository.save(mobile);
	}

	@Override
	public List<Mobile> getAllMobiles() {
		return mobileRepository.findAll();
	}

	@Override
	public Mobile getMobileById(long id) {
		Optional<Mobile> optMobile = mobileRepository.findById(id);
		return optMobile.get();
	}

	@Override
	public Mobile updateMobile(Mobile mobile, long id) {
		Mobile mb = mobileRepository.findById(id).get();
		mb.setName(mobile.getName());
		mb.setCamera(mobile.getCamera());
		mb.setRam(mobile.getRam());
		mb.setRom(mobile.getOs());
		mb.setBattery(mobile.getBattery());
		mb.setQuantity(mobile.getQuantity());
		mobileRepository.save(mb);
		return mb;
	}

	@Override
	public void deleteMobile(long id) {
		mobileRepository.findById(id).get();
		mobileRepository.deleteById(id);
	}
}
