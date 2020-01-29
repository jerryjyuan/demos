package com.example.flags.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.flags.demo.service.FlagService;
import com.example.flags.demo.model.Flag;

@RestController
@RequestMapping("/flags")
public class FlagController {

	@Autowired
	private FlagService repoService;
	
	@GetMapping("/get/{id}")
	public @ResponseBody Flag getFlag(@PathVariable String id) {
		return repoService.getFlag(Long.valueOf(id));
	}
	
	@GetMapping("/getAll")
	public @ResponseBody List<Flag> getAllFlags() {
		return repoService.getAllFlags();
	}

	@PostMapping("/create")
	public @ResponseBody String createFlag(@RequestBody Flag flag) {
		repoService.createFlag(flag);
		return "Flag has been created successfully";
	}

	@PostMapping("/update/{id}/{flag}")
	public @ResponseBody String updateFlag(@PathVariable String id, @PathVariable String flag) {
		Flag flagObj = repoService.getFlag(Long.valueOf(id));
		flagObj.setFlag(flag);
		repoService.updateFlag(flagObj);
		return "Flag has been updated successfully";
	}

	@DeleteMapping("/delete/{id}")
	public @ResponseBody String deleteFlag(@PathVariable String id) {
		repoService.deleteFlag(Long.valueOf(id));
		return "Flag has been deleted successfully";
	}

}
