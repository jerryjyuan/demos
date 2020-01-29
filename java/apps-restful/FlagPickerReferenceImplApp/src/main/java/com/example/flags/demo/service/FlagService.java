package com.example.flags.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flags.demo.model.Flag;
import com.example.flags.demo.repo.FlagRepository;

@Service
public class FlagService {

	@Autowired
	private FlagRepository flagRepo;
	
	public Flag getFlag(Long id) {
		Optional<Flag> obj = flagRepo.findById(id);
		if (obj != null) {
			return (Flag)obj.get();
		} else
			return null;
	}

	public List<Flag> getAllFlags() {
		return flagRepo.findAll();
	}

	public void createFlag(Flag flag) {
		flagRepo.save(flag);		
	}

	public void updateFlag(Flag flag) {
		flagRepo.save(flag);
	}

	public void deleteFlag(Long id) {
		flagRepo.deleteById(id);
	}

	public List<Flag> findAll() {
		return flagRepo.findAll();
	}

}
