package com.app.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.BankAccount;
import com.app.service.IBankAccountService;

@RestController
public class BankAccountRestController {
	@Autowired
	private IBankAccountService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveAccount(@RequestBody BankAccount ba){
		ResponseEntity<String> res=null;
		try {
			service.saveBankAccount(ba);
			res=new ResponseEntity<String>("account created sucessfully", HttpStatus.OK);
		} catch (Exception  e) {
		e.printStackTrace();
		
		res=new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return res;
	}
	
	@GetMapping("/one/{id}")
	public ResponseEntity<?> getOneAccount(@PathVariable Integer id){
		ResponseEntity<?> res=null;
		try {
			BankAccount one = service.getOneAccount(id);
			if(one!=null) {
				res=new ResponseEntity<BankAccount>(one, HttpStatus.OK);
			}
			else {
				res=new ResponseEntity<String>("There is no record present based on that id: "+id, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res=new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return res;
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllAccounts(){
		ResponseEntity<?> res=null;
		try {
			List<BankAccount> list = service.getAllAccounts();
			if(list.isEmpty()||list==null) {
				res=new ResponseEntity<String>("No data found",HttpStatus.OK);
			}
			else {
				res=new ResponseEntity<List<BankAccount>>(list, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res=new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return res;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOneAccount(@PathVariable Integer id){
		ResponseEntity<String> res=null;
		try {
			service.deleteAccount(id);
			res=new ResponseEntity<String>("record deletd sucessfully", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			res=new ResponseEntity<String>("There is no record to delete", HttpStatus.BAD_REQUEST);
		}
		return res;
	}
	@PutMapping("/update")
	public ResponseEntity<String> updateAccount(@RequestBody BankAccount b){
		ResponseEntity<String> res=null;
		try {
			boolean exist = service.isExist(b.getId());
			if(exist) {
				service.saveBankAccount(b);
				res=new ResponseEntity<String>("record updated sucessfully",HttpStatus.OK);
			}
			else {
				res=new ResponseEntity<String>("there is no record ", HttpStatus.OK);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			res=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return res;
	}
}
