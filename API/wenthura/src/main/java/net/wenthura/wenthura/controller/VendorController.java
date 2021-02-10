package net.wenthura.wenthura.controller;

import net.wenthura.wenthura.exception.ResourceNotFoundException;
import net.wenthura.wenthura.model.Vehicle;
import net.wenthura.wenthura.model.Vendor;
import org.springframework.http.ResponseEntity;
import net.wenthura.wenthura.repository.VendorRepository;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "vendor")
public class VendorController {
	
	private byte[] bytes;

	@Autowired
	private VendorRepository vendorRepository;
	
	@GetMapping("/get")
	public List<Vendor> getBooks() {
		return vendorRepository.findAll();
	}
	
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.bytes = file.getBytes();
	}

	@PostMapping("/add")
	public void createBook(@RequestBody Vendor vendor) throws IOException {
		vendor.setPicByte(this.bytes);
		vendorRepository.save(vendor);
		this.bytes = null;
	}


	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteVendor(@PathVariable(value = "id") Long vendorId)
			throws ResourceNotFoundException {
		Vendor vendor = vendorRepository.findById(vendorId)
				.orElseThrow(() -> new ResourceNotFoundException("Vehicle not found for this id :: " + vendorId));
		vendorRepository.delete(vendor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


	@PutMapping("/update")
	public void updateBook(@RequestBody Vendor vendor) {
		vendorRepository.save(vendor);
	}
//
//	@PutMapping("/update")
//	public ResponseEntity<Vendor> updateBook(@PathVariable(value = "id") Long vendorId,
//												@Valid @RequestBody Vendor vendorDetails) throws ResourceNotFoundException {
//		Vendor vendor = vendorRepository.findById(vendorId)
//				.orElseThrow(() -> new ResourceNotFoundException("Vehicle not found for this id :: " + vendorId));
//
//
//		vendor.setAuthor(vendorDetails.getAuthor());
//		vendor.setName(vendorDetails.getName());
//		vendor.setPrice(vendorDetails.getPrice());
//
//		final Vendor updatedVendor = vendorRepository.save(vendor);
//		return ResponseEntity.ok(updatedVendor);
//	}
}
